## Test76

# 멤버변수(클래스 변수, 인스턴스변수)의 초기화 시기와 순서
 
```	
 - 클래스 변수의 초기화 시점: .class파일내부의 클래스 설계도가 처음 JVM메모리에 로딩될때 단 한번만 초기화가 된다
 							
 - 인스턴스변수의 초기화 시점 : 인스턴스가 생성됭 때 마다 각 인스턴스별로 인스턴스변수의 초기화가 이루어짐
 		
 - 클래스변수의 초기화 순서 : 기본값 -> 명시적 초기화 -> 클래스 초기화블럭을 이용해 초기화
 		
 - 인스턴스 변수의 초기화 순서 : 기본값 -> 명시적 초기화 -> 인스턴스 초기화블럭을 이용해 초기화 -> 생성자
```

```
class Init{
	
	//명시적 초기화
	static int cv = 1; 
	int iv= 1; 
	
	// 클래스초기화 블럭 이용
	static { 
		cv= 2;
	}
	
	// 생성자
	public Init() { 
		iv =3;
	}
}
public class Test76 {
	public static void main(String[] args) { 
		Init init = new Init(); 
		
		System.out.println(Init.cv);
		System.out.println(init.iv);
	}
}

```
# 순서
```
	1. static int cv = 1;

	2. static { cv= 2;}

	3. public static void main(String[] args) {}

	4. iv인스턴스변수 0으로 초기화

	5. Init init = new Init(); 

	6. public Init() { iv =3;}
```

## Test77.java

```
class Product2{
	// 생성된 객체(인스턴스)의 갯수를 저장하기 위한 클래스변수 count선언
	static int count= 0; // 1번째
	
	// 객체(인스턴스)의 고유 번호를 저장하기 위한 인스턴스변수 serialNo 선언
	int serialNo; // 3번째
	
	// 객체(인스턴스) 변수의 값을 저장시키는 인스턴스 초기화 블럭 사용
	// 사용용도 : new Product2() 객체가 생성될때마다 위 count변수의 값을 1씩 증가시켜서 serialNo변수에 저장
	{
		++count;
		serialNo=count;
	} // 4번째
	
	// 기본생성자
	public Product2() {} // 5번째
}
public class Test77 {

	public static void main(String[] args) { // 2번째
		
		// 6번째 : p1 참조변수에 객체의 주소값 저장
		Product2 p1 = new Product2();
		Product2 p2 = new Product2();
		Product2 p3 = new Product2();
		
		// 7번째
		System.out.println("p1참조변수에 저장된 제품객체의(serialNo)는 "+p1.serialNo);
		System.out.println("p2참조변수에 저장된 제품객체의(serialNo)는 "+p2.serialNo);
		System.out.println("p3참조변수에 저장된 제품객체의(serialNo)는 "+p3.serialNo);
		System.out.println("생산된 제품 개수는 모두 "+Product2.count+"개 입니다");
	}
}
```
# static키워드
```
	
main()메소드에서 static을 쓰는 이유는?

- static은 정적 고정된값, 공유값, 즉 static으로 지정한 변수나 메소드들은 객체를 생성하기 전에 JVM메모리에 먼저 올라감

- 일반메소드는 객체를 생성해서 호출될때 JVM메모리에 올라감
  일반메소드의 경우 호출하면 실행후 끝나면 JVM메모리에서 사라짐


main()메소드에서 static을 쓰지 않는다면?

- main()메소드도 일반메소드처럼 누군가에 의해 호출되기전에 JVM메모리에 먼저 올라가지 않음
  즉, 프로그램의 시작점인 main메소드가 먼저 실행되어야하는데, JVM메모리에는 존재하지않게 되고
  그렇게되면 자바프로그램은 아무것도 실행할수 없게 됨


1. 클래스를 설계할때, 멤버변수 중 모든 객체(인스턴스)에 공통적으로 사용하는 것에는 static을 붙임
	
	- 인스턴스를 생성하면, 각인스턴스들은 서로 독립적이기 때문에 서로 다른 값을 유지함
	  경우에 따라서는 각인스턴스들이 공통적으로 같은 값이 유지되어야하는 경우 static을 붙임

2. static이 붙은 멤버변수는 인스턴스를 생성하지 않아도 사용할 수 있음
	
	- static이 붙은 멤버변수(클래스변수)는 클래스가 JVM메모리에 올라갈때 자동적으로 생성되기 때문

3. static이 붙은 메소드에서는 인스턴스변수를 사용할 수 없음
	
	- static이 붙은 메소드는 인스턴스 생성없이 호출가능한 반면, 인스턴스변수는 인스턴스를 생성해야만 존재하기때문에
	  static이 붙은 메소드(클래스메소드)를 호출할때 인스턴스가 생성되어 있을수도 그렇지 않을 수도 있어서
	  static이 붙은 메소드에서 인스턴스변수의 사용을 허용하지 않음
	  (반대로, 인스턴스변수나 인스턴스메소드에서는 static이 붙은 멤버들을 사용하는 것이 언제나 가능함
	  	인스턴스변수가 존재한다는 것은 static이 붙은 변수가 이미 메모리에 존재한다는 것을 의미하기 때문)

4. 메소드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려함

	- 메소드의 작업내용중에서 인스턴스변수를 필요로한다면, static을 붙일수 없음
	  반대로 인스턴스변수를 필요로하지 않는다면, 가능하면 static을 붙이는 것이 좋음
	  메소드 호출시간이 짧아지기 때문에 효율이 높아짐
	   (static을 안붙인 메소드는 실행시 호출되어야할 메소드를 찾는 과정이
	   	추가적으로 필요하기 때문에 시간이 더 걸림)

5. 클래스 설계시 어떤경우 static을 붙여서 변수나 메소드를 만들어야 할까?

	- 먼저 클랴스의 멤버변수중 모든 인스턴스에 공통된 값을 유지해야하는 것이 있는지 살펴보고 있으면 static을 붙여줌

	- 작성한 메소드중 인스턴스변수를 사용하지 않는 메소드에 대해서 static을 붙일 것을 고려함

	- 메소드중에서 일반적으로 인스턴스변수와 관련된 작업을 하는 메소드는 인스턴스메소드(static이 안붙은 메소드)이고,
		static변수(클래스변수)와 관련된 작업을 하는 메소드는 클래스메소드(static이 붙은 메소드)라고 보면 됨


※ 다른 일반메소드나 변수에 static으로 지정하면? ※

-> 가능하지만, 모든 메소드와 변수들을 static으로 선언한다면 JVM메모리가 가득차게되어 메모리 오버플로우가 발생하게 됨
	슈퍼컴퓨터는 가능하지만 일반적이지 않음
		==> 각객체가 공통적인 속성의 값을 사용해야하는 경우 static변수로 선언하고
			그렇지 않을 경우에는 인스턴스변수로 선언해야함
```

## Test78.java

# 상속
```
	상속개념

 - 기존의 클래스에 기능을 추가하거나 재정의하여 새로운 클래스를 정의하는 것

 - 상속을 이용하면 기존에 정의 되어있는 클래스의 모든 변수와 메소드를 물려받아, 새로운 클래스를 생성할 수 있음

 - 이때 기존에 정의되어 있던 클래스를 부모클래스, 상위클래스, 기초클래스 라고함
   상속을 통해서 새롭게 작성되는 클래스를 자식클래스, 하위클래스, 파생클래스 라고함

```

# 자식클래스(child class)
```
- 부모클래스의 모든 특성을 물려받아 새롭게 작성된 클래스를 의미

자바에서 자식클래스를 설계하는 문법

	class 자식클래스이름 extends 부모클래스이름{
		...
	}
```

```
// 기존에 존재하는 부모클래스 -> Parent클래스
class Parent{
	public void parentPrn(){
		System.out.println("부모클래스 메소드는 상속 된다");
	}
}
// 상속을 통해 새롭게 설계 하는 자식클래스 -> Child 클래스
class Child extends Parent{

//	물려받음
	
//		public void parentPrn(){
//		System.out.println("부모클래스 메소드는 상속 된다");
//	}
	
//	물려받음
	
	public void childPrn() {
		System.out.println("Child클래스의 메소드이다.");
	}
}
public class Test78 {
	public static void main(String[] args) {
		// 자식클래스(Child클래스)를 이용해 객체 생성
		
		Child c = new Child();
		
		//부모클래스(Parent클래스)로 부터 상속받은 parentPrn()메소드 호출 가능
		c.parentPrn();
		
		//자식클래스(Child클래스)자기 자신의 childPrn()메소드 호출 가능
		c.childPrn();
		
		System.out.println("----반----대----로----");
		
		// 부모클래스(Parent클래스)를 이용해 객체 생성
		
		Parent p = new Parent();
		
		//부모클래스(Parent클래스)자기 자신의 parentPrn()메소드 호출 가능
		p.parentPrn();
		// 자식클래스(Child클래스)의 메소드 호출 불가능
//		p.childPrn();
		
	}
}
```
### 결론
```
	상속이란 부모가 가진 재산이나 권력을 자식에게 물려주는 것
	자식클래스가 부모클래스의 멤버를 상속받아 사용할 뿐,
	부모클래스를 이용해 생성된 객체가 자식클래스의 메소드를 호출해서 사용할 수 없음
```

### Test79.java

# 코드를 재활용하는 상속의 장점
```
 - 기존의 클래스에 새로운 내용을 추가하거나 변경할때에 기존의 클래스에 변경된 내용만 추가하여
 	새로운 클래스를 만들어 기존클래스의 변수나 메소드를 그대로 사용할 수 있음
```

## getter, setter 메소드
```
단축키 : (ctrl+Shift+s) - r ||  Alt - s -r


get으로 시작하는 메소드가 하는 역할

 - private으로 선언된 변수값을 외부클래스에 제공(반환)해 줄 목적

set으로 시작하는 메소드가 하는 역할

 - 외부클래스에서 현재클래스의 private으로 선언된 변수에 접근하여 새로운 값을 설정할 목적

```

## Point2D 클래스
```
class Point2D{
	private int x;
	private int y;
	
	public int setX(int x) {
		this.x = x;
		return this.x;
	}
	
	public int getX() {
		return x;
	}
	
	public int setY(int y) {
		this.y = y;
		return this.y;
	}
	
	public int getY() {
		return y;
	}
}
```
## Point3D 클래스
```
// 3차원 공간상의 좌표값 한점을 나타내는 x,y,z를 저장하여 공하는 Point3D클래스 만들기


class Point3D{
	private int x; //Point2D클래스의 x변수와 중복
	private int y; //Point2D클래스의 y변수와 중복
	private int z;
	
	// 변수하나당 setter역할을 하는 메소드 getter역할을 하는 메소드 만들기 단축키
	// ctrl+Shift+s -> r || Alt + s + r
	
//	get으로 시작하는 메소드가 하는 역할
//	 - private으로 선언된 변수값을 외부클래스에 제공(반환)해 줄 목적

//	set으로 시작하는 메소드가 하는 역할
//	 - 외부클래스에서 현재클래스의 private으로 선언된 변수에 접근하여 새로운 값을 설정할 목적
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}	
}
```

### Point2D, Point3D 클래스에서의 중복
```
private int x
private int y
getX(),setX()
getY(),setY()
```

### Point2D, Point3D 클래스의 중복된 코드간의 상속관계 도입

```
Point3D클래스를 수정해서 Point3DTest클래스로 새로만들기
Point2D클래스의 모든 멤버들을 상속받아 Point3DTest 새로운 클래스 만들기
```

## Point3DTest 클래스
```
class Point3DTest extends Point2D{

/*	private int x;  Point2D클래스로부터 상속받은 x변수
	private int y;  Point2D클래스로부터 상속받은 y변수
*/
	private int z;

/*
 	Point2D클래스로부터 상속받아 사용하는 메소드들
 	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
*/	

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
}
```
## Test79 클래스 (main 메소드)
```
public class Test79 {

	public static void main(String[] args) {
		
		Point3DTest pt = new Point3DTest();// 자식클래스로부터 객체 생성
		
		//Point2D클래스로부터 상속받아 사용하는 setX()메소드 호출
		pt.setX(10);
		
		//Point2D클래스로부터 상속받아 사용하는 setY()메소드 호출
		pt.setY(20);
		
		//Point3DTest클래스를 이용해 생성한 객체 자기자신의 setZ()메소드 호출
		pt.setZ(30);
		
		//Point2D클래스로부터 상속받아 사용하는 getX()메소드, getY()메소드 호출
		System.out.print(pt.getX()+", "+pt.getY());
		
		//Point3D클래스를 이용해 생성한 객체 자기자신의 getZ()메소드 호출
		System.out.println(", "+pt.getZ());
		
	}
}
```

### Test80.java

## 상속연습
```
(x,y)의 한점을 표현하는 Point클래스와
Point클래스를 상속받아 컬러점을 표현하는 ColorPoint클래스를 새롭게 만들어보자

(x,y)의 한점을 표현하는 Point클래스(부모클래스) 선언
	- 한점을 구성하는 x,y인스턴스변수 선언
	- 인스턴스변수 x,y에 데이터를 새롭게 초기화시킬 set메소드 만들기
	- 한점의 좌표"(x,y)" 문자열형태로 출력하는 showPoint메소드 만들기

Point부모클래스를 상속받아 새롭게 정의하는 ColorPoint클래스(자식클래스)선언
	- 점의 색을 문자열로 저장시킬 인스턴스변수 color 선언
	- 점의 색을 매개변수로 전달받아 새롭게 저장할 setColor메소드 만들기
	- color변수에 저장된 컬러점의 좌표를 출력하는 기능의 showColorPoint메소드 만들기
		- 출력기능
			・ 1. color변수의 값 출력
			・ 2. 한점의 좌표"(x,y) 문자열형태로 출력

출력 결과
red(3,4)

		 1. ColorPoint객체 생성, 참조변수 이름 cp
		 2. 부모클래스인 Point클래스로부터 상속받은 set메소드 호출시 3,4 전달
		 3. ColorPoint객체의 color변수에 "red"문자열 저장하기 위해 메소드 호출
		 4. 컬러점의 좌표를 출력하는 showColorPoint메소드 호출
```

## Point 클래스
```
class Point{
		int x,y;
		
		public void set(int x, int y) {
			this.x = x;
			this.y =y;
		}

		public void showPoint() {
			System.out.println("("+x+","+y+")");
		}
	}
```

## ColorPoint 클래스
```
class ColorPoint extends Point{
		String color;

		public void setColor(String color) {
			this.color = color;
		}

		public void showColorPoint() {
			System.out.print(color);
			showPoint(); // Point 클래스로 상속받은 showPoint메소드 호출가능
		}
	}
```

## Test80 클래스(main)
```
public class Test80 {
	public static void main(String[] args) {
		
		ColorPoint cp = new ColorPoint();
		cp.set(3,4);
		cp.setColor("red");
		cp.showColorPoint();
		
	}
}
```