class Person{
	int age= 20;
	String name;

	public Person(String name){
		this.name=name;
	}
}

class Man extends Person{
	int age=40;
	public Man(String name){
		super(name);		
	}

public void getInfo(){
	System.out.println(age);
}

public void getInfo2(){
	System.out.println("PersonClass Values name print");
	System.out.println("->"+name);
}
}
class Test89{
	public static void main(String[] args) {
		Man m = new Man("Hong");
		m.getInfo();
		m.getInfo2();
	}
}
