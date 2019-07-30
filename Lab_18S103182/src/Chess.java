
public class Chess extends Game{
	
	public Chess(String input_name){
		super(input_name);
		size = 8;
		board = new Board(size);
		player1 = new Player(" ", size, 1);
		player2 = new Player(" ", size, 2);
		board.create_chess(player1, player2);	
	}
}	

