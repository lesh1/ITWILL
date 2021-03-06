
/*
	주제 : 자식클래스 / 부모클래스의 생성자 호출과 실행
		질문1. 자식클래스의 인스턴스가 생성될때 자식클래스 생성자와 
			  부모클래스의 생성자가 모두 실행되는가?
			  아니면 자식클래스의 생성자만? 실행되는가?
		답.   둘 다 실행된다.
			  생성자는 인스턴스(객체)의 변수 값을 초기화할 목적으로 사용되므로
			  자식클래스의 생성자는 자식클래스 내부의 멤버를 초기화하거나
			  필요한 초기화 작업을 수행할 필요가 있고,
			  부모클래스의 생성자는 부모클래스의 멤버를 초기화 하거나
			  필요한 초기화 작업을 수행할 필요가 있기 때문이다.

		질문2. 자식클래스의 인스턴스가 생성될 때 자식클래스의 생성자와
		      부모클래스의 생성자의 실행 순서는 어떻게 되는가?
		   답. 부모클래스의 생성자가 먼저 실행된후 자식클래스의 생성자가 실행된다.   
		 
참고. new에 의해 자식클래스의 인스턴스가 생성될때...
	1. 부모클래스의 생성자와 자식클래스 생성자가 모두 실행됨
	2. 호출순서
		자식클래스의 생성자가 먼저 호출, 자식클래스의 생성자는 실행전~ 부모클래스 생성자 호출
	3. 실행순서
		부모클래스의 생성자가 먼저 실행된 후 자식클래스의 생성자가 실행
*/

//상속 관계에서의 생성자 호출 및 실행 순서 알아보기

class A1{//부모클래스 역할
	
	public A1() {
		System.out.println("생성자A1");
	}
}
class B1 extends A1{//B1클래스는 A1클래스의 자식클래스 
	
	public B1() {
		System.out.println("생성자B1");
	}
}
class C1 extends B1{//C1클래스는 B1클래스의 자식 클래스 
	
	public C1() {
		System.out.println("생성자C1");
	}
}

public class Test84 {
	public static void main(String[] args) {
		
		C1 c1 = new C1();

	}

}
/*
  생성자A1
  생성자B1
  생성자C1
*/







