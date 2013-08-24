import com.objectpartners.oauth2.Client
import com.objectpartners.oauth2.Grant
import com.objectpartners.oauth2.Role
import com.objectpartners.oauth2.User
import com.objectpartners.oauth2.UserRole

class BootStrap {

  def init = { servletContext ->
    new Role(authority: "ROLE_USER").save(flush: true)

    "create dan user"()
    "create grant types"()
    "create client app"()
  }

  void "create dan user"() {
    def user = new User().with {
      username = "dan"
      password = "password"
      email = "daniel.woods@objectpartners.com"
      phone = "800-555-1212"
      save flush: true
    }

    UserRole.create user, Role.findByAuthority("ROLE_USER"), true
  }

  void "create grant types"() {
    new Grant(authority: "authorization_code").save(flush: true)
    new Grant(authority: "implicit").save(flush: true)
  }

  void "create client app"() {
    new Client(clientId: "oauth-consumer-app").with {
      addToAuthorizationGrants Grant.findByAuthority("authorization_code")
      addToAuthorizationGrants Grant.findByAuthority("implicit")
      save flush: true
    }
  }

  def destroy = {
  }
}
