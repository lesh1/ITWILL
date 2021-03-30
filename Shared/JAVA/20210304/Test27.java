

//switch 조건문 연습문제2
public class Test27 {
	public static void main(String[] args) {

		//Math클래스 내부에 있는 random함수를 호출하여 
		//1 ~ 10사이의 랜덤한 값 하나를 정수로 얻어 int score변수에 저장
		
		
		//문자열 저장할 String타입의  msg변수 선언 하고  ""<--저장
		
		//score = score  * 100;  <--다른 표기법으로 작성
		
		msg = "당신의 점수는" + score + "이고, 상품은";
		
		/*	
		  switch 문을 이용하여
		  1000점일 경우  msg변수에 "자전거, " <--누적
		  900점일 경우  msg변수에  "TV, " <--누적
		  800점일 경우  msg변수에  "노트북 컴퓨터, " <--누적
		  700점일 경우 msg변수에  "자전거, " <--누적
		  위의 모든 점수에 만족하지 않을때... msg변수에 "볼펜 " <--누적
		*/
		
		
		System.out.println(msg + "입니다.");
	}

}




