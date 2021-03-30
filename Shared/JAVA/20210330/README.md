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