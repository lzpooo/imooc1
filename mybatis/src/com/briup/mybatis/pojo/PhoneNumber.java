package com.briup.mybatis.pojo;

/**
 * 自定义的类型
 * 
 * @author LZP 2017年9月7日
 */
public class PhoneNumber {
	private String countryCode;
	private String stateCode;
	private String number;

	public PhoneNumber() {
	}
	
	public PhoneNumber(String str){
		//接收数据库查询到的结果
		if(str!=null){
			String[] ph = str.split("-");
			countryCode=ph[0];
			stateCode=ph[1];
			number=ph[2];
		}
	}
	
	public PhoneNumber(String countryCode, String stateCode, String number) {
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}
	
	public String getAsString(){
		return countryCode+"-"+stateCode+"-"+number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [countryCode=" + countryCode + ", stateCode="
				+ stateCode + ", number=" + number + "]";
	}

}
