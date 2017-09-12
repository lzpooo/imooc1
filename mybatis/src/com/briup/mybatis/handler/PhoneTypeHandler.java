package com.briup.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.mybatis.pojo.PhoneNumber;

/**
 * PhoneNumber的自定义类型处理器
 * @author LZP
 * 2017年9月7日
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber>{
	
	//查询中遇到PhoneNumber类型的应该如何封装(使用列名封装)
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}

	//查询中遇到PhoneNumber类型的应该如何封装(使用列的下标)
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnIndex));
	}

	//CallableStatement使用中遇到了PhoneNumber类型的应该如何封装
	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(cs.getString(columnIndex));
	}

	/*
	 * 四个参数含义：
	 */
	//遇到PhoneNumber参数的时候应该如何在ps中设置值
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, parameter.getAsString());
	}
	
}
