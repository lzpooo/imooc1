package com.briup.jdbc.day_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.jdbc.day_01.DriverFactory;

/**
 * 使用PreparedStatement进行增删改查
 * 
 * @author Administrator
 *
 */
public class StudentTest1 {

	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public static void main(String[] args) {
		connection = DriverFactory.getConnection();
		Student stu = new Student(5, "lisi", "555", 20, "male");

		// 测试
		getInsert(stu);
		getSelect(stu);
		getUpdate(18);
		getDelete();
	}

	// 插入
	public static void getInsert(Student stu) {

		try {

			String sql = "insert into student values(stu_seq.nextval,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			//ps.setInt(1, stu.getId());
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getPassword());
			ps.setInt(3, stu.getAge());
			ps.setString(4, stu.getGender());

			int i = ps.executeUpdate();
			System.out.println("插入" + i + "条数据");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally{ DriverFactory.getClose(connection, ps, rs); }
		 */
	}

	// 查询
	public static void getSelect(Student stu) {

		try {

			String sql = "select * from student where name=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, stu.getName());
			rs = ps.executeQuery();
			// 处理结果集
			while (rs.next()) {
				System.out.println("id:" + rs.getInt("id") + "  name:"
						+ rs.getString("name") + "  password:"
						+ rs.getString("password") + "  age:"
						+ rs.getInt("age") + "  gender:"
						+ rs.getString("gender"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 修改
	public static void getUpdate(int a) {

		try {
			String sql = "update student set age=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, a);
			int i = ps.executeUpdate();
			System.out.println("更改" + i + "条数据！");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除
	public static void getDelete() {

		try {
			String sql = "delete student";
			ps = connection.prepareStatement(sql);
			int i = ps.executeUpdate();
			System.out.println("删除" + i + "条数据！");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DriverFactory.getClose(connection, ps, rs);
		}
	}
}
