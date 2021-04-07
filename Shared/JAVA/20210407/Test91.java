class A{
	public A() {
		System.out.println("기본생성자A");
	}
	public A(int x) {
		System.out.println("매개변수 x를 받는 생성자A ="+x);
	}
}

class B extends A{
	public B() {
		super(30);
	}
	public B(int x) {
		System.out.println("매개변수 x를 받는 생성자B="+x);
	}
}
public class Test91 {

	public static void main(String[] args) {
		B b = new B();
	}

}
