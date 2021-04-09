class Parent1{
	public void parentPrn(){
		System.out.println("부모클래스 : parentPrn메소드");
	}
}

class Child1 extends Parent1{
	public void childPrn(){
		System.out.println("자식클래스 : childPrn메소드");
	}
}

public class Test95{
	public static void main(String[] args) {
		Parent1 p1= new Parent1();
		Child c1;
		c1 = (Child)p1;
		Child1 c2 = (Child)new Parent1();
	}
}