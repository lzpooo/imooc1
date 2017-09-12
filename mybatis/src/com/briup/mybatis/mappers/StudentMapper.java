package com.briup.mybatis.mappers;

import java.util.List;

import com.briup.mybatis.pojo.Student;

/**
 * 映射接口
 * @author LZP
 *
 * 2017年9月6日
 */
//创建映射器Mapper接口StudentMapper
//方法名和StudentMapper.xml中定义的SQL映射定义名相同
//这个其实就是dao层接口(数据访问层,负责和数据库进行交互)
public interface StudentMapper {
	List<Student> findAllStudents(); 
	Student findStudentById(Integer id); 
	void insertStudent(Student student);
	void updateStudentById(Student student);
	void updateStudentByName(Student student);
	void insertPhone(Student student);
	void insertWithId(Student student);

}
