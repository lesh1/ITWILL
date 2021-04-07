package PA;

//PA패키지에 속한 A클래스 
public class A {
	int i; //default
	protected int pro;
	private int pri;
	public int pub;
	
	public void print() {
		System.out.print("i=" + i + ",");
		System.out.print("pro=" + pro + ",");
		System.out.print("pri=" + pri + ",");
		System.out.print("pub=" + pub + " 입니다.");
		System.out.print("결론= 서로다른패키지에 있는 경우 접근 값 출력.");
	}
}
