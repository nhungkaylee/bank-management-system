package Entities;
import java.io.*;
import java.sql.*;
import java.util.List;

public class Branch {
	private String name;
	private String id;

	public Branch() {
		super();
	}	
	public Branch(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
//	public void addBranch(String id, String name) {
//	    Connect con = null; 
//	    ResultSet pmt = null;
//	    String query = null;
//         
//        try {
//			con = new Connect();
//			System.out.println("Connect");
//			query = "select * from [Bank Management System].dbo.Branch;";
//			pmt = con.statement.executeQuery(query);
//			System.out.println("select *");
//			
//			query = "insert into branch values(?,?)";
//			
////			int r = pmt.executeUpdate();
////		 	if(r > 0) System.out.println("RECORD INSERTED SUCCESSFULLY");
////		  	else System.out.println("ERROR IN INSERTION!!!");
//			
//		} catch (ClassNotFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.err.println("Error");
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.err.println("Error");
//		}
//          
//	}
//	
//	public void removeBranch(String id) {
//		
//	}
//	
//	public void editBranch() {
//		
//	}
//	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Branch [id= " + id + ", name= " + name + "]";
	}
}
