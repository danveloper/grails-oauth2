package com.objectpartners.oauth2

class AuthController {

  def login() {
  }

  def logout() {
    redirect action: 'login', params: [loggedOut: true]
  }
}
