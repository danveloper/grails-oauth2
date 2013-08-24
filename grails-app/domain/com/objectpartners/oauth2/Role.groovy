package com.objectpartners.oauth2

class Role {

  String authority

  static mapping = {
    cache true
  }

  static constraints = {
    authority blank: false, unique: true
  }
}
