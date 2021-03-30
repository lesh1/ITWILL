/*

	7. 삼항 연산자란?
	
	  - 자바에서 유일하게 피연산자를 세 개나 가지는 조건 연산자입니다.
	  
	  
	  - 삼항 연산자의 문법
	  
	  	조건식 ? 반환값1 : 반환값2

		해석 : 물음표?앞의 조건식에 따라 결괏값이 참(true)이면 반환값1을 반환하고,
		                                  거짓(false)이면 반환값2를 반환합니다.
 */
public class Test13 {

	public static void main(String[] args) {
		
		int num1 = 5 , num2 = 7;
		
		int result;
		
	   //result = 조건식  ?  조건식에 만족하면 사용할값  : 조건식에 만족하지 않을때 사용할 값;
		 result = (num1 - num2 > 0) ? num1   :  num2;
		
		 System.out.println("두 정수 중 더큰 수는 " + result +  "입니다.");
		 
		 System.out.println("------------------------------------");
		 
	   //예제) 삼항 연산자를 이용해서  3개의 변수에 저장된 값들 중에서 최대값을 구하는 프로그램
	   int c = 12;
	   int d = 4;
	   int e = 19;
	   
	   //c변수에 값과 d변수에 저장된 값을 비교 해서 큰값을 변수 max에 저장
	   int max = (c > d)  ?   c : d;
	   //        (12> 4)  ?  12 : 4;
	   //max변수에 저장되어 있는 12와 e변수에 저장되어 있는 19를 비교해서 큰값을  max변수에 다시저장
	   max = (max > e) ?  max : e;
	   //    (12  > 19)?  12  : 19;
		 
	   System.out.println("최대값은?" + max);

	}

}





