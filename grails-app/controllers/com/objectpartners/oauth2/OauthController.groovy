package com.objectpartners.oauth2

import org.springframework.security.oauth2.provider.AuthorizationRequest
import org.springframework.security.oauth2.provider.ClientDetails
import org.springframework.security.oauth2.provider.ClientDetailsService
import org.springframework.web.bind.annotation.SessionAttributes

@SessionAttributes("authorizationRequest")
class OauthController {

  ClientDetailsService clientDetailsService

  def confirm() {
    AuthorizationRequest request = params.authorizationRequest
    ClientDetails clientDetails = clientDetailsService.loadClientByClientId(req.clientId)

    [client: clientDetails]
  }
}
