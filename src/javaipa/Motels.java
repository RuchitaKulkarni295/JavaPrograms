package javaipa;
import java.util.Scanner;

import com.Travelagencies;

//Motel is a class (datatype). Motel[] motels is an array of Motel objects. motels is a reference 
//variable that stores multiple objects. m is a variable used in the loop that points to each object one by one and helps access its values
//test cases
//motels[0] = new Motel(1004, "Naigara", "23-Aug-2004", 6, "yes", 2500);
//motels[1] = new Motel(1005, "Urvashi", "20-Aug-2005", 6, "yes", 599999);
//motels[2] = new Motel(1006, "Prince", "22-Aug-2004", 6, "no", 293838);
class Motel{
private int motelId;
private String motelName;
private String dateOfBooking;
private  int noOfRoomsBooked;
private String cabFacility;
private double totalBill;


//public Motel(int i, String string, String string2, int j, String string3, int k) {
//	// TODO Auto-generated constructor stub
//}

public Motel(int motelId,String motelName,String dateOfBooking,int noOfRoomsBooked,String cabFacility,double totalBill)
{
	this.motelId=motelId;
	this.motelName=motelName;
    this.dateOfBooking=dateOfBooking;
    this.noOfRoomsBooked=noOfRoomsBooked;
    this.cabFacility=cabFacility;
    this.totalBill=totalBill;
}
	public int getMotelId() {
		return motelId;
	}
	public String getMotelName() {
		return motelName;
	}
	public String getdateOfBooking() {
		return dateOfBooking;
	}
	public int getnoOfRoomsBooked() {
		return noOfRoomsBooked;
	}
	public String getcabFacility() {
		return cabFacility;
	}
	public double gettotalBill() {
		return totalBill;
	}
}
public class Motels{
public static int totalNoOfRoomsBooked(Motel[] motels, String cabFacility) {
    int sum=0;
    for(Motel m : motels) {
        if (m.getcabFacility().equals("yes") && (m.getnoOfRoomsBooked() > 5)) {
            sum += m.getnoOfRoomsBooked();
        }
    }
//    System.out.println(sum)
//    anything cannot be printed here
	return sum;
}
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);

Motel[] arr=new Motel[4];

for(int i=0;i<arr.length;i++){
int a=sc.nextInt();
//sc.nextLine();
//int a = Integer.parseInt(sc.nextLine());

String b=sc.next();

String c=sc.next();

int  d=sc.nextInt();
sc.nextLine();

String e=sc.next();
double f=sc.nextInt();

arr[i]=new Motel(a, b, c, d, e,f) ;  
}

    String input=sc.next();
    int result = totalNoOfRoomsBooked(arr, input);
    System.out.println(result);
}
}