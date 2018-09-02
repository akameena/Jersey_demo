package com.anil.Jersey_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Name_repo {
	
	List<Name> names;
	public Name_repo(){
		names = new ArrayList<>();
		Name obj1 = new Name();
		obj1.setFname("anil");
		obj1.setLname("meena");
		obj1.setMname("kumar");
		
		Name obj2 = new Name();
		obj2.setFname("harish");
		obj2.setLname("saini");
		obj2.setMname("kumar");
		
		names.add(obj1);
		names.add(obj2);
		
	}
	public List<Name> getnames()
	{
		return names;
	}
	public Name getname(String fname)
	{
		
		for(Name obj:names)
		{
			if(obj.getFname()==fname)
			{
				return obj;
			}
		}
		return null;
	}

}
