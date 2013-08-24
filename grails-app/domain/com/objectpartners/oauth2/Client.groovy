package com.objectpartners.oauth2

import org.hibernate.FetchMode

class Client {

  String clientId

  static hasMany = [authorizationGrants: Grant]

  static constraints = {
  }
}
