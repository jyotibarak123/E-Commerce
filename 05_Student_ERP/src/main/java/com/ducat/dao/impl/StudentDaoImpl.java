package com.ducat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ducat.dao.StudentDao;
import com.ducat.dao.util.ConnectionProvider;
import com.ducat.modal.Student;

public class StudentDaoImpl implements StudentDao
{
	private static boolean isTableCreated=false;
	private String columns[];
	private void createTable()
	{
		try {
		Connection con = ConnectionProvider.getMySqlConnection();
		Statement st = con.createStatement();
		st.execute("""
			create table if not exists students
			(id int primary key auto_increment,
			name varchar(50),mobileNo bigint,
			gender char(1),isMember boolean,
			fee double,joinedAt date,
			email varchar(50),
			password varchar(25));
			
			""");
		isTableCreated=true;
		st.close();
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public StudentDaoImpl()
	{
	    
		if(!isTableCreated) {
			createTable();
		}
	}

	@Override
	public int registerStudent(Student student) {
		int rowsAffected=-1;
		try {
		Connection con=	ConnectionProvider.getMySqlConnection();
		PreparedStatement ps = con.prepareStatement("insert into students (name,mobileNo,gender,isMember,fee,joinedAt,email,password) values(?,?,?,?,?,?,?,?);");
		ps.setString(1, student.getName());
		ps.setLong(2, student.getMobileNo());
		ps.setString(3, String.valueOf(student.getGender()));
		ps.setBoolean(4, student.isMember());
		ps.setDouble(5, student.getFee());
		ps.setDate(6, java.sql.Date.valueOf(student.getJoinedAt()));
		ps.setString(7, student.getEmail());
		ps.setString(8, student.getPassword());
		System.out.println(ps);
		
	    rowsAffected = ps.executeUpdate();
	    ps.close();
	    con.close();
	    
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	          return rowsAffected;
	}

	@Override
	public boolean updateStudent(Student student) {
		boolean status =false;
		try {
		Connection con=	ConnectionProvider.getMySqlConnection();
		PreparedStatement ps = con.prepareStatement("update students set name=?,mobileNo=?,gender=?,isMember=?,fee=?,joinedAt=?,email=?,password=? where id=?;");
		ps.setString(1, student.getName());
		ps.setLong(2, student.getMobileNo());
		ps.setString(3, String.valueOf(student.getGender()));
		ps.setBoolean(4, student.isMember());
		ps.setDouble(5, student.getFee());
		ps.setDate(6, java.sql.Date.valueOf(student.getJoinedAt()));
		ps.setString(7, student.getEmail());
		ps.setString(8, student.getPassword());
		ps.setInt(9,student.getId());
		System.out.println(ps);
		
	    status = ps.executeUpdate()>0?true:false;
	    ps.close();
	    con.close();
	    
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	          return status;
	}

	@Override
	public boolean deleteStudent(int id) {
		boolean status =false;
		try {
		Connection con=	ConnectionProvider.getMySqlConnection();
		Statement st = con.createStatement();
		int rowsAffected = st.executeUpdate("delete from students where id="+id+";");
	    status = rowsAffected>0?true:false;
	    st.close();
	    con.close();
	    
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	          return status;
	}

	@Override
	public List<Student> getAllStudents() {
	
		ArrayList<Student> al = new ArrayList<>();
		try {
			Connection con=	ConnectionProvider.getMySqlConnection();
			Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery("select * from students;");
		    
		    ResultSetMetaData rsmd = rs.getMetaData();
		    columns = new String[rsmd.getColumnCount()-1];
		    for(int i=0; i<rsmd.getColumnCount()-1; i++)
		    {
		    	
		    	columns[i] = rsmd.getColumnName(i+1);
		    }
		    
		    while(rs.next()) {
		    	Student temp = new Student();
		    	temp.setId(rs.getInt(1));
		    	temp.setName(rs.getString(2));
		    	temp.setMobileNo(rs.getLong(3));
		    	temp.setGender(rs.getString(4).charAt(0));
		    	temp.setMember(rs.getBoolean(5));
		    	temp.setFee(rs.getDouble(6));
		    	temp.setJoinedAt(rs.getDate(7).toLocalDate());
		    	temp.setEmail(rs.getString(8));
		    	temp.setPassword(rs.getString(9));
		    	
		    	al.add(temp);
		    }
		    rs.close();
		    st.close();
		    con.close();
		    
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		        return al;
	}

	@Override
	public Student getStudentById(Student student) {
		
		try {
			Connection con=	ConnectionProvider.getMySqlConnection();
			PreparedStatement ps =  con.prepareStatement("select * from students where id=?;");
			ps.setInt(1, student.getId());
		    ResultSet rs = ps.executeQuery();
//		    ResultSet rs = st.executeQuery("select * from students where name='jyoti';");
		    
		    if(rs.next()) {
		    	student.setId(rs.getInt(1));
		    	student.setName(rs.getString(2));
		    	student.setMobileNo(rs.getLong(3));
		    	student.setGender(rs.getString(4).charAt(0));
		    	student.setMember(rs.getBoolean(5));
		    	student.setFee(rs.getDouble(6));
		    	student.setJoinedAt(rs.getDate(7).toLocalDate());
		    	student.setEmail(rs.getString(8));
		    	student.setPassword(rs.getString(9));
		    }
		    else {
		    	student=null;
		    }
		   
		    rs.close();
		    ps.close();
		    con.close();
		    
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		        return student;
	}
	
	@Override
	public Student getStudentByEmail(String email) {
		Student temp=null;
		try {
			Connection con=	ConnectionProvider.getMySqlConnection();
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select * from students where email='"+email+"';");
		    
		     rs.next();
		    	temp = new Student();
		    	temp.setId(rs.getInt(1));
		    	temp.setName(rs.getString(2));
		    	temp.setMobileNo(rs.getLong(3));
		    	temp.setGender(rs.getString(4).charAt(0));
		    	temp.setMember(rs.getBoolean(5));
		    	temp.setFee(rs.getDouble(6));
		    	temp.setJoinedAt(rs.getDate(7).toLocalDate());
		    	temp.setEmail(rs.getString(8));
		    	temp.setPassword(rs.getString(9));
		    
			  
		    rs.close();
		    ps.close();
		    con.close();
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		        return temp;		
	}
	@Override
	public String[] getColumnsName()
	{
		return columns;
	}
	
	@Override
	public Student validateUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
