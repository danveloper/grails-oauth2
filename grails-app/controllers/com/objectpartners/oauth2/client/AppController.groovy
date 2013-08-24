package com.objectpartners.oauth2.client

import grails.converters.JSON

class AppController {

    def doAuth() {
      render ([success: true, appName: "oauth-consumer-app", code: params.code] as JSON)
    }
}
