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
	}
}
