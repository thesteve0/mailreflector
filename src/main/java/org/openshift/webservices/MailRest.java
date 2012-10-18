package org.openshift.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.cditest.HelloWorld;
import org.openshift.data.DBConnection;
import org.openshift.data.Note;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;


//Comment so we can deploy again
@RequestScoped
@Path("/notes")
public class MailRest {
	
	@Inject 
	private DBConnection dbConnection;
	
	 @Inject private HelloWorld hello;
	//private DB db = dbConnection.getDB();

	@GET()
	@Produces("application/json")
	public List getNotes(){
		ArrayList<DBObject> allNotes = new ArrayList<DBObject>();
		
		DB db = dbConnection.getDB();
		DBCollection noteCollection = db.getCollection("notes");
		DBCursor cursor = noteCollection.find();
		try {
			while(cursor.hasNext()) {
				allNotes.add(cursor.next());
            }
        } finally {
            cursor.close();
        }

		return allNotes;
	}
	
	@POST()
	@Consumes("application/json")
	@Produces("application/json")
	public String createNote(Note note){
		
		System.out.println("making note");
		BasicDBObject doc = new BasicDBObject();
		
		doc.put("name", note.getName());
		doc.put("note", note.getNote());
		
		System.out.println("getting collection and then insert");
		DB db = dbConnection.getDB();
		db.setWriteConcern(WriteConcern.SAFE);
		DBCollection noteCollection = db.getCollection("notes");
		String dbResponse = noteCollection.insert(doc).toString();
		DBObject myDoc = noteCollection.findOne();
		
		
		
		return doc.toString();
		
		
	}
	
	
	@GET()
	@Path("/test")
	@Produces("text/plain")
	public String sayHello() {
	    return "Hello World In Both Places";
	}
}
