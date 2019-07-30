
public class Game{
	public String name;
	public int size = 0;
	public Board board;
	public Player player1, player2;
	public Game(String input_name){
		name = input_name;
	}

	public void scan_name(String player1name, String player2name){
		player1.name = player1name;
		player2.name = player2name;
	}

	public void print()
	{	
		for(int k = 0; k < size; k++){
			System.out.printf("！！！！");
		}		
		System.out.println();
		for(int i = 0; i < size; i++){
			System.out.printf("|");
			for(int j = 0; j < size; j++){
				if(board.position[i][j].name.equals("  "))
					System.out.printf("%3s%s", board.position[i][j].name , "|");
				else if(board.position[i][j].color=="white") 
					System.out.printf("\u001b[1;37m%-4s\u001b[0m%s", board.position[i][j].name, "|");
				
				else
					System.out.printf("%-4s%s", board.position[i][j].name , "|");
			}
			System.out.println();
			for(int k = 0; i != size-1 && k < size; k++){
				System.out.printf("！！！！");
			}
			if(i != size-1) 
				System.out.printf("\n");
		}
		for(int k = 0; k < size; k++){
			System.out.printf("！！！！");
		}		
		System.out.println();
	}

}

