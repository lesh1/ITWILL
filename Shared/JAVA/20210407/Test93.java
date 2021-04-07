class TV{
	boolean power; // 전원상태 on / off를 저장할 변수
	int channel; // 채널값을 저장할 변수

// TV의 전원을 on 또는 off 시키는 기능의 메소드

	void power(){
		power= !power;
	}
// 채널을 1 증가 시키는 기능의 메소드
	void channelUp(){
		++channel;
	}
// 채널을 1 감소 시키는 기능의 메소드
	void chanelDown(){
		--channel;
	}
}

class CaptionTV extends TV{
	//캡션을 보여주기 위한 문자열이 저장될 변수
	String text;

	void Caption(){
		System.out.println("캡션기능이 추가된 TV");
	}
}
public class Test93 {

	public static void main(String[] args) {
		TV tv = new TV();
		CaptionTV c = new CaptionTV();
		TV t1= new CaptionTV();
		// t1 = new CaptionTV();
		// t1 = new CaptionTV();
		/*
		TV클래스와 CaptionTV 클래스가 상속관계에 있을 경우
		부모클래스 타입의 참조변수에 저장된 객체의 주소를 이용하여
		자식객체 메모리의 멤버를 참조하도록 하는 것도 가능

		부모클래스 타입의 참조변수에 자식객체를 생성해서 그 주소를 저장
		TV t1 = new CaptionTV(); // 자식객체1
		//t1 = new CaptionTV(); // 자식객체2
		//t1 = new CaptionTV(); // 자식객체3

		★자바에서 다형성의 특징 중에 하나인 업캐스팅이라는 개념이 있음★



		객체를 생성하여 같은 클래스 타입의 참조변수에 객체메모리의 주소값을 저장하는 것과 
		객체를 생성하여 부모 클래스 타입의 참조변수에 객체메모리의 주소값을 저장하는 것의 차이 

		*/
//		 1. 객체를 생성하여 같은 클래스 타입의 참조변수에 객체 메모리의 주소값 저장
		 CaptionTV c1 = new CationTV();
//		 2. 객체를 생성하여 부모클래스 타입의 참조변수에 객체 메모리의 주소값 저장
		 TV tv2 = new CaptionTV();
	}

}