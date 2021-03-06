package com.briup.jdbc.day_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.jdbc.day_01.DriverFactory;

/**
 * 使用statement 测试安全注入问题
 * @author Administrator
 *
 */
public class StudentTest {
	private static Connection connection;
	private static Statement st;
	private static ResultSet rs;
	
	public static void main(String[] args) throws SQLException {
		//获取连接对象
		connection=DriverFactory.getConnection();
		
		//模拟前台传入的用户名密码
		Student stu=new Student();
		stu.setName("tom");
		stu.setPassword("111");
		
		//获取statement对象
		st=connection.createStatement();
		//select * from student where name='tom' and password='111'
		String sql="select * from student "+"where name='" +stu.getName()+ 
				"' and password='"+stu.getPassword()+"'";
		
		//System.out.println(sql);
		
		//执行sql语句
		rs=st.executeQuery(sql);
		
		//处理结果集
		while(rs.next()){
			System.out.println("id:"+rs.getInt("id")+"  name:"+rs.getString("name")+"  password:"+
		rs.getString("password")+"  age:"+rs.getInt("age")+"  gender:"+rs.getString("gender"));
		}
		
		//关闭资源
		DriverFactory.getClose(connection, st, rs);
		
		
	}
	
	
	
	
}
