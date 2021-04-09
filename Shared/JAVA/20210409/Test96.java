class Parent2{
	public void parentPrn(){
		System.out.println("부모클래스 : parentPrn메소드");
	}
}

class Child2 extends Parent2{
	public void childPrn(){
		System.out.println("자식클래스 : childPrn메소드");
	}
}

public class Test96{
	public static void main(String[] args) {
		Parent2 p2 = new Child2();
		p2.parentPrn();
	}
}