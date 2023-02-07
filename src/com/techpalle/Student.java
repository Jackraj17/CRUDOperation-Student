package com.techpalle;

import java.sql.*;
import java.util.ArrayList;

public class Student 
{
	public static int sno;
	public static String sname;
	public static String sub;
	public static String email;
	
	public Student(int no, String name, String sub, String mail)
	{
		super();
		Student.sno = no;
		Student.sname = name;
		Student.sub = sub;
		Student.email = mail;
	}
	public static Connection con=null;
	public static Statement s=null;
	public static PreparedStatement ps=null;
	public static String url="jdbc:mysql://localhost:3306/palle";
	public static String username="root";
	public static String password="Jack@123";
	public static ResultSet rs=null;
	
 public  static void creating() 
 {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con= DriverManager.getConnection(url,username,password);
		 
		 s=con.createStatement();
		 
		 s.execute("create table student(sno int primary key auto_increment,"
		 		+ "sname varchar(50) not null,sub varchar(50),email varchar(80) unique)");
	} 
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	} 
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	finally 
	{
	  if(s!=null)
		{
			try
			{
			s.close();
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
		}
	  if(con!=null)
	  {
			try
			{
			con.close();
			}
		
		catch (SQLException e)
		    {
			e.printStackTrace();
		    }
 	}
  }
 }
 public  static void inserting(String sname,String sub,String email) throws ClassNotFoundException, SQLException
	{
		
			Class.forName("com.mysql.cj.jdbc.Driver");	
			
			con= DriverManager.getConnection(url,username,password);
			 
			ps=con.prepareStatement("insert into student(sname,sub,email)values(?,?,?)"); 
			 
			ps.setString(1,sname);
			ps.setString(2,sub);
			ps.setString(3,email);
			
			ps.executeUpdate();
			ps.close();
			con.close();
	}
 public static void update(int sno,String sname,String sub,String email) throws ClassNotFoundException, SQLException
	{
		
			Class.forName("com.mysql.cj.jdbc.Driver");	
			
			con= DriverManager.getConnection(url,username,password);
			 
			ps=con.prepareStatement("update student set sname=?,sub=?,email=? where sno=?");
			 
			ps.setString(1,sname);
			ps.setString(2,sub);
			ps.setString(3,email);
			ps.setInt(4,sno);
			
			ps.executeUpdate();
			ps.close();
			con.close();
	}
 public  static void deleting(int sno) throws ClassNotFoundException, SQLException
	{
		
			Class.forName("com.mysql.cj.jdbc.Driver");	
			
			con= DriverManager.getConnection(url,username,password);
			 
			ps=con.prepareStatement("delete from student where sno=?"); 
			ps.setInt(1,sno);
			
			ps.executeUpdate();
			ps.close();
			con.close();
	
	}
 public static void read()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="select * from student";
			s=con.createStatement();
			
			ResultSet rs=s.executeQuery(qry);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email"));
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}	
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		

	 }
	public static ArrayList<Student> reading()
	{
		Student d=null;
		ArrayList <Student> alDept=new ArrayList  <Student>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="select * from student";
			s=con.createStatement();
			
			 rs=s.executeQuery(qry);
			 
			 
			 while(rs.next())
			 {
				 	int no=rs.getInt("sno");
					String name=rs.getString("sname");
					String sub=rs.getString("sub");
					String mail=rs.getString("email");
					
					 d=new Student(no,name,sub,mail);
					 alDept.add(d);
					
			 }
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}	
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}	
		return alDept;
	}
}