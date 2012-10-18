package org.openshift.webservices;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//Comment so we can deploy again

@Path("/ws")
public class MailRest {

	@GET()
	@Produces("text/plain")
	public String sayHello() {
	    return "Hello World In Both Places";
	}
}
