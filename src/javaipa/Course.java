package javaipa;
import java.util.*;
class coursedetails {
private int id;
private String courseName;
private String instructor;
private int fee;
private boolean isAvailable;


public coursedetails(int id,String courseName,String instructor,int fee,boolean isAvailable) {
	this.id=id;
	this.courseName=courseName;
	this.instructor=instructor;
	this.fee=fee;
	this.isAvailable=isAvailable;
}
public int getid() {
	return id;
}
public String getcourseName() {
	return courseName;
}
public String getinstructor() {
	return instructor;
}
public double getfee() {
	return fee;
}
public boolean getisAvailable() {
	return isAvailable;
}
}
public class Course{
	public static double findAverageFeeByInstructor(coursedetails[] courses,String instructor) {
		double sum=0;
		int count=0;
		for(coursedetails c:courses) {
			if(c.getinstructor().equalsIgnoreCase(instructor)) {
				sum=sum+c.getfee();
				count++;
			}
		}
		return sum/count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		coursedetails []courses=new coursedetails[n];
		for(int i=0;i<n;i++) {
			int id=sc.nextInt();
			sc.nextLine();
			String courseName=sc.next();
			String instructor=sc.next();
			double fee=sc.nextDouble();
			sc.nextLine();
			boolean isAvailable=sc.nextBoolean();
			sc.nextLine();
			courses[i] = new coursedetails(id, courseName, instructor, (int)fee, isAvailable);
		}
		String instructor=sc.next();
		double fee=findAverageFeeByInstructor(courses,instructor);
		if(fee>0) {
			System.out.println(fee);
		}
		else {
			System.out.println("No course found with matching attribute");
		}
	}
}