
// if문  -> switch문으로 바꾸기 

public class Test28 {

	public static void main(String[] args) {
	/*
		int score = 45; //점수
		
		char grade = '\u0000';
		
		//score변수에 저장된 점수가 90점 이상이라면 A학점 
		if(score >=  90) {
			grade = 'A';
		//score변수에 저장된 점수가 80점 이상이라면 B학점
		}else if(score >= 80) {
			grade = 'B';
		//score변수에 저장된 점수가 80미만 이라면 C학점
		}else {
			grade = 'C';
		}
		
		System.out.println("당신의 학점은" + grade + "입니다.");
	*/	
		
		int score = 45; //점수
		
		char grade = '\u0000';//학점 저장할 변수 
		
		switch(score) {
			case 100: case 99: case 98: case 97: case 96:
			case 95:  case 94: case 93: case 92: case 91: case 90:
				grade = 'A';
				break;
			case 89:case 88:case 87:case 86:case 85:case 84:case 83:
			case 82:case 81:case 80:
				grade  = 'B';
				break;
			default:
				grade = 'C';
				break;
		}
		
		System.out.println("당신의 학점은" + grade + "입니다.");

	}

}







