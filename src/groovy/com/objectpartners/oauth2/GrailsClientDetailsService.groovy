package com.objectpartners.oauth2

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception
import org.springframework.security.oauth2.provider.BaseClientDetails
import org.springframework.security.oauth2.provider.ClientDetails
import org.springframework.security.oauth2.provider.ClientDetailsService
import org.springframework.security.oauth2.provider.NoSuchClientException

/**
 * User: danielwoods
 * Date: 8/23/13
 */
class GrailsClientDetailsService implements ClientDetailsService {
  @Override
  ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {
    Client.withNewSession {
      def clientInstance = Client.findByClientId(clientId)

      if (!clientInstance) {
        throw new NoSuchClientException("Client [$clientId] not found!")
      }

      def clientDetails = new BaseClientDetails()
      clientDetails.setAuthorizedGrantTypes clientInstance.authorizationGrants*.authority
      clientDetails
    }
  }
}
