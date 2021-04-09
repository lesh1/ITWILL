class Parent{
	public void parentPrn(){
		System.out.println("Parent Class : parentPrn Method");
	}
}

class Child extends Parent{
	public void childPrn(){
		System.out.println("Child Class : childPrn Method");
	}
}

public class Test94{
	public static void main(String[] args) {
		int a= 10;
		long b =20;
		b=a;

		Child child = new Child();
		child.parentPrn();
		child.childPrn();

		Parent p;
		p=child;
	}
}