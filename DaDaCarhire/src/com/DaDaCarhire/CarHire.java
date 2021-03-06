package com.DaDaCarhire;
import java.util.Scanner;
public class CarHire {
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
        System.out.println("欢迎使用哒哒租车系统！");
        System.out.println("您是否要租车：1 是  0 否");
        int w=in.nextInt();
        if(w == 1){
        	System.out.println("您可租车类型及其价目表：");
        	System.out.println("序号       汽车名称            容量         价格");
        	Car[] car = new Car[7];
        	car[0] = new normalCar("奥迪a6",5,800);
        	car[1] = new normalCar("马自达6",5,500);
        	car[2] = new goodsCar("东风",20,1000);
        	car[3] = new pika("江铃",5,400,2);
        	car[4] = new normalCar("金龙客车",25,900);
        	car[5] = new goodsCar("依维柯",16,800);
        	car[6] = new normalCar("宝马i8",2,5000);
        	for(int i=0;i<car.length;i++){
        		System.out.print(i+1+" "); 
        		if(car[i] instanceof normalCar) 
        			((normalCar)car[i]).print(); 
        		if(car[i] instanceof pika) ((pika)car[i]).print(); 
        		if(car[i] instanceof goodsCar) ((goodsCar)car[i]).print(); 
        		}
        	
        System.out.println("请输入你要租车的数量：");
        int num = in.nextInt();//获取输入的租车数量
        int n[] = new int[100];
        for (int i=0;i<num;i++){
        	System.out.println("请输入第"+(i+1)+"辆车的序号：");
        	n[i]=in.nextInt();//将用户输入的车子序号用数组n记下来
        }
        System.out.println("请输入租车天数：");
        int day= in.nextInt();
        System.out.println("您的账单：");
        System.out.println("*****可载人的车有：");
        int sum=0;
        for(int i=0;i<num;i++){
        	if(car[n[i]-1] instanceof normalCar){//获取用户输入的车子序号
        		((normalCar)car[n[i]-1]).print();
        		sum+=car[n[i]-1].getCarSeat(); 
        		} 
        	if(car[n[i]-1] instanceof pika){
        		((pika)car[n[i]-1]).print(); 
        		sum+=car[n[i]-1].getCarSeat();
        		} 
        	}
        System.out.println("可载人："+sum+"人");
        sum=0;
        int price = 0;
        System.out.println("*****可载物的车有：");
        for(int i=0;i<num;i++){
        	if(car[n[i]-1] instanceof goodsCar){
        		((goodsCar)car[n[i]-1]).print();
        		sum+=car[n[i]-1].getCarLoad();
        	}
        	if(car[n[i]-1] instanceof pika){
        		((pika)car[n[i]-1]).print(); 
        		sum+=car[n[i]-1].getCarLoad();
        		}
        	price+=car[n[i]-1].getCarPrice();
        	
        }
        System.out.println("可载重："+sum+"吨");
        System.out.println("*****总价格为："+price*day+"元");
	}
        else {
        	System.out.println("谢谢访问！");
        }
	}
}
