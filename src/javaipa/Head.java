package javaipa;
import java.util.*;
import java.util.Scanner;
//import myproject.Motel;
class HeadSets {
	private String headsetName;
	private String brand;
	private int price;
	private boolean available;
	
	public HeadSets(String headsetName,String brand,int price,boolean available) {
		this.headsetName=headsetName;
		this.brand=brand;
		this.price=price;
		this. available=available;
	}
	public String getheadsetName() {
		return headsetName;
	}
	public String getbrand() {
		return brand;
	}
	public int getprice() {
		return price;
	}
	public boolean getavailable() {
		return available;
	}
}
public class Head {
	public static int findTotalPriceForGivenBrand(HeadSets[] head,String brandname) {
		 int sum=0;
		    for(HeadSets m : head) {
		        if ((m.getbrand()).equalsIgnoreCase(brandname) ) {
		            sum += m.getprice();
		            
		        }
		    }
//		    System.out.println(sum);
			return sum;

	}
	public static int findAvailableHeadsetWithSecondMinPrice(HeadSets[] head)	{
		int min=Integer.MAX_VALUE;
		int secmin=0;
		for(HeadSets m : head) {
			
//			secminpri=m.price;
	        if (min>(m.getprice()) ) {
	        	secmin=min;
	        	min = m.getprice();
	        }
	        else if(secmin>min&&secmin>(m.getprice())){
	        	secmin=m.getprice();
	        }
	    }
//		System.out.println("min"+min);
//		System.out.println("secmin"+secmin);
		return secmin;
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HeadSets[] arr = new HeadSets[4];
		
		for(int i=0;i<arr.length;i++) {
			String a=sc.next();
			String b=sc.next();
			int c=sc.nextInt();
			
			boolean d=sc.nextBoolean();
			arr[i]= new HeadSets(a,b,c,d);
		}
		
//		arr[0] = new HeadSets("Apple","brand2",15000,true);
//		arr[1] = new HeadSets("Apple","brand2",20000,true);
//		arr[2] = new HeadSets("Boult","brand3",34000,true);
//		arr[3] = new HeadSets("Boult","brand4",36000,true);

		
	    String brandname=sc.next();
	    
	    int result=0;
	    result = findTotalPriceForGivenBrand(arr,brandname);
	    System.out.println(brandname+" "+"price is "+result);
//	    System.out.println(findAvailableHeadsetWithSecondMinPrice(head));
	    int secminprice=findAvailableHeadsetWithSecondMinPrice(arr);
	    System.out.println(secminprice);
	}
}
