package com.objectpartners.oauth2

import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder

class User {

  transient passwordEncoder = new PlaintextPasswordEncoder()

  String username
  String email
  String phone
  String password
  boolean enabled
  boolean accountExpired
  boolean accountLocked
  boolean passwordExpired

  static constraints = {
    username blank: false, unique: true
    password blank: false
  }

  static mapping = {
    password column: '`password`'
  }

  Set<Role> getAuthorities() {
    UserRole.findAllByUser(this).collect { it.role } as Set
  }

  def beforeInsert() {
    encodePassword()
  }

  def beforeUpdate() {
    if (isDirty('password')) {
      encodePassword()
    }
  }

  protected void encodePassword() {
    password = passwordEncoder.encodePassword(password, null)
  }
}
