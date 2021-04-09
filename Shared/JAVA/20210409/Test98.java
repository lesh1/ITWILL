class DObject{
	DObject next;
	DObject(){
		next=null;
	}
	public void draw(){
		System.out.println("Dobject draw");
	}
}

class Line extends DObject{
	@Override
	public void draw(){
		System.out.println("Line");
	}
}

class Circle extends DObject{
	@Override
	public void draw(){
		System.out.println("Circle");
	}
}

public class Test98{
	public static void main(String[] args) {
		Line a= new Line();
		a.draw();

		DObject p = new Line();
		p.draw();	
	}
}