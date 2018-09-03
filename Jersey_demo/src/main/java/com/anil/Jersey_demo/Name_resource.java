package com.anil.Jersey_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("names")
public class Name_resource {
	
	Name_repo repo = new Name_repo();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Name> names()
	{
		return repo.getnames();
				
	}
	
	@GET
	@Path("name/{fname}")
	@Produces(MediaType.APPLICATION_XML )
	public Name name(@PathParam("fname") String fname)
	{
		System.out.println("resource2");
		return repo.getname(fname);
	}
	
	@Path("nameadd")
	@POST
	public Name addname(Name nobj)
	{
		repo.create_obj(nobj);
		System.out.println(nobj);
		return nobj;
	}

}
