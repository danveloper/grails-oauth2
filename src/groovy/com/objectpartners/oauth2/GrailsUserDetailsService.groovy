package com.objectpartners.oauth2

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

/**
 * User: danielwoods
 * Date: 8/23/13
 */
class GrailsUserDetailsService implements UserDetailsService {
  @Override
  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    def user = User.findByUsername(username)

    if (!user) {
      throw new UsernameNotFoundException("No such user $username.")
    }

    def grantedAuthorities = user.withNewSession { user.authorities.collect { new SimpleGrantedAuthority(it.authority) } }
    new org.springframework.security.core.userdetails.User(user.username, user.password, grantedAuthorities)
  }
}
