class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/index")
        "500"(view:'/error')

        "/home"{
            controller = "placeOfSound"
            action = "index"
        }

        "/submit_instrument"{
            controller = "placeOfSound"
            action = [GET: "getInstrumentForm", POST: "submitInstrument"]
        }

        "/user/sign_in"{
            controller = "placeOfSound"
            action = [GET: "getSignInForm", POST: "signIn"]
        }

        "/user/sign_up"{
            controller = "placeOfSound"
            action = [GET: "getSignUpForm", PUT: "signUp"]
        }
	}
}
