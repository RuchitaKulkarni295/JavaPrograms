package javaipa;
import java.util.*;
//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;

import com.Travelagencies;
class Laptop {
private int laptopId;
private String brand;
private String osType;
private double price;
private int rating;

public Laptop(int laptopId,String brand,String osType,double price,int rating) {
	this.laptopId=laptopId;
	this.brand=brand;
	this.osType=osType;
	this.price=price;
	this.rating=rating;
}
public int getlaptopId() {
	return laptopId;
}
public String getbrand() {
	return brand;
}
public String getosType() {
	return osType;
}
public double getprice() {
	return price;
}
public int getrating() {
	return rating;
} 
}
public class MyLaptop{
public static int countOfLaptopsByBrand(Laptop[] Laptops,String brandname) {
	int count=0;
	for(Laptop l:Laptops) {
		if(l.getbrand().equalsIgnoreCase(brandname)&&l.getrating()>3) {
			count++;
		}
	}
		return count;
}
public static Laptop[] searchLaptopByOsType(Laptop[] laptopproblems,String OS) {
	ArrayList<Laptop> list = new ArrayList<>();
	ArrayList<Laptop> rat = new ArrayList<>();
    for(Laptop l : laptopproblems) {
        if(l.getosType().equalsIgnoreCase(OS)) {
        	list.add(l);
        }
    }
    // here collections's function sort is used and Comparator from Java library for defining custom logic like here reversed 
    list.sort(Comparator.comparing(Laptop::getlaptopId).reversed());
    if(list.isEmpty()) {
        return null;
    }
//    we are NOT creating the array manually we are just telling the type (Laptop[]) we have not given just laptop[] because a typed array
//    but size is unknown beforehand java internally resizes

    So new Laptop[0] is just a type marker
    return list.toArray(new Laptop[0]);
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Laptop arr[]=new Laptop[4];
	for(int i=0;i<arr.length;i++) {
		int a=sc.nextInt();
		sc.nextLine();
		String b=sc.next();
		String c=sc.next();
		int d=sc.nextInt();
		int e=sc.nextInt();
		arr[i]=new Laptop(a, b, c, d, e) ; 
	}
	String brand=sc.next();
	int laptopid=countOfLaptopsByBrand(arr,brand);
	
	String ostype=sc.next();
	Laptop[] lap=searchLaptopByOsType(arr,ostype);
	
	
	if(laptopid!=0)
	System.out.println(laptopid);
	else {System.out.println("The given brand is not available");
	}
	
	if(lap!=null) {
		for(Laptop l:lap) {
			System.out.println(l.getlaptopId());
			System.out.println(l.getrating());
		}
	}
	else System.out.println("The given os is not available");
	
}
}