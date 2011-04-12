package org.domain.jbpmexample.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Name("authenticator")
public class Authenticator {
	@Logger
	private Log log;

	@In
	Identity identity;
	
	@In
	Credentials credentials;
	
	@In
	Actor actor;

	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		if ("solicitante".equals(credentials.getUsername())) {
			identity.addRole("solicitante");
			actor.setId("solicitante");
			actor.getGroupActorIds().add("solicitante");
			return true;
		}
		if ("revisores".equals(credentials.getUsername())) {
			identity.addRole("revisores");
			actor.setId("revisores");
			actor.getGroupActorIds().add("revisores");
			return true;
		}
		if ("compradores".equals(credentials.getUsername())) {
			identity.addRole("compradores");
			actor.setId("compradores");
			actor.getGroupActorIds().add("compradores");
			return true;
		}
		return false;
	}

}
