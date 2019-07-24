
public class Game{
	public String name;
	public int size = 0;
	public Board board;
	public Player player1, player2;
	public Game(String inputname){
		name = inputname;
	}

	public void setplayer(String player1id, String player2id){
		player1.name = player1id;
		player2.name = player2id;
	}

	public void print()
	{
		System.out.printf("|");		
		for(int k = 0; k < size; k++){
			System.out.printf("%4s", "！！！|");
		}		
		System.out.println();
		for(int i = 0; i < size; i++){
			System.out.printf("|");
			for(int j = 0; j < size; j++){
				if(board.game_board[i][j].name.equals("  "))
					System.out.printf("%4s", board.game_board[i][j].name + "|");
				else if(board.game_board[i][j].color=="white") 
					System.out.printf("\u001b[1;37m%s\u001b[0m%s", board.game_board[i][j].name, "|");
				
				else
					System.out.printf("%4s", board.game_board[i][j].name + "|");
			}
			System.out.println();
			if(i != size-1) System.out.printf("|");
			for(int k = 0; i != size-1 && k < size; k++){
				System.out.printf("！！！|");
			}
			if(i != size-1) System.out.printf("\n");
		}
		System.out.printf("|");
		for(int k = 0; k < size; k++){
			System.out.printf("！！！|");
		}		
		System.out.println();
	}

}

