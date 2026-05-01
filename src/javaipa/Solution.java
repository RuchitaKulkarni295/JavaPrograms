package javaipa;
//step:-1inside class first insert all variables
//step:-2then create constructor and inside that use this to acquire them beacuse the variables are decalred in global
//step:-3then use getters to get the values
import java.util.Scanner;
class Travelagencies{
int regNo;
String agencyName;
String pakagType;
int price;
boolean flightFacility;

public Travelagencies(int regNo,String agencyName,String pakagType,int price,boolean flightFacility) {
	this.regNo=regNo;
	this.agencyName=agencyName;
	this.pakagType=pakagType;
	this.price=price;
	this.flightFacility=flightFacility;
}
public int getregNo() {
	return regNo;
}
public String getagencyName() {
	return agencyName;
}
public String getpakagType() {
	return pakagType;
}
public int getprice() {
	return price;
}
public boolean getflightFacility() {
	return flightFacility;
}
}
public class Solution{
	public static int findAgencyWithHighestPackagePrice(Travelagencies[] travelAgencies) {
		int max=Integer.MIN_VALUE;
		for(Travelagencies t:travelAgencies) {
			if(max<t.getprice()) {
				max=t.getprice();
			}
		}
		return max;
	}
	public static  Travelagencies agencyDetailsForGivenldAndType(Travelagencies[] travelagencies, int regNo,String packageType) {
		for(Travelagencies t:travelagencies) {
			if(t.flightFacility==true&&(t.getregNo()==regNo)&&(t.getpakagType().equalsIgnoreCase(packageType))) {
				return t;
			}
		}
		return null;
	}
//	here we created array named Travelagencies and decalred size and using for loop entered values
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Travelagencies arr[]=new Travelagencies[4];

      for(int i=0;i<arr.length;i++){
          int a=sc.nextInt();
          sc.nextLine();
          String b=sc.nextLine();
          String c=sc.nextLine();
          int d=sc.nextInt();
//          sc.nextLine();
          boolean e=sc.nextBoolean();
          sc.nextLine();
          arr[i]=new Travelagencies(a, b, c, d, e) ;           
      }
      int maxPrice=findAgencyWithHighestPackagePrice(arr);
      
      int inputRegNo=sc.nextInt();
      sc.nextLine();
      String inputPackageType=sc.nextLine();

      Travelagencies obj =agencyDetailsForGivenldAndType(arr,inputRegNo,inputPackageType);

      System.out.println(maxPrice);
      if(obj == null){
          System.out.println("not Found");
      }
      else{
          System.out.println(obj.getagencyName()+":"+obj.getprice());
      }
	}
}
