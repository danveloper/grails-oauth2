class UrlMappings {

	static mappings = {
    "/oauth/confirm_access"(controller: "oauth", action: "confirm")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
