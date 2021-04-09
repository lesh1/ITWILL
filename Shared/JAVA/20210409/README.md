# 자바에서 다형성 개념의 문법들

```
	1. 메소드 오버로딩 : 같은 이름의 메소드를 규칙에 맞게 여러개 선언
	2. 생성자 오버로딩 : 같은 이름의 생성자를 규칙에 맞게 여러개 선언 
	3. 업캐스팅 : 부모클래스타입의 참조변수 하나에 여러 자식객체를 저장
	4. 메소드 오버라이딩 : 상속관계에서 부모클래스에 정의된 메소드를 자식클래스에 재정의
```

## 업캐스팅이란?
```
	부모클래스 타입의 참조 변수 하나에 여러 자식객체들의 주소를 저장하여 사용할 수 있는 형태를 의미

	부모클래스 타입의 참조변수에 자식객체의 주소를 저장하기 위해 부모클래스 타입으로 형변환시키는 것
```
### 부모클래스 (Parent)
```java
class Parent{
	public void parentPrn(){
		System.out.println("부모클래스 : parentPrn메소드");
	}
}
```

### 자식클래스 (Child)
```java
class Child extends Parent{
	public void childPrn(){
		System.out.println("자식클래스 : childPrn메소드");
	}
}
```
### main 메소드
```java
public class Test94{
	public static void main(String[] args) {
		int a= 10;
		long b =20;
		b=a;

		Child child = new Child();
		child.parentPrn();
		child.childPrn();

		Parent p;
		p=child;
	}
}
```
### main 메소드 설명
```
int a= 10;  					4바이트 크기 a 변수 메모리에 저장 한 정수 10(작은 데이터)
long b= 20;   					8바이트 크기 a 변수 메모리에 저장 한 정수 20(큰 데이터)
b=(long)a; 						4바이트 크기 a 변수 메모리에 저장된 정수 10(작은데이터)을 저장하려고 할 때 직접 강제로 int데이터 10을 long데이터 10L로 데이터의 형태로 변환할 수 있음 ==> 강제 형변환
b=a;							자동으로 int데이터 10을 long데이터 10L로 데이터의 형태가 자동으로 변환 되어 저장됨   ==> 자동 형변환이 일어남
								참조자료형의 형 변환(객체의 주소를 참조 하는 참조변수의 형 변환)
Child child = new Child();		자식객체 생성
								Child자식클래스타입의 참조변수 child로 생성한 new Child() 객체 메모리에 접근하여 호출할 수 있는 메소드는 2 개
child.parentPrn();				부모 Parent객체의 parentPrn() 메소드 호출 가능
child.childPrn();				자식 Child객체의 childPrn() 메소드 호출 가능

Parent p;						1.부모 클래스 타입의 참조변수 선언
								2.부모 클래스 타입의 참조변수에 자식객체의 주소를 저장시 부모클래스 타입으로 형변환해서 자식객체의 주소저장

p =(Parent)child;				업캐스팅 --> 강제 형변환
p= child;						업캐스팅 --> 자동 형변환

								2에서 업캐스팅 후에 Parent p참조변수로 호출할 수 있는 메소드는
								부모 클래스 내부에 있는 parentPrn()메소드만 호출 가능하므로
								업캐스팅을 함으로써 부모클래스 타입의 참조 변수 하나에
								여러 자식객체의 주소를 저장해서 사용할 수 있기 때문에
								참조 변수를 낭비하여 여러개를 만들어 놓지 않아도 되는 장점은 있지만
								부모 클래스에 존재하지 않는 자식 클래스 내부의 메소드는 호출 불가능한 단점도 있음
```

## 다운 캐스팅
```
	업캐스팅으로 인하여 부모클래스 타입의 참조변수로 자식 객체의 모든 멤버에 접근하는 것이 불가능 하여 다운 캐스팅이라는 개념이 나옴

	- 자식 클래스 타입의 참조변수에 부모클래스의 참조변수에 저장된 자식객체의 주소를 다시 저장하는 것
```

### 부모클래스 (Parent)
```java
class Parent1{
	public void parentPrn(){
		System.out.println("부모클래스 : parentPrn메소드");
	}
}
```

### 자식클래스 (Child)
```java
class Child1 extends Parent1{
	public void childPrn(){
		System.out.println("자식클래스 : childPrn메소드");
	}
}
```

### main 메소드
```java
public class Test95{
	public static void main(String[] args) {
		Parent1 p1= new Parent1();
		Child c1;
		c1 = (Child)p1;
		Child1 c2 = (Child)new Parent1();
	}
}
```
### main 메소드 설명
```
Parent1 p1= new Parent1(); 			부모클래스 타입의 참조변수를 선언하고 참조변수에 부모객체 생성하여 주소 저장
Child c1;							자식클래스 타입의 참조변수 선언
c1 = p1;							자동형변환 안됨/ 에러
c1 = (Child) p1;					명시적 (강제) 자식클래스타입으로 형변환 필요
Child1 c2 = (Child)new Parent1();	잘못된 다운캐스팅 예 || 업캐스팅 하지 않고 다운캐스팅 했음
```


### 부모클래스 (Parent)
```java
class Parent2{
	public void parentPrn(){
		System.out.println("부모클래스 : parentPrn메소드");
	}
}
```

### 자식클래스 (Child)
```java
class Child2 extends Parent2{
	public void childPrn(){
		System.out.println("자식클래스 : childPrn메소드");
	}
}
```

### main 메소드
```java
public class Test96{
	public static void main(String[] args) {
		Parent2 p2 = new Child2();
		p2.parentPrn();
//		p2.childPrn();
		Child2 c2;
		c2 = (Child2)p2;

		c2.childPrn();
		c2.parentPrn();

		Parent2 p3 = new Parent2();
		Child2 c3;
		c3= (Child2)p3;

		c3.parentPrn();
		c3.childPrn();
	}
}
```

### main 메소드 설명
```
		*업캐스팅 및 다운캐스팅의 예*

		 			업캐스팅 요약
		 
		 1. 자식클래스를 이용해 자시객체 생성 후 부모클래스 타입의 참조변수에 대입(업 캐스팅)
		 2. 부모클래스타입의 참조변수에 저장된 자식객체의 주소로 자식객체 메모리를 참조할수 있다는 뜻(업 캐스팅)


		 업캐스팅

	Parent2 p2 = new Child2();		부모클래스타입 : Parent2		참조변수 : p2 		자식객체 : new Child2();

					업캐스팅의 단점
업캐스팅을 함으로써 부모클래스타입의 참조변수로 사용할 수 있는 자식객체 (new Child2())의 멤버는 부모클래스 내부에 있는 멤버만 사용할 수 있다는 단점이 있음
	p2.parentPrn(); 	부모클래스(Parent2)에 있는 멤버만 호출 가능
	p2.childPrn();		부모클래스에 없기때문에 호출 불가능


					업캐스팅의 단점을 해결(childPrn()메소드까지 호출가능하게 하기) 
					==> 다운캐스팅 <==
	
	다운캐스팅 순서

순서1. 자식클래스 타입의 참조변수 선언
Child2 c2;

순서2. 자식클래스 타입으로 선언한 참조변수에 부모클래스의 타입의 참조변수에 저장된 자식객체의 주소값을 대입(강제로 다운캐스팅)

c2 = (Child2)p2; 	다운캐스팅

다운캐스팅으로 인해  Child2클래스타입의 참조변수 c2로 childPrn()메소드와 parentPrn()메소드 모두 호출가능

c2.childPrn();
c2.parentPrn();
```

### 다운캐스팅의 잘못된 예
```
생성한 부모객체를 자식클래스 타입의 참조변수에 저장하여 접근하려고 시도할 잘못된 예

부모클래스 타입의 참조변수에 부모객체 생성 하여 저장

Parent2 p3 = new Parent2();

다운캐스팅 시도!
순서1.  자식클래스 타입의 참조변수 선언

Child2 c3;

순서2.	자식클래스 타입으로 선언한 참조변수에 부모클래스타입의 참조변수에 저장된 자식객체의 주소값을 대입함(강제로 다운캐스팅 시켜야 함)

c3 = (child2)p3;  다운 캐스팅함

c3.childPrn();
c3.parentPrn();   

Test96.class파일을 JVM 실행시 예외(Error)발생

--> Exception in thread "main" java.lang.ClassCastException: clas Parent2 cannot at Test96.main(Test96.java:)

기본 데이터 (int,double....)와는 달리 클래스 데이터 간의 형변환(캐스팅)은
두 단계(컴파일 단계, 실행 단계)에 걸쳐서 JMV이 체크함
컴파일상의 에러를 막기 위해서는 다운캐스팅을 명시적으로 해주면 되지만
Test96.class파일을 실행 시키는 단계에서 한번더 에러를 체크함
캐스팅 연사자에 의해 명시적인 다운캐스팅(형변환)을 c3 = (Child2)p3; 하였지만
참조변수 c3가 참조하는 객체의 클래스타입과 일치하지 않는 경우에는
실행 단계에서 ClassCastException이라는 에러 사항이 발생하게 됨

결론 :  업캐스팅으로 인해 자식객체들을 참조하는 부모클래스 타입의 참조변수를
		다시 다운캐스팅 해서 자식객체를 생성할때의 자식클래스 타입과
		참조변수의 클래스타입을 동일하게 하는 것에 한해서만 다운캐스팅을 허용함

```

### 정리
```
다운캐스팅

자식클래스타입으로 형변환 하는 것
멤버를 참조 가능한 영역이 확대 되게 하는 것을 의미
컴파일러에 의해 자동으로 형변환이 되지 않음(프로그래머에 의해 강제로 형변환(캐스팅)이 필요)
객체의 클래스타입과 참조하는 참조변수의 상속관계를 생각하면서 명시적으로 형변환을 해야함
이전에 이미 업캐스팅이 된 참조변수 값을 다운캐스팅하는 경우에만 안전
```

### 중요 포인트 (상속관계가 아닌 두 클래스를 이용해서 다운캐스팅 시도한 잘못된 예)
```
Child2 c4;
String str = new String();

c4=(Child)str;   // 컴파일에러발생!
```

### 메소드 오버라이딩
```
상속관계의 부모클래스의 선언부(메소드이름,매개변수 이름, 반환타입)을 모두 동일하게 자식클래스에 정의하되, 메소드의 {} 사이의 구현 내용만 재정의하는 것
```
### 부모클래스 (부모역할을 하는 클래스)
```java
class P{
	public void p(){
		System.out.println("부모P클래스 내부의 메소드"); // 메소드의 구현부
	}
}
```
### 자식클래스 (P클래스의 모든 멤버를 물려받는 C클래스)
```java
class C extends P {

	//부모 p클래스에 존재하는 p()메소드를 자식C클래스 내부에 메소드 오버라이딩(재구현)
	
	// 단축키 -> alt+Shift+s--> v 메소드 오버라이딩

	@Override // 현재 아래에 있는 p()메소드는 부모클래스로 부터 재정의된 메소드라고 표현
	public void P(){
		//메소드의 구현부를 재정의
		System.out.println("자식C클래스에서 재정의된 P메소드");
	}
	public void c(){
		System.out.println("자식C클래스 내부의 메소드");
	}
}
```	

```java
public class Test97{
	public static void main(String[] args) { 
		// C클래스로 부터 부모객체 생성
		C c = new C();
		// 부모클래스로부터 오버라이딩된 메소드 호출가능?
		c.p(); // 가능
		// C 내부에 있는 메소드 호출가능?
		c.c(); // 가능			
	}
}
```

### 메소드 오버라이딩 연습
```
도형을 나타내는 DObject클래스 만들기

	DObject클래스 타입의 참조변수 next 선언

	기본생성자
		역할: next변수의 값을 null이라는 값으로 초기화

	그리는 기능을 출력하는 draw()메소드 만들기
		출력: "Dobject draw


---------------------------------------------------------

	DObject클래스를 상속받는 선을 그리기 위한 Line 자식클래스 만들기

	DObject 클래스 내부에 만들어져 있는 draw메소드 오버라이딩 시키기
		재구현할 내용
		"Line"

---------------------------------------------------------

	DObject클래스를 상속받는 선을 그리기 위한 Circle 자식클래스 만들기

	DObject 클래스 내부에 만들어져 있는 draw메소드 오버라이딩 시키기
		재구현할 내용
		"Circle"

---------------------------------------------------------

	main메소드

	주제: 오버라이딩된 메소드들 호출

	Line객체 생성 ! 참조변수이름 a 

	a 참조변수를 이용해 오버라이딩된 draw()메소드 호출! 
	(참고: 곧바로 Line객체 내부에 있는 오버라이딩된 draw()메소드가 호출됨 )

	업캐스팅!
	부모클래스 DObject 타입의 참조변수 p 선언 후 자식객체 new Line();를 생성하여 객체 주소 저장

	업캐스팅 이후 부모클래스 DObject 타입의 참조변수p로 draw()메소드 호출
	(참고: p참조변수에는 실제로 저장된 객체는 자식객체인 new Line()객체가 저장되어 있으므로 Line객체의 draw메소드의 실행결과가 출력됨)

```
### DObject 클래스
```java
class DObject{
	DObject next;
	DObject(){
		next=null;
	}
	public void draw(){
		System.out.println("Dobject draw");
	}
}
```
### Line 클래스
```java
class Line extends DObject{
	@Override
	public void draw(){
		System.out.println("Line");
	}
}
```
### Circle 클래스
```java
class Circle extends DObject{
	@Override
	public void draw(){
		System.out.println("Circle");
	}
}
```

```java
public class Test98{
	public static void main(String[] args) {
		Line a= new Line();
		a.draw();

		DObject p = new Line();
		p.draw();	
		/*
			부모클래스 DObject 타입이 참조변수 p로 draw()메소드 호출시 참조변수 p는 DObject클래스 타입이므로
			1. 먼저 은닉된 부모의  draw()메소드를 찾고
			2. 부모 객체draw()와 같은 이름의 메소드가 자식클래스에 있는지 찾아 동적으로 바인딩되어 오버라이딩된 자식 객체의 draw()메소드가 호출되어 실행되게 됨
		*/
	}
}
```

### 자식클래스 내부에서 부모클래스의 메소드를 재구현(오버라이딩)
```
	상속되지 않고 은닉된 부모클래스의 메소드를 호출하는 방법
```

### 부모클래스

```java
class P1{
	public void p1(){
		System.out.println("부모P1클래스의 p1메소드");
	}
}
```

### 자식클래스
```java
class C1 extends P1{
	// 메소드 오버라이딩

	@Override
	public coid p1(){
		super.p1(); // super로 상속받지 못하고 보호된(은닉된) p1()메소드 호출가능
		// 메소드의 구현부 재정의
		System.out.println("자식C1클래스에서 재정의된 p1메소드");
	}
	public void c1(){
		System.out.println("자식C1클래스의 c1메소드");
	}
}
```

### main메소드

```java
public class Test99{
	public static void main(String[] args) {
		C1 c = new C1();
		c.p1(); // 오버라이딩된 p1()메소드 호출

		/* 출력 결과

			부모P1클래스의 p1메소드				super.은닉된 부모객체의 p1()메소드 호출됨
			자식C1클래스에서 재정의된 p1메소드		오버라이딩 된 메소드 내부에서 재정의된 코드 출력문
		*/
	}
}
```
### 부모 클래스의 멤버변수를 상속받아 사용하는 예
```
메소드 오버라이딩시 상속되지 않고 인닉된 부모클래스의 메소드와 같이
부모클래스에 정의된 변수와 같은 이름을 가진 변수를 자식클래스에서 선언할수 있는데
이러한 경우에도 부모클래스의 변수는 자식클래스에서 사용할 수 없게 됨
```
### 부모클래스
```java
class Point2D{
	protected int x= 10;
	protected int y= 20;
}
```
### 자식클래스
```java
class Point3D extends Point2D{
	protected int x=40;
	protected int y=50;

// 같은이름이 있을 경우 상속되지 않음

	protected int z=30;
	public void print(){
		System.out.println(x+","+y+","+z);
	}
}
```
### main메소드
```java
public class Test100{
	public static void main(String[] args) {
		Point3D pt = new Point3D();
		pt.print();  // 10, 20, 30 <-- Point2D를 상속받은 Point3D클래스
	}
}
```
