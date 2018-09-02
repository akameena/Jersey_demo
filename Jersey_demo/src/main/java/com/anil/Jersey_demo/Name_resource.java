package com.anil.Jersey_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("name")
public class Name_resource {
	
	Name_repo repo = new Name_repo();
	
	@GET
	@Produces(MediaType.APPLICATION_XML )
	public List<Name> names()
	{
		return repo.getnames();
				
	}

}
