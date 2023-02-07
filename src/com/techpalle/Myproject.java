package com.techpalle;

import java.sql.SQLException;
import java.util.ArrayList;

public class Myproject {

	public static void main(String[] args) 
	{
		 
		// Student.creating()   
		Student.read(); 
		 try 
		 {
			//Student.inserting("Jack","Java","jack123@gmail.com");
			//Student.inserting("Prakash","HTML","prakash123@gmail.com");
			//Student.inserting("Rajesh","CSS","Rajesh123@gmail.com");
			// Student.update(2,"Vjay","Javascript","vijay123@gmail.com");
			 Student.deleting(3);
			 
		/*	  ArrayList<Student> res1=Student.reading();  //overloading
			  for(Student item:res1)
			  {
				System.out.println(item.sno);
				System.out.println(item.sname);
				System.out.println(item.sub);
				System.out.println(item.email);
				
				System.out.println("********");
			  } */
			
			//Student.read();
		} 
		 catch (ClassNotFoundException e)
		 {
			e.printStackTrace();
		}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}
	}

}
