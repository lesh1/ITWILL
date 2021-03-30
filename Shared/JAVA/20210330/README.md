# 패키지.txt
```
	패키지(package)

클래스와 인터페이스의 집합을 의미

서로 관련이 있는 클래스나 인터페이스를 함께 묶음으로써 파일을 효율적으로 관리 할수 있게 됨
협업시 서로 작업한 클래스 사이에서 발생할 수있는 이름 충돌문제를 패키지를 이용해 피할 수 있음

- 자바에서 패키지는 물리적으로 하나의 디렉터리를 의미
 하나의 패키지(디렉터리)에 속한 클래스나 인터페이스 파일은 모든 해당 패키지 이름의 디렉터에 포함 되어 있음
 패키지는 다른 패키지를 포함할 수 있으며,  이때 디렉터리의 계츨구조는 .점으로 구분

 예) 자바에서 가장 많이 사용되는 패키지중 하나인 String 클래스의 패키지 이름 (java.lang.String)



 패키지 선언 : 특정 Class가 속한 폴더명(패키지명)을 .java파일에 선언 해 놓음
 				단, Class 밖 가장 위쪽에 작성 해 놓아야함

 문법

 package 클래스가 속한 패키지명;

```
```
 이름이 없는 패키지?
 - 자바의 모든 클래스는 반드시 하나 이상의 패키지에 포함되어야 함
   하지만 자바 컴파일러는 소스 파일에 어떠한 패키지의 선언도 포함되어 있지 않으면,
   기본적으로 이름이 없는 패키지에 포함해 컴파일함
   따라서 명시 하지 않으면 모든 클래스와 인터페이스는 모두 같은 패키지에 포함되게 된다.


```

# import.txt

```
import

- 다른 패키지에 속한 클래스를 다른 파일에서 사용하기 위해서는 클래스 이름 앞에 패키지의 경로까지
  포함한 풀네임을 명시해서 사용해야함
  
  ※따라서 import문은 자바컴파일러에 코드에서 사용할 클래스의 패키지에 대한 정보를 미리 제공하는 역할을 함※

  요약: import문을 사용하면 다른 패키지에 속한 클래스를 현재 페이지에서 사용할 수 있도록 자바 컴파일러에게 알려주는 문법

----------------------------예 시 -------------------------------------------

package A;

다른 패키지(java.lang패키지)에 속해 있는 ArrayList클래스를
현재 A 패키지에 속해 있는 B클래스 내부에서 사용 하기위해
자바 컴파일러에게 ArrayList클래스를 현재 B클래스 내부에서 사용하겠다라고 말해줘야함

import java.util.ArrayList


```

## import 문의 선언 방법 
```
import문의 선언 방법

문법
	1. import 패키지이름.클래스이름;
	-	ex) import java.util.ArrayList;

	2. import 패키지이름.*;
	- 	ex) import java.util.*;

1. 해당 패키지의 특정 클래스만을 사용하고자 할때 사용
2. 해당 패키지의 모든 클래스를 클래스이름만으로 사용하고 싶을때 사용

```
## import문의 특징 

```
import문을 선언할때 별표 * 사용하는 것이 해당 패키지에 포함된
다른 모든 하위 패키지의 클래스까지 포함해 주는 것은 아님

문법 

import java.awt.*;

import java.util.;


// 위와 같은 두개의 import문을 아래와 같이 하나의 import문으로 표현할 수 없음

import java.*; 


참고

- 자바에서 가장 많이 사용하는 java.lang패키지에 대해서는
  import문을 사용하지 않아도 클래스 이름만으로 사용할 수 있도록
  자바 컴파일러가 자동으로 해결해 주고 있음

```
### import 문은 반드시 클래스 선언 전에 나와야함
### 소스의 앞 부분에 선언되어야 함

# Test69.java

```
public class Test69 {
	public static void main(String[] args) {

	// 다른 패키지에 있는 클래스 사용하기 위해
	// 패키지명을 포함하는 클래스 경로명을 사용해야 한다.
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	// System 클래스는 java.lang 패키지에 속해있으므로 생략
	// System클래스의 in 상수 내부에 new InputStream();객체가 저장되어 있다
	// -> 채팅시 데이터를 입력하면
	// 바이트 단위로 데이터를 읽어 들이기 위한 스트림 통로 역할을 한다
		
//	java.util.ArrayList arrayList1; 가능
//	ArrayList arrayList2; 불가능 
	}
}

```
```

//2. 
	import java.util.Scanner;
public class Test69 {
	public static void main(String[] args) {

	// import문 

	// 다른 패키지에 있는 클래스 사용할때 그 클래스의 경로명을 선언하여
	// 자바 컴파일러에게 알려주는 구문
	// 문법 ) import 패키지명.클래스명;
	// 주의할점) 항상 클래스 밖 맨 위쪽에 import 구문을 작성해 놓아야함

	//2.
	Scanner scanner2= new Scanner(System.in);
	System.out.println(scanner2.next());
	
	}
}

```
```
//3.

import java.util.*

public class Test69 {
	public static void main(String[] args) {

	// import문 

	// 3. java.util패키지 내부에 있는 Scanner클래스 뿐만 아니라
	// 모든 클래스들을 사용 가능하게 하려면...
	// 문법) import 패키지명.*;

	//3.

	// System.in <- System클래스의 in 상수에 InputStream객체 얻기
	// new Scanner(System.in) <- InputStream객체를 지니고 있는 Scanner객체 생성

	Scanner scanner3= new Scanner(System.in);

	// scanner3.next()
	// InputStream객체(입력한 데이터를 바이트 단위로 읽어 들일 통로)
	// 를 이용해 읽어 들인 데이터들을 문자열로 변환해서 얻기 위해
	// Scanner객체의 next()메소드를 호출하여 문자열로 변환후 변환 받아 출력

	System.out.println(scanner3.next());
	
	}
}

```

### InputStream 객체의 역할


```
InputStream  : 1바이트 단위로 데이터를 읽어 들이기 위한 통로

outputStream : 읽어들인 데이터를 바깥으로 내보내기 위한 통로

Scanner : 1바이트 단위로 데이터를 읽어 들인 값을 정수나 실수값으로 받아들이기 위한 역할

```
### Scanner 

```
scanner.next() : 문자열로 값을 받아들임
scanner.nextInt() : 정수로 값을 받아들임
scanner.nextDouble() : 실수로 값을 받아들임
```


## 패키지 만들기 (src -> new - Package -> )

```
package 이름 : lib , app

lib -> 마우스 오른쪽 -> class 만들기 (A.Class)


package lib; //A클래스는 다음과 같이 package lib문을 자동으로 포함하고 있다.

//해석 : 아래의 class A는 lib폴더(패키지)에 포함되어 있다

public class A{ // public 을 반드시 붙여야 한다.
				// 이유 : 다른 패키지에서 A클래스에 접근 하기 위함
	int x,y;

	// 기본생성자
	
	public A(){
		System.out.println("lib패키지에 존재하는 A클래스에 접근");
	}	
	
	// 객체 생성시 x,y객체변수의 값을 초기화 시킬 생성자
	
	public A(int x, int y){
		this.x = x;
		this.y = y;
	}

	// 객체 변수 x와y에 저장된 값을 출력하는 기능의 메소드
	public void prn(){
		System.out.println("x : "+x+", y: "+y);
	}
}
```

```
app -> 마우스 오른쪽 -> class 만들기 (B.Class)

package app;

// import문 사용하기

// 다른패키지(lib패키지) 내부에 작성되어 있는 A클래스를
// 현재 B클래스 내부에서 사용하기 위해 컴파일러에게 패키지명을 포함한 A클래스의 경로를
// 알려주어야한다. 그럴때 import문을 사용한다


import lib.A;

public class B {

	public static void main(String[] args) {
		A a= new A();
		A a1= new A(1,2);
		a1.prn();
		
		/* 출력결과 
		    lib패키지에 존재하는 A클래스에 접근
		    x : 1, y: 2 */

	}

}
```

# Test70.java

### 멤버변수 종류 2가지
```
1. 객체변수(인스턴스변수)

 -static 단어가 붙어 있지 않는 변수
 
-새로운 new Test(); 객체를 생성할때 마다 new Test(); 객체들이 개별적으로 가지고 있는 변수

- 객체가 생성되어 올라가는 Heap영역의 객체 내부에 변수의 메모리를 할당 함

ex) int x;

2. 클래스변수(정적변수)

- static 단어가 붙은 변수

- Class Test가 올라가는 JVM의 Method영역에 메모리를 할당 받는 변수

- 클래스 단위당 한번만 변수 메모리를 할당함

- new Test()객체를 생성하지 않고 클래스이름으로 바로 접근 가능한 변수

- 생성된 여러 new Test()객체들이 공용으로 사용되는 변수

ex) static int y;
```
```
 Class Test{
 	int x;
 	static int y;

 	//생성자
 	//매개변수 z의 값을 전달받아 x변수와 y변수에 각각 누적시키는 생성자
	
 	public Test(int z){
		x+=z;
		y+=z;
	}
 }

 public class Test70{
	public static void main(String[] args){

		//1. 클래스 변수 y에 접근하여 출력하기
		// 방법 : 객체 생성 없이 클래스명.클래스변수명

		System.out.println("클래스명.클래스변수명 = "+ Test.y);

		//2. 인스턴스 변수 x를 객체 생성 없이 클래스명.인스턴스변수명으로 접근가능? - 불가능
		//System.out.println("클래스명.클래스변수명 = "+ Test.x);
		
		//3. 인스턴스 변수 x에 접근해서 사용하기 위해
		//new Test(10); 객체 생성
		Test t1 = new Test(10);
		System.out.println("Test t1객체");
		
		//인스턴스 변수 x에 접근 하여 x변수값을 얻는 방법
		//참조변수명.인스턴스변수명
		System.out.println(t1.x);

		//클래스 변수 y에 접근하여 y변수값을 얻는 방법
		//참조변수명.클래스변수명
		System.out.println(t1.y);

		/*결론: static으로 선언된 클래스 변수에 접근하는 방법
		
		1. 클래스명.클래스변수명 접근가능
		2. 객체 생성후 참조변수명.클래스 변수명  접근가능
		*/

		//Test클래스로부터 객체 생성, 참조변수명 t2
		Test t2= new Test(10);
		System.out.println("Test t2객체");
		
		//인스턴스 변수 x에 접근 하는 방법: 참조변수명.인스턴스변수명
		System.out.println(t2.x); //10
		//클래스변수 y에 접근 하는 방법: 참조변수명.클래스변수명
		System.out.println(t2.y); //20
		
		/*결론 :
		 위 출력 결과를 보면 static으로 선언된 클래스변수 y는?
		 하나의 클래스 단위당 한개의 클래스 변수만 JVM메모리에 올라가므로
		 위의 t1,t2 참조변수에 저장된 각 객체가
		 클래스 변수 y 하나를 공유받아 사용하므로
		 기존에 있던 클래스 변수 y내부에 저장된 값이 계속 += 누적된다고 보면된다.	
		*/
		
		// 사실 확인을 위해 한번더 객체 생성
		Test t3 = new Test(10);
		System.out.println("Test t3객체");
		//인스턴스변수 x에 접근하여 인스턴스변수 x 값 출력
		System.out.println(t3.x);
		//클래스변수 y에 접근하여 클래스변수 y 값 출력
		//방법2. 믈래스명.클래스변수명;
		System.out.println(Test.y);
		
		//방법1
//		System.out.println(t3.y); 
	}
}
```
## 중요 결론
```	
1. 	객체 단위로 메모리할당하는 인스턴스변수(객체변수)는
	인스턴스(객체) 개별적으로 따로 JVM메모리의 heap영역에
	할당하기 때문에 개별적인 인스턴스변수로 10이 각각 저장됨
		 	
2.	클래스변수 y는 생성된 각 객체들이 공유받아서 사용할 목적으로
	클래스를 설계할때 생각하고 만들어 주어야한다.
```

# Test71.java
### 클래스 내부의 멤버변수 만들기 연습1
```
1. Student클래스 만들기

2. 인스턴스 변수 선언 : 4바이트 크기의 정수를 저장할 num변수 선언

3. 클래스변수 선언 : 4바이트 크기의 정수를 저장할 staticNum 변수 선언

4. 클래스변수 선언 : 4바이트 크기의 정수를 저장할 staticNum 변수 선언

5. 메소드 선언 : 매개변수add로 하나의 정수값을 전달받아 인스턴스변수와 클래스변수에 누적하는 기능의 add메소드 선언

```
```
class Student{
	int num;
	static int staticNum;
	Student() {
		
	}
	
	public void add(int number) {
		num+=number;
		staticNum+=number;
	}
}
```
### a_student 출력결과
```
//참조변수 a_student에 저장된 객체
//인스턴스변수 num의 값 : 5
//클래스변수 staticNum의 값 : 5
```
```
Student a_student= new Student();
a_student.add(5);
System.out.println("참조변수 a_student에 저장된 객체");
System.out.println("인스턴스변수 num의 값 : "+a_student.num);
System.out.println("클래스변수 staitcNum의 값 : "+a_student.staticNum);
```

### b_student 출력결과
```
//참조변수 b_student에 저장된 객체
//인스턴스변수 num의 값 : 5
//클래스변수 staticNum의 값 : 10
```
```
Student b_student= new Student();
b_student.add(5);
System.out.println("참조변수 b_student에 저장된 객체");
System.out.println("인스턴스변수 num의 값 : "+b_student.num);
System.out.println("클래스변수 staitcNum의 값 : "+b_student.staticNum);
```