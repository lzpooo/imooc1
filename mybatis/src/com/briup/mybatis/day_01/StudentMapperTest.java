package com.briup.mybatis.day_01;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.mybatis.mappers.StudentMapper;
import com.briup.mybatis.pojo.Student;

/**
 * 测试 增删改查
 *  
 * @author LZP
 *
 * 2017年9月6日
 */
public class StudentMapperTest {
	@Test
	public void testInsert(){
		
		try {
			//加载配置文件
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml"); 
			//创建SqlSessionFactory工厂类对象
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			//通过工厂类对象创建sqlSession对象，用来动态生成映射接口的实现类
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//执行操作
			//创建接口的实现类对象
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			//创建一个学生信息，方便插入
			Student s1 = new Student(2,"tom2","123@briup.com",new Date());			
			//调用插入方法
			studentMapper.insertStudent(s1);
			//提交
			//sqlSession.commit();
			
			
			
			//修改
//			Student s3=new Student(2,"rose","sadasfsadfasdsa",new Date());
//			studentMapper.updateStudentByName(s3);
//			sqlSession.commit();
			//根据ID修改
			/*Student s4=studentMapper.findStudentById(2);
			if(s4!=null){
				s4.setName("rose");
				s4.setEmail("1598857724@qq.com");
				studentMapper.updateStudentById(s4);
				sqlSession.commit();
			}*/
			
			//查询
			List<Student> s2 = studentMapper.findAllStudents();
			for (Student s:s2){
				System.out.println(s);
			}
			Student s=studentMapper.findStudentById(6);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
