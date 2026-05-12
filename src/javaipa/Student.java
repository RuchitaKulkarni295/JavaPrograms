package javaipa;

import java.util.*;

class studentdetail{
	private int id;
	private String name;
	private int totmarksobt;
	public  studentdetail(int id,String name,int totmarksobt) {
		this.id=id;
		this.name=name;
		this.totmarksobt=totmarksobt;
	}
	public int getid() {
		return id;
	}
	public String getname() {
		return name;
	}
	public int gettotmarksobt() {
		return totmarksobt;
	}
}
public class Student{
	public static String findStudentWithHighestTotal(studentdetail[] students) {
		int max=Integer.MIN_VALUE;
		String namemax = null;
		for(studentdetail s:students) {
			if(s.gettotmarksobt()>max) {
				max=s.gettotmarksobt();
			}
		}
		for(studentdetail s:students) {
		     if(s.gettotmarksobt()==(max)) {
				namemax=s.getname();
			}
		}
		return namemax;
	}
	public static studentdetail[] searchStudentsBypercentage(studentdetail[] students) {
		ArrayList<studentdetail> list = new ArrayList<>();
		for(studentdetail s:students) {
			if(s.gettotmarksobt()>=280) {
				list.add(s);
			}
		}
	list.sort(Comparator.comparing(studentdetail::getid));
    if(list.isEmpty()) {
        return null;
    }
    return list.toArray(new studentdetail[0]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		studentdetail []arr=new studentdetail[5];
		for(int i=0;i<arr.length;i++) {
		int a=sc.nextInt();
		sc.nextLine();
		String b=sc.next();
		int c=sc.nextInt();
		
		arr[i]=new studentdetail(a,b,c);
		}
		
		String mname=findStudentWithHighestTotal(arr);
		studentdetail[] p=searchStudentsBypercentage(arr);
		
		if(mname!=null)System.out.println(mname);
		else System.out.println(0);
		
		if(p!=null) {
			for(studentdetail l:p) {
				System.out.println(l.getid());
		}
		}
		else {
			System.out.println("scored below");
		}
	}

}
