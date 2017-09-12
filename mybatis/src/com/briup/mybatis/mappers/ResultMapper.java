package com.briup.mybatis.mappers;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
public interface ResultMapper {
	List<Student> findAllStudents();
	Set<Student> findStudents_set();
	Map<String,Object> findStudentById_map(Integer i);
	List<Map<String,Object>> findStudent_ListMap();

}
