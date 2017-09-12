package com.briup.pattern.create.Prototype;


public class Test1 {
	public static void main(String[] args) throws CloneNotSupportedException {

		Prototype1 t = new Prototype1();
		t.setNum(500);
		
		Prototype1 clone = (Prototype1)t.clone();
		System.out.println(t==clone);
		System.out.println(clone.getNum());
		
	}
}
