package com.briup.mytest.test;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.mybatis.utils.MyBatisSqlSessionFactory;
import com.briup.mytest.mappers.GroupMapper;
import com.briup.mytest.pojo.Group;
import com.briup.mytest.pojo.User;

public class GroupTest {
	@Test
	public void findAllTest(){
		SqlSession sqlSession =null;
		try {
			sqlSession=MyBatisSqlSessionFactory.openSession();
			GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
			//List<Group> list = mapper.findAll();
			for(Group g:mapper.findAll()){
				System.out.println(g);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertUserTest(){
		SqlSession sqlSession =null;
		try {
			sqlSession=MyBatisSqlSessionFactory.openSession();
			GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
			User user=new User(4,"jarry",25);
			int gId=1;
			mapper.insertUesr(user,gId);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
