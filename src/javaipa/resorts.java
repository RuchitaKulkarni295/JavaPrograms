package javaipa;
import java.util.*;
class Resort{
	private int hotelId;
	private String hotelName;
	private String dateOfBooking;
	private int noOfRoomsBooked;
	private String wifiFacility;
	private double totalBill;
	
	public Resort(int hotelId,String hotelName,String dateOfBooking,int noOfRoomsBooked,String wifiFacility,double totalBill) {
		this.hotelId=hotelId;
		this.hotelName=hotelName;
		this.dateOfBooking=dateOfBooking;
		this.noOfRoomsBooked=noOfRoomsBooked;
		this.wifiFacility=wifiFacility;
		this.totalBill=totalBill;
	}
	public int gethotelId() {
		return hotelId;
	}
	public String gethotelName() {
		return hotelName;
	}
	public String getdateOfBooking() {
		return dateOfBooking;
	}
	public int getnoOfRoomsBooked() {
		return noOfRoomsBooked;
	}
	public String getwifiFacility() {
		return wifiFacility;
	}
	public double gettotalBill() {
		return totalBill;
	}
}
public class resorts {
	public static int noOfRoomsBookedInGivenMonth(Resort[] resorts,String dateOfBooking) {
		int rooms=0;
		for(Resort r:resorts) {
			String month = r.getdateOfBooking().split("-")[1];
			if(month.equalsIgnoreCase(dateOfBooking)) {
			rooms=rooms+r.getnoOfRoomsBooked();
			}
		}
		if(rooms==0)return 0;
		else 
		return rooms;
	}
	public static Resort searchHotelByWifiOption(Resort[] resorts,String getwifiFacility) {
	ArrayList<Resort>list=new ArrayList<>();
		double highbill=0;
		double secbill=0;
	for(Resort r:resorts) {
		if(r.getwifiFacility().equalsIgnoreCase(getwifiFacility)) {
		if(highbill<r.gettotalBill()) {
			secbill=highbill;
			highbill=r.gettotalBill();
		}
		else if(secbill<r.gettotalBill()&&secbill!=highbill) {
			secbill=r.gettotalBill();
		}
		}
	}
	for(Resort r:resorts) {
		if(r.getwifiFacility().equalsIgnoreCase(getwifiFacility)&&(r.gettotalBill()==secbill)) {
			list.add(r);
		}
	}
	if(list.size()==0)return null;
	
	return list.get(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Resort arr[]=new Resort[4];
		for(int i=0;i<4;i++) {
			int a=sc.nextInt();
			sc.nextLine();
			
			String b=sc.nextLine();
			
			String c=sc.nextLine();
			
			int d=sc.nextInt();
			sc.nextLine();
			String e=sc.nextLine();
			double f=sc.nextDouble();
			sc.nextLine();
			arr[i]=new Resort(a,b,c,d,e,f);
		}
		String month=sc.nextLine();
		String wifiFacility=sc.nextLine();
		
		int d=noOfRoomsBookedInGivenMonth(arr,month);
		if(d>0)
		System.out.println(d);
		else 
			{
			System.out.println("no rooms booked in given month");
			}
		
		Resort wifi=searchHotelByWifiOption(arr,wifiFacility);
		if(wifi==null) {
			System.out.println("No such option available");
		}
		else {
			
				System.out.println(wifi.gethotelId());
		}
	}

}
