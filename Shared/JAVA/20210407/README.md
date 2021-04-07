### Test89.java

## super 키워드
```
- 상속관계의 부모객체를 의미
- 상속관계의 자식클래스에서 부모클래스의 구성요소를 명시적으로 호출할 때 사용
```
## super 키워드를 사용하는 2가지 경우
```
1. 부모클래스의 멤버와 자식클래스의 멤버가 같은 이름을 가질 경우
	-> 부모클래스의 멤버를 사용할때 "super.부모멤버이름" 사용

2. 자식클래스에서 명시적으로 부모클래스의 생성자를 호출할 경우
	-> super(매개변수) 형식으로 사용한다

	-> ※주의※ 반드시 자식클래스의 생성자를 정의할 때, super(매개변수)는 첫번째 행에서 부모생성자를 호출해야함
```
### 부모 클래스
```java
class Person{
	int age= 20;
	String name;

	public Person(String name){
		this.name=name;
	}
}
```

### 자식 클래스
```java
class Man extends Person{
	int age=40;
	public Man(String name){
		super(name);		
	}

```
### 생성자
```
Person(부모)생성자는 상속이 안되므로
Man생성자의 첫번째 행에서 super(부모)생성자의 값을 호출

```

### 명시적으로 부모생성자를 호출한 이유
```
Man 자식객체 생성시 자식객체의 생성자가 호출되어
Person 부모객체가 먼저 생성되어야한다
그러므로 자식객체의 생성자를 호출한 후
명시적으로 부모객체의 생성자를 호출하면서 name값을 전달하여
부모클래스에서 name변수의 값을 직접 저장해야한다.
직접 저장한 후에 Man에서 Person으로부터 name을 상속받아 사용한다

--> 인스턴스변수 name 이 Man클래스가 아닌 Person(부모)클래스에 선언된 인스턴수 변수이기 때문에
	변수가 선언된 곳에서 변수초기화 작업을 해줘야하기 때문
```
### 메소드 (자식클래스 자신의 변수를 사용할 때)
```java
public void getInfo(){
	System.out.println(age);
	}
```
### 메소드 (부모클래스의 변수를 사용할 때)
```java
public void getInfo(){
	System.out.println(super.age);
	}
```

```java
	public class Test89{
		public static void main(String[] args) {
			
		}
	}
```

### Test89.java 코드
```java
class Person{
	int age= 20;
	String name;

	public Person(String name){
		this.name=name;
	}
}

class Man extends Person{
	int age=40;
	public Man(String name){
		super(name);		
	}

public void getInfo(){
	System.out.println(age);
	System.out.println(super.age);
}

public void getInfo2(){
	System.out.println("PersonClass Values name print");
	System.out.println("->"+name);
}
}
class Test89{
	public static void main(String[] args) {
		Man m = new Man("Hong");
		m.getInfo();
		m.getInfo2();
	}
}

```

# Test90.java (연습)

### 사원의 이름(String name), 사원의 급여 (int salary) 생성
```java
class Employee{
	 String name;
	 int salary;
```

### 사원의 이름과 급여를 하나의 문자열로 만들어 변환 (getEmployee)
```java
public String getEmployee(){
	return name+","+ salary;
}
```

### 기본생성자는 아무일을 하지 않음
```java
public Employee(){}
```

### 사원의 이름과 급여를 매개 변수로 전달받아 초기화하는 생성자
```java
public Employee(String name, int salary){
		this.name= name;
		this.salary = salary;
	}
}
```

### Employee클래스를 상속받는 새로운 Manager 자식 클래스 만들기
```java
class Manager extends Employee{
	
```

### 부서명을 문자열로 저장시킬 depart 변수 선언
```java
String depart;
	
```

### name, salary, depart변수의 데이터들을 하나의 문자열로 만들어서 반환 할 getManager()메소드 만들기
```java
Manager(String name, int salary,String depart){
		super(name, salary);
		this.depart=depart;
	}
```

### name과 salary그리고 depart 변수의 값을 초기화 시키는 생성자 만들기
```java
public String getManager() {
		return super.name+","+super.salary+","+depart;
	}
}
```
### name과 salary그리고 depart 변수의 값을 초기화 시키는 생성자 설명
```
name과 salary 그리고 depart변수의 값을 초기화하는 생성자
 -> Manager객체 내부에 있는 name인스턴스변수와 salary인스턴스는 상속받아 사용하므로
	Employee객체의 생성자를 다시 호출해(super(name,salary))넘겨주어
	Employee객체 생성자에서 직접 변수의 값을 초기화 시켜줘야함
```

### Employee객체 생성시 생성자로 "홍길동,2000"을 전달하여 변수값 초기화 (참조변수 이름 emp)
```java
class Test90{
	public static void main(String[] args) {
		Employee emp = new Employee("hong",2000);
		System.out.println(emp.getEmployee());
```

### Manager객체 생성시 생성자호출 전달할 값 : "이순신",4000,"개발"하여 변수값 초기화 (참조변수 이름 man)
```java
	Manager man = new Manager("Lee",4000,"develop");
	System.out.println(man.getManager());
	}
}
```

## 전체 문제 
```
super키워드를 이용하여 부모클래스의 멤버 및 생성자를 호출하는 연습

사원의 이름(String name), 사원의 급여 (int salary) 생성

사원의 이름과 급여를 하나의 문자열로 만들어 변환 (getEmployee)

기본생성자는 아무일을 하지 않음

사원의 이름과 급여를 매개 변수로 전달받아 초기화하는 생성자

Employee클래스를 상속받는 새로운 Manager 자식 클래스 만들기

부서명을 문자열로 저장시킬 depart 변수 선언

name, salary, depart변수의 데이터들을 하나의 문자열로 만들어서 
 반환 할 getManager()메소드 만들기

name과 salary그리고 depart 변수의 값을 초기화 시키는 생성자 만들기

Employee객체 생성시 생성자로 "홍길동,2000"을 전달하여 변수값 초기화
참조변수 이름 emp

Manager객체 생성시 생성자호출 전달할 값 : "이순신",4000,"개발"하여 변수값 초기화
참조변수 이름 man


결과
 출력결과

 홍길동,2000

 이순신,4000,개발
```

## 전체 코드
```java
class Employee{
	 String name;
	 int salary;

public String getEmployee(){
	return name+","+ salary;
}

public Employee(){}

public Employee(String name, int salary){
	this.name= name;
	this.salary = salary;
}
}

class Manager extends Employee{
	String depart;
	Manager(String name, int salary,String depart){
		super(name, salary);
		this.depart=depart;
	}
public String getManager() {
	return super.name+","+super.salary+","+depart;
}
}

class Test90{
	public static void main(String[] args) {
		Employee emp = new Employee("hong",2000);
		Manager man = new Manager("Lee",4000,"develop");
		System.out.println(emp.getEmployee());
		System.out.println(man.getManager());
	}
}
```
# Test91.java (연습문제2)

### A클래스 만들기 - 기본생성자 만들기 = 출력 "기본생성자A"

```java
class A{
	public A() {
		System.out.println("기본생성자A");
	}
```

### A클래스 만들기 - 매개변수 x 하나가 존재하는 생성자 만들기 = 출력 "매개변수 x를 받는 생성자A = "+ x

```java
public A(int x) {
		System.out.println("매개변수 x를 받는 생성자A ="+x);
	}
}
```

### B클래스 만들기 (A클래스 상속 받기) - 기본생성자 만들기 = 부모A클래스의 매개변수 x 하나가 존재하는 생성자 호출시 30전달
```java
class B extends A{
	public B() {
		super(30);
	}
```

### B클래스 만들기 - 매개변수x 하나가 존재 하는 생성자 만들기 = 출력 "매개변수 x를 받는 생성자B= "+ x

```java
public B(int x) {
		System.out.println("매개변수 x를 받는 생성자B="+x);
	}
}
```

### main 메소드 - B클래스로부터 객체 생성 (기본생성자 호출), 참조변수이름 b =  출력결과 ==> 매개변수 x를 받는 생성자A = 30
```java
public class Test91 {

	public static void main(String[] args) {
		B b = new B();
		}
}
```
### 호출 순서
```
1. public B()기본생성자 호출
2. super(30)를 통해 부모 객체 A 의 매개변수 x를 받는 생성자 호출 | 호출시 30을 전달
3. 부모객체 A의 매개변수 x가 존재하는 생성자안의  System.out.println("매개변수 x를 받는 생성자A= "+ x); 출력
4. B객체 생성 후 b참조변수에 객체의 주소값 저장

```
## 전체 문제
```
A클래스 만들기
 - 기본생성자 만들기
  출력 "기본생성자A"

  매개변수 x 하나가 존재하는 생성자 만들기
  출력 "매개변수 x를 받는 생성자A = "+ x

B클래스 만들기 (A클래스 상속 받기)

 - 기본생성자 만들기
  	부모A클래스의 매개변수 x 하나가 존재하는 생성자 호출시 30전달

 - 매개변수x 하나가 존재 하는 생성자 만들기
 		출력 "매개변수 x를 받는 생성자B= "+ x

main 메소드
 - B클래스로부터 객체 생성 (기본생성자 호출), 참조변수이름 b

  출력결과를 아래에 복사하여 붙여넣기

  매개변수 x를 받는 생성자A = 30

  호출 순서 상세히 적으시오

  ex) 
  1. public B()기본생성자 호출 됨
  2. super(30)를 통해 부모객체A의 매개변수 x를 받는 생성자 호출 | 호출시 30을 전달
```

```java
class A{
	public A() {
		System.out.println("기본생성자A");
	}
	public A(int x) {
		System.out.println("매개변수 x를 받는 생성자A ="+x);
	}
}

class B extends A{
	public B() {
		super(30);
	}
	public B(int x) {
		System.out.println("매개변수 x를 받는 생성자B="+x);
	}
}
public class Test91 {

	public static void main(String[] args) {
		B b = new B();
	}
}

```
# Test92.java

## 연습문제 3
```
수업시간에 클래스의 생성자 정의 및 호출방식에 대해 설명 드렸습니다.
이내용을 바탕으로 다음 클래스에 적절한 ***생성자***를 삽입해보자. 
그리고 이의 확인을 위한 main메소드도 적절히 정의해보자.

Car 클래스는 가솔린으로 동작하는 자동차를 표현한 것이고,
HybridCar 클래스는 가솔린과 전기로 동작하는 자동차를 표현한것이다. 
그리고 마지막으로 HybridWaterCar 클래스는 가솔린과 전기뿐만아니라..
물도 동시에 연료로 사용할 수 있는, 가상의 자동차를 표현 했습니다. 
그러나 이문제는 위의 클래스들이 의미하는 바를 몰라도 해결이 가능합니다. 
```

## Car클래스 (최상위 부모클래스) 
```java
class Car {

	int gasolineGauge; 
	public Car(int gasolineGauge){
		this.gasolineGauge=gasolineGauge;
	}
}
```

## HybridCar클래스 (Car의 자식클래스 이자 HybridWaterCar의 부모클래스)
```java
class HybridCar extends Car {

	int electricGauge;
public HybridCar(int gasolineGauge,int electricGauge){
		super(gasolineGauge);
		this.electricGauge= electricGauge;
	}
}
```

### HybridWaterCar클래스 (HybridCar클래스의 자식클래스)
```java
class HybridWaterCar extends HybridCar {
	int waterGauge; 
	public HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge) {
		super(gasolineGauge,electricGauge);
		this.waterGauge=waterGauge;
	}
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린량 : " + gasolineGauge);
		System.out.println("잔여 전기량 : " + electricGauge);
		System.out.println("잔여 워터량 : " + waterGauge);

	}

}
```

### main메소드
```java
public class Test92 {
	public static void main(String[] args) {
		HybridWaterCar hybridWaterCar1 = new HybridWaterCar(4, 2, 3);
		System.out.println("하이브리드 워터카1");
				hybridWaterCar1.showCurrentGauge();
		
		System.out.println("----------------");
		System.out.println("하이브리드 워터카2");
		HybridWaterCar hybridWaterCar2 = new HybridWaterCar(9, 5, 7);
		hybridWaterCar2.showCurrentGauge();

	}
}
```

##전체 코드
```java
 class Car {

	int gasolineGauge; 
	public Car(int gasolineGauge){
		this.gasolineGauge=gasolineGauge;
	}
}


class HybridCar extends Car {

	int electricGauge;
public HybridCar(int gasolineGauge,int electricGauge){
		super(gasolineGauge);
		this.electricGauge= electricGauge;
	}
}


class HybridWaterCar extends HybridCar {
	int waterGauge; 
	public HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge) {
		super(gasolineGauge,electricGauge);
		this.waterGauge=waterGauge;
	}
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린량 : " + gasolineGauge);
		System.out.println("잔여 전기량 : " + electricGauge);
		System.out.println("잔여 워터량 : " + waterGauge);

	}

}

public class Test92 {
	public static void main(String[] args) {
		HybridWaterCar hybridWaterCar1 = new HybridWaterCar(4, 2, 3);
		System.out.println("하이브리드 워터카1");
				hybridWaterCar1.showCurrentGauge();
		
		System.out.println("----------------");
		System.out.println("하이브리드 워터카2");
		HybridWaterCar hybridWaterCar2 = new HybridWaterCar(9, 5, 7);
		hybridWaterCar2.showCurrentGauge();

	}
}

```

# Test93.java

### 다형성
```
	여러가지 형태를 가질 수 있는 능력

	객체 지향 개념 자바에서의 다형성
	 - 하나의 클래스 타입의 참조변수로 여러클래스타입으로 생성한 객체들을 참조할 수 있도록 하는 것

	구체적인 자바의 다형성 
	 - 부모클래스 타입의 참조변수로 자식클래스를 이용해 생성한 객체메모리를 참조할 수 있도록 하는 것

```

### (예시) TV클래스

```java
class TV{
	boolean power; // 전원상태 on / off를 저장할 변수
	int channel; // 채널값을 저장할 변수

// TV의 전원을 on 또는 off 시키는 기능의 메소드

	void power(){
		power= !power;
	}
// 채널을 1 증가 시키는 기능의 메소드
	void channelUp(){
		++channel;
	}
// 채널을 1 감소 시키는 기능의 메소드
	void chanelDown(){
		--channel;
	}
}
```

### TV기능 + 캡션 기능

```java
class CaptionTV extends TV{
	//캡션을 보여주기 위한 문자열이 저장될 변수
	String text;

	void Caption(){
		System.out.println("캡션기능이 추가된 TV");
	}
}
```

### 메인메소드
```java
public class Test93 {

	public static void main(String[] args) {
		TV tv = new TV();
		CaptionTV c = new CaptionTV();
		TV t1= new CaptionTV();
		// t1 = new CaptionTV();
		// t1 = new CaptionTV();
	}

}
```
```
TV클래스와 CaptionTV 클래스가 상속관계에 있을 경우
부모클래스 타입의 참조변수에 저장된 객체의 주소를 이용하여
자식객체 메모리의 멤버를 참조하도록 하는 것도 가능

부모클래스 타입의 참조변수에 자식객체를 생성해서 그 주소를 저장
TV t1 = new CaptionTV(); // 자식객체1
//t1 = new CaptionTV(); // 자식객체2
//t1 = new CaptionTV(); // 자식객체3

★자바에서 다형성의 특징 중에 하나인 업캐스팅이라는 개념이 있음★
```

### 객체를 생성하여 같은 클래스 타입의 참조변수에 객체메모리의 주소값을 저장하는 것과 

### 객체를 생성하여 부모 클래스 타입의 참조변수에 객체메모리의 주소값을 저장하는 것의 차이 


##### 1. 객체를 생성하여 같은 클래스 타입의 참조변수에 객체 메모리의 주소값 저장

```java
CaptionTV c1 = new CationTV();

// 모든 변수나 메소드에 참조 가능 (상속받은 모든 것 사용가능)

c1.power=true;
c1.channel=0;
c1.power();
c1.channelUp();
c1.chanelDown();
c1.text="캡션TV";
c1.Caption();
```

##### 2. 객체를 생성하여 부모클래스 타입의 참조변수에 객체 메모리의 주소값 저장

```java
TV tv2 = new CaptionTV();

// 부모클래스의 변수로 참조할 수 있는 범위가 줄어듦 [부모 클래스의 변수와 메소드만 참조할 수 있음]

tv2.power=true;
tv2.channel=0;
tv2.power();
tv2.channelUp();
tv2.chanelDown();
// tv2.text="캡션TV"; // 참조 불가능
// tv2.Caption();    // 참조 불가능
```

### 결과
```
실제 생성한 객체 메모리가 new CaptionTV() 객체일지라도 
참조변수 tv2로는 new CaptionTV()객체메모리에 저장된 모든 멤버를 사용할 수 없다

이유는 TV클래스 타입의 참조변수로는 CaptionTV객체 메모리의 멤버들 중에서
TV클래스 내부에 만들어 놓은 멤버들만 사용할 수 있기 때문이다.
```

### 자식클래스 타입의 참조변수에 부모클래스의 객체를 생성해서 저장 (불가능)

```java
CaptionTV c2 = new TV();
```

### 이유 (컴파일 에러)
```
실제 TV객체 멤버의 개수보다 CaptionTV클래스타입의 참조변수 c2가 사용할 수 있는 멤버의 갯수가 더 많기 때문

요약: CaptionTV 클래스 타입의 c2 참조변수가 참조하고있는 객체는 TV객체이고
	  TV객체는 text 변수와 caption()메소드가 존재하지 않기 때문
```

## 결론
```
자식클래스 타입의 참조변수로 부모객체를 참조하는 것은?

 - 존재하지 않는 멤버를 사용하고자 할 가능성이 있으므로 허용하지 않음

 - 참조변수가 사용할 수 있는 멤버의 갯수는 객체메모리의 멤버 갯수보다 같거나 작아야함
```