package com.briup.day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 购物车类
 * @author LZP
 *
 */
public class ShoppingCar {
	
	private Map<Commodity,Integer> commodity;
	private double totlePrice =0.0;
	public ShoppingCar(){
		commodity =new HashMap<>(0);
	}
	
	//Commodity c=new Commodity();
	
	public void addCommodity(Commodity c){
		if(c == null){
			return;
		}
		if(commodity.equals(c)){
			
		}
		else{
			commodity.clear();
		}
	}
	
	public void clear(){
		commodity.clear();
		totlePrice=0.0;
	}
	
	public void removeCommodity(Commodity c){
		commodity.remove(c);
	}
	
	public double getTotalPrice(){
		return totlePrice;
	}
	
	public List<Commodity> select(){
		return null;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commodity == null) ? 0 : commodity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCar other = (ShoppingCar) obj;
		if (commodity == null) {
			if (other.commodity != null)
				return false;
		} else if (!commodity.equals(other.commodity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingCar [commodity=" + commodity + ", totlePrice="
				+ totlePrice + ", c=" + "]";
	}
}
