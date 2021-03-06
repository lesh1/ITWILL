/*
2. 반복문
	반복문이란 프로그램 내에서 똑같은 명령을 일정 횟수만큼 반복하여 수행하도록 제어하는 명령문입니다.
	프로그램이 처리하는 대부분의 코드는 반복적인 형태가 많으므로,
	가장 많이 사용되는 제어문 중 하나 입니다.
		
   반복문의 종류
   
   1. while 반복문
   2. do while 반복문
   3. for 반복문
   4. 향상된 for 반복문

*/
public class Test29 {
	public static void main(String[] args) {
/*
 	1. while 반복문
 		
 		문법
 			초기식;
 			
 			while(조건식){
 			
 				조건식의 결과가 참인 동안 반복적으로 실행하고자 하는 명령문;
 				
 				조건식의 결과를 변경하는 명령문;
 			}
 	
 		해설 :  while문은 우선 조건식이 참(true)인지를 판단하여, 참이면 내부의 명령문을 실행함
 			   내부의 명령문을 전부 실행하고 나면, 
 			   다시 조건식으로 돌라와 또 한번 참인지를 판단하게됩니다.
 			   이렇게 조건식의 검사를 통해 반복해서 실행되는 반복문을 루프(loop)라고 합니다.
 */
		
		//예제.  while반복문을 5번 반복해서 실행하는 예제.
		
		int i = 0 ; //초기식;
		
		while(i < 5) {//조건식 -> i변수의 값이 5보다 작을 동안 { }내부의 명령문을 반복 수행
			
			System.out.println("while문이" + (i+1) + "번째 반복 실행 중입니다.");//명령문
			
			i++;//증감식;
		}
		
		System.out.println("while문이 종료된 후 변수 i의 값은" + i + "입니다.");
		
		//참고 : 위 예제에서 조건식의 결과를 변경하는 명령문인 증감식 i++; 를 제거 하면
		//      변수 i의 값은 언제나 0이기 때문에 무한 루프에 빠지게 됩니다.
		
		
		
	}

}




