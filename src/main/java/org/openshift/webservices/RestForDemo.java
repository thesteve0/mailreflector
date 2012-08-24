package org.openshift.webservices;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;

public class RestForDemo extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	public RestForDemo(){
	     singletons.add(new MailRest());
	}
	@Override
	public Set<Class<?>> getClasses() {
	     return empty;
	}
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}
}
