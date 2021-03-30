

// 사용자 정의 메소드 만들기 : 개발자가 필요할떄마다 새롭게 기능을 추가하여 만드는 메소드

public class Test49 {
	
//방법1. 매개변수가 없고 리턴값이 없는 메소드 만들기
	//메소드 이름 : hello_func
	//기능 "Hello World!"<--출력
	public static void hello_func() {
		System.out.println("Hello World!");
	}
	// void자료형?
	// 메소드의 몸체에 기술한 명령을 실행할 뿐 실행결과 데이터를 메소드를 호출한 줄로 반환하지 않는 경우 사용
	// 요약 -> 메소드의 리턴값이 없는 경우 void자료형을 사용 

//방법2. 매개변수가 있고 리턴할 값이 없는 메소드 만들기
	//메소드 이름 : sum
	//기능 : 매개변수로 전달 받은 값 까지의 자연수의 합구하는 기능
	public static void sum(int n) {
		//매개변수란? sum이라는 메소드를 호출할때 전달 받은 값을 담아 두기 위한 변수 
		//위 int n <-매개변수
		
		int tot = 0; //매개변수로 전달 받은 자연수 까지의 합을 저장할 변수 
		
		int i;// for반복문의 초기식을 밖으로 빼서 변수만 선언 할수 있다.
		
		//숫자 1부터 n매개변수로 전달 받은 숫자 까지의 합을  tot변수에 누적 
		for(i=1; i<=n; i++) {
			tot += i;
		}
		
		//구해진 누적합 출력
		System.out.println("1 ~ " + n + "까지의 합 = " + tot);	
	}
	
	
	
	
	public static void main(String[] args) {
		
		hello_func();
		
		

	}

}


