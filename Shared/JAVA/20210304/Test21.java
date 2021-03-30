
// if   else if  else 조건문 연습문제1

public class Test21 {
	public static void main(String[] args) {

		//문자열을 저장할 myJob1이라는 이름의 변수 선언 및  "홍길동" 저장
		String myJob1 = "홍길동";
		//문자열을 저장할 myJob2라는 이름의 변수 선언 및  "이순신" 저장
		String myJob2 = "이순신";
		//문자열을 저장할 myJob3라는 이름의 변수 선언 및  "이성계" 저장
		String myJob3 = "이성계";
		//문자열을 저장할 myJob4라는 이름의 변수 선언 및  "정도전" 저장
		String myJob4 = "정도전";
		
		//myJob1변수에 저장된 값이  "홍길동"과 같으면?
		if(myJob1 ==  "홍길동") {
			//"홍길동은 의적" <---출력
			System.out.println("홍길동은 의적");
		}
		//myJob2변수에 저장된 값이 "이순신"과 같으면?
		else if(myJob2  == "이순신") {
			//"이순신은 장군" <---출력
			System.out.println("이순신은 장군");
			
			//myJob3변수에 저장된 값이  "이성계"와 같으면?	
		}else if(myJob3 == "이성계") {
		
			//"이성계는 왕" <---출력
			System.out.println("이성계는 왕");
			
		//위 조건식들이 모두 만족하지 않으면?	
		}else {
			//"정도전은 책사" <---출력
			System.out.println("정도전은 책사");
		}
	/*
		결론: "이순신" ,"이성계", "정도전"은의 내용은 출력되지 않는다.
			 else if문은 이전문장이 false이고 현재 문장이 true라면?이라는 의미이기 때문 이다.
		
		
	*/	
	}

}





