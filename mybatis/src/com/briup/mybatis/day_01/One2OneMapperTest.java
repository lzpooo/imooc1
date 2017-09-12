package com.briup.mybatis.day_01;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.mybatis.mappers.One2OneMapper;
import com.briup.mybatis.pojo.Student;
import com.briup.mybatis.utils.MyBatisSqlSessionFactory;

/**
 * 一对一映射
 * @author LZP
 * 2017年9月8日
 */
public class One2OneMapperTest {
	@Test
	public void findStudentById_1Test(){
		SqlSession sqlSession=null;
		try {
			
			sqlSession=MyBatisSqlSessionFactory.openSession();
			One2OneMapper mapper = sqlSession.getMapper(One2OneMapper.class);
			Student student = mapper.findStudentById_1(1);
			System.out.println(student);
			
		} catch (Exception e) {
			
		}
		finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
