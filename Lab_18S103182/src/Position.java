
public class Position{
	public String name, color;
	public int x, y, flag;
	public Piece p = null;
	public Position(int position_x, int position_y){
		name = "  ";
		color = "  ";
		x = position_x;
		y = position_y;
		flag = 0;	
	}

	public Position(Piece input_p, int position_x, int position_y){
		p = (Piece)input_p.clone();
		name = input_p.name;
		color = input_p.color;
		x = position_x;
		y = position_y;
		flag = 1;
	}
	
	public void put(Piece input_p){
		p = (Piece)input_p.clone();
		name = input_p.name;
		color = input_p.color;
		flag = 1;
	}
	
	public void remove(){
		name = "  ";
		color = "  ";
		p = null;
		flag = 0;	
	}

}
