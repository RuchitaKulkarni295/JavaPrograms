package javaipa;
class Employee {
	private int employeeId;
	private String employeeName;
	private int age;
	private String department;
	public Employee(int employeeId, String employeeName, int age, String department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.department = department;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
}

public class EmployeeOperations {
public static Employee searchEmployeeById(Employee[] employees,int empId) {
	for(Employee emp:employees) {
//		we are taking get because employeeId is private variable
		if(emp.getEmployeeId()==empId) {
			return emp;
		}
	}
	return null;
}
	public static Employee updateEmployee(Employee[] employees,Employee newEmployee) {
		for(Employee emp:employees) {
//			we are modifying existing object not creating any new object
//			newEmployee is an onject of Employee that's why we can acces methods
			if(emp.getEmployeeId()==newEmployee.getEmployeeId()) {
				emp.setEmployeeId(newEmployee.getEmployeeId());
				emp.setAge(newEmployee.getAge());
				emp.setDepartment(newEmployee.getDepartment());
				return emp;
			}
		}
		return null;	
	}
	public static Employee[] searchEmployeesByDept(Employee[] employees,String dept) {
		Employee[] deptEmployees=null;
		int count=0;
		for(Employee emp:employees) {
//			read equalIgnoreCase
			if(emp.getDepartment().equalsIgnoreCase(dept)) {
				count++;
			}
		}
		deptEmployees=new Employee[count];
		int count1=0;
		for(Employee emp:employees) {
			if(emp.getDepartment().equalsIgnoreCase(dept)) {
				deptEmployees[count1]=emp;
				count1++;
			}
		}
		 return deptEmployees;
	}
	public static void main(String[] args) {
		Employee emp1=new Employee(11,"Tom Henry",45,"IT");
		Employee emp2=new Employee(12,"John Henry",30,"HR");

		Employee emp3=new Employee(13,"Adam Henry",24,"IT");

		Employee emp4=new Employee(14,"paul Henry",34,"HR");
		Employee[] employees= {emp1,emp2,emp3,emp4};
		
		Employee searchEmp=searchEmployeeById(employees,13);
//		System.out.println(searchEmp.getEmployeeId()+" "+searchEmp.getEmployeeName()+" "+searchEmp.getAge()+searchEmp.getDepartment());
		Employee newEmployee=new Employee(12,"Mark Henry",30,"Hr");
		Employee updatesEmp=updateEmployee(employees,newEmployee);
		for(Employee emp:employees) {
			System.out.println(emp.getEmployeeId()+" "+emp.getEmployeeName()
			+" "+emp.getAge()+emp.getDepartment());
		
	}
		Employee[] deptEmployees=searchEmployeesByDept(employees,"IT");
		for(Employee deptEmp:deptEmployees) {
			System.out.println(deptEmp.getEmployeeId()+" "+deptEmp.getEmployeeName()
			+" "+deptEmp.getAge()+deptEmp.getDepartment());
		

		}
//	private static Employee searchEmployeeId(Employee[] employees, int i) {
		// TODO Auto-generated method stub
	}
}
