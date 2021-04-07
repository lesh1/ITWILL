class Employee{
	 String name;
	 int salary;

public String getEmployee(){
	return name+","+ salary;
}

public Employee(){}

public Employee(String name, int salary){
	this.name= name;
	this.salary = salary;
}
}

class Manager extends Employee{
	String depart;
	Manager(String name, int salary,String depart){
		super(name, salary);
		this.depart=depart;
	}
public String getManager() {
	return super.name+","+super.salary+","+depart;
}
}

class Test90{
	public static void main(String[] args) {
		Employee emp = new Employee("hong",2000);
		Manager man = new Manager("Lee",4000,"develop");
		System.out.println(emp.getEmployee());
		System.out.println(man.getManager());
	}
}