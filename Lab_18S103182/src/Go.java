
public class Go extends Game{
	
	public Go(String input_name){
		super(input_name);
		size = 18;
		board = new Board(size);
		player1 = new Player(" ", size, 1);
		player2 = new Player(" ", size, 2);	
		board.create_go();
	}
	

}
