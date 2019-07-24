
public class Position{
	public String name;
	public String color;
	public int x, y;
	public Piece p = null;
	public int flag;
	public Position(int _x, int _y){
		name = "  ";
		color = "  ";
		x = _x;
		y = _y;
		flag = 0;	
	}

	public Position(Piece inputp, int _x, int _y){
		p = (Piece)inputp.clone();
		name = inputp.name;
		color = inputp.color;
		x = _x;
		y = _y;
		flag = 1;
	}

	public void remove(){
		name = "  ";
		color = "  ";
		p = null;
		flag = 0;	
	}
	
	public void put(Piece inputp){
		p = (Piece)inputp.clone();
		name = inputp.name;
		color = inputp.color;
		flag = 1;
	}


}
