package com.anil.Jersey_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

import java.sql.*;

public class Name_repo {
	Connection con = null;
	public Name_repo(){
		
		String url = "jdbc:mysql://localhost:3306/jerseydb";
		String user = "root";
		String pass = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
}
	public List<Name> getnames()
	{
		
		List<Name> names = new ArrayList<>();
		String query = "select * from data1";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Name obj = new Name();
				obj.setFname(rs.getString(1));
				obj.setMname(rs.getString(2));
				obj.setLname(rs.getString(3));
				names.add(obj);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return names;
	}
	public Name getname(String fname)
	{	System.out.println("repo");
		String query = "select * from data1 where mname="+fname;
		System.out.println(query);
		Name obj=null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				obj = new Name();
				obj.setFname(rs.getString(1));
				obj.setMname(rs.getString(2));
				obj.setLname(rs.getString(3));
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("repo3");
		return obj;
		
	}
	
	public void create_obj(Name nobj) {
		
		String query = "insert into data1 values(?,?,?,?)";
		Name obj=null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, nobj.getFname());
			st.setString(2, nobj.getMname());
			st.setString(3, nobj.getLname());
			st.setInt(4,4);
			
			st.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
public void update_obj(Name nobj) {
		
		String query = "update data1 set fname =?  where lname=?";
		Name obj=null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			
			//st.setString(2, nobj.getFname());
			st.setString(1, nobj.getFname());
			st.setString(2, nobj.getLname());
			//st.setInt(2,4);
			
			st.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
