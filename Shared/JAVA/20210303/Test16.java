
/*
	연산자 문제3)
	
	아래의 변수 num의 값 중에서  백의 자리 이하를 버리는 코드이다.
	만일 변수 num의 값이 456이라면  400되게 하고
					  111이라면  100되게 하여 출력 하면 된다.
	( )안에 알맞은 코드를 넣으시오.
	
	힌트->  나눗셈 연산자는  반올림을 하지 않고 버림을 한다. 이성질을 이용한 문제이다.
*/
public class Test16 {
	public static void main(String[] args) {

		int num = 456;///111도 테스트 해보기 
		
		System.out.println( num / 100 * 100 ); //400
		
	}

}



