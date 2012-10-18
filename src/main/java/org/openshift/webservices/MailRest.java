package org.openshift.webservices;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.openshift.data.DBConnection;

import com.mongodb.DB;


//Comment so we can deploy again
@Stateless
@Path("/ws")
public class MailRest {
	
	@Inject 
	private DBConnection dbConnection;
	//private DB db = dbConnection.getDB();
	String message = dbConnection.getMessage();

	@GET()
	@Produces("text/plain")
	public String sayHello() {
	    return "Hello World In Both Places";
	}
	
	
	@GET()
	@Path("notes")
	@Produces("text/plain")
	public String getNotes(){
		
		
		return "This will be a DB call soon:" + message;
	}
}
