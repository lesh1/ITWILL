/*
노래를 나타내는 Song이라는 클래스를 설계하라. 

Song 클래스는 다음과 같은 멤버변수(인스턴스변수) 를갖는다
모두 데이터은닉변수로 만들기 private
-노래의 제목을 나타내는 title
-가수를 나타내는 artist
-노래가 속한 앨범 제목을 나타내는 album
-노래의 작곡가를 나타내는 composer,작곡가는 여려명 있을수있다.<-배열참조변수
-노래가 발표된 연도를 나타내는 year
-노래가 속한 앨범에서의 트랙번호를 나타내는 track

생성자는 기본생성자와 모든필드를 초기화하는 생성자를 작성하고,
노래의 정보를 화면에 출력하는 show()메소드도 작성하라.

-출력결과-
노래 제목:Dansing Queen
가수:ABBA
앨범:Arrival
작곡가:Benny Andersson,Bjorn Ulvaeus
년도:1977
트랙 번호:2

ABBA의 "Dancint Queen" 노래를 Song객체로 생성하고
show()를 이용하여 이노래의 정보를 출력하는 프로그램을 작성하라.

클래스2개(Song.java , SongManger.java)

*/
public class Song {
	//노래의 제목을 저장하는 title변수 선언
	private String title;
	//가수이름을 저장할 artist변수 선언
	private String artist;
	//노래가 속한 앨범 제목을 저장할 album변수 선언
	private  String album;
	//노래의 작곡가들을 저장시킬 composer변수 선언, 작곡가는 여러명 있을수 있다.
	private String[] composer;
	//노래가 발표된 연도를 저장할 year변수 선언
	private int year;
	//노래가 속한 앨범에서의 트랙번호를 저장할 track변수 선언
	private int track;
	
	//기본생성자
	public Song() {
		title = null;
		artist = null;
		album = null;
		composer = null;
		year = 0;
		track = 0;
	}
	//모든필드를 초기화하는 생성자를 작성
	//alt + shift + s   o

	public Song(String title,
				String artist,
				String album,
				String[] composer,
				int year,
				int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
	}
	
	//노래의 정보를 화면에 출력하는 기능의 show()메소드 정의
	public void show() {
//		-출력결과-
//		노래 제목:Dansing Queen
//		가수:ABBA
//		앨범:Arrival
//		작곡가:Benny Andersson,Bjorn Ulvaeus
//		년도:1977
//		트랙 번호:2
		System.out.println("노래 제목:" + title);
		System.out.println("가수:" + artist);
		System.out.println("앨범:" + album);
		//String배열에 저장된 작곡가명 갯수 만큼 반복
		for(int i=0;  i<composer.length; i++) {
			System.out.print(composer[i]);
			//작곡가 명이 없으면 끝내고 다음줄로...
			if(i+1 == composer.length) {//->String[]배열에 2명의 작곡가명이 저장되어 있으므로
										//   0, 1 인덱스 까지
				System.out.println();
			}else {
				System.out.print(",");
			}
		}//for
		System.out.println("년도:" + year);
		System.out.println("트랙번호:" + track);
	}//show메소드
}//Song클래스 







