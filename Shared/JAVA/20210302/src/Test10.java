
/*
	비교 연산자란?
		-	피연산자 사이의 상대적인 크기를 판단 하는 연산자
		-   비교연산자는 왼쪽의 피연산자와 오른쪽의 피연산자를 비교하여
		    어느 쪽이 더 큰지, 작은지, 또는 서로 같은지를 판단 하는 연산자
		-   비교연산자는 모두 두개의 피연산자를 가지는 이항 연산자이며,
			피연산자들의 결합 방향은 왼쪽에서 오른쪽입니다.

	비교 연산자의 종류
	
	비교연산자 					설명
	==						왼쪽의 피연산자와 오른쪽의 피연산자가 같은면 참을 반환 하는 연산자
	!=						왼쪽의 피연산자와 오른쪽의 피연산자가 같지 않으면  참을 반환 하는 연산자
	>						왼쪽의 피연산자가 오른쪽의 피연산자보다 크면 참을 반환 하는 연산자
	>=						왼쪽의 피연산자가 오른쪽의 피연산자보다 크거나 같으면 참을 반환 하는 연산자
	<					    왼쪽의 피연산자가 오른쪽의 피연산자보다 작으면 참을 반환 하는 연산자
	<=						왼쪽의 피연산자가 오른쪽의 피연산자보다 작거나 같으면 참을 반환 하는 연산자
	
*/
public class Test10 {

	public static void main(String[] args) {
		
		//1. 10과 100이 같으냐 물어보는 비교 연산자  == 사용
		System.out.println( 10 == 100); // 10 == 100 의 결과는 참 또는 거짓 중 거짓이 나온다.
										// 거짓(false)
		
		//2. 10과 100이 다르냐 물어보는 비교 연산자  != 사용
		System.out.println(10  != 100); //다르면? 참(true) , 같으면(false)
										//true
		
		//3. 10이 100보다 작냐 물어보는 비교 연산자  < 사용
		System.out.println(10 < 100);//작으면? 참(true), 같으면 (false)
								     //true
		
		//4. 10이 100보다 작거나 같냐? 물어보는 비교 연산자  <=  사용
		System.out.println(10 <= 100); //작거나 같으면 참(true), 작거나 같지 않으면 (false)
									   //true
		
		//5. 10이 100보다 크냐? 물어보는 비교 연산자 > 사용
		System.out.println(10  > 100); //크면? 참(true) 작으면 거짓(false)
									   //false
		
		//6. 10이 100보다 크거나 같냐? 물어보는 비교 연산자   >= 사용
		System.out.println(10   >=   100 );//크거나 같으면 참(true) 크거나 같지 않으면 거짓(false)
										   //false
		
		System.out.println("=====================================");
		
		//예제 주제 : 소문자 'b'와 대문자 'B'를 비교 연산자로 비교하는 예제.
		
		char ch1 = 'a'; //아스키코드 10진수 97
		char ch2 = 'A'; //아스키코드 10진수 65
		
		System.out.println("== 연산자에 의한 결과 : " +  (ch1 == ch2)   ); //false
		System.out.println(" > 연산자에 의한 결과 : " +   (ch1 >  ch2)  ); //true
		
		
	}

}






