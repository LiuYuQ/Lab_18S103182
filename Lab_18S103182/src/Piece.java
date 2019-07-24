
public class Piece implements Cloneable{
	public String name = "  ";
	public String color;
	public int belongto = -1;
	public Player player;
	public Piece(String inputname, Player playerid, int i){
		name = inputname;
		player = playerid;
		if(i == 1)
			color = "white";
		if(i == 2) 
			color = "black";
		belongto = i;
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
