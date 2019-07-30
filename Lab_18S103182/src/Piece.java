
public class Piece implements Cloneable{
	public String name = "  ";
	public String color;
	public int belongto = -1;
	public Player player;
	public Piece(String input_name, Player player_id, int side){
		name = input_name;
		player = player_id;
		if(side == 1)
			color = "white";
		if(side == 2) 
			color = "black";
		belongto = side;
	}
	
	public Object clone(){
		Piece p = null;
		try{
			p = (Piece)super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return p;
	}

}
