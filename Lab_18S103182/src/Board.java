
public class Board{
	public int size = 0;
	public Position game_board[][];
	public Board(int inputsize){
		size = inputsize;
		game_board = new Position[size][size];
	}
	
	public void initboard_chess(Player player1, Player player2){

		Piece rock00 = new Piece(" 车 ", player2, 2);
		game_board[0][0] = new Position(rock00, 0, 0);
		Piece knight01 = new Piece(" 马 ", player2, 2);
		game_board[0][1] = new Position(knight01, 0, 1);
		Piece bishop02 = new Piece(" 相 ",player2, 2);
		game_board[0][2] = new Position(bishop02, 0, 2);
		Piece queen37 = new Piece(" 后 ", player2,2);
		game_board[0][3] = new Position(queen37, 0, 3);
		Piece king47 = new Piece(" 王 ", player2,2);
		game_board[0][4] = new Position(king47, 0, 4);
		Piece bishop27 = new Piece(" 相 ",player2, 2);
		game_board[0][5] = new Position(bishop27, 0, 5);
		Piece knight17 = new Piece(" 马 ", player2, 2);
		game_board[0][6] = new Position(knight17, 0, 6);
		Piece rock07 = new Piece(" 车 ", player2, 2);
		game_board[0][7] = new Position(rock07, 0, 7);

		Piece rock70 = new Piece(" 车 ", player1,1);
		game_board[7][0] = new Position(rock70, 7, 0);
		Piece knight71 = new Piece(" 马 ", player1,1);
		game_board[7][1] = new Position(knight71, 7, 1);
		Piece bishop72 = new Piece(" 相 ", player1,1);
		game_board[7][2] = new Position(bishop72, 7, 2);
		Piece queen30 = new Piece(" 后 ", player1,1);
		game_board[7][3] = new Position(queen30, 7, 3);
		Piece king40 = new Piece(" 王 ", player1,1);
		game_board[7][4] = new Position(king40, 7, 4);
		Piece bishop20 = new Piece(" 相 ", player1,1);
		game_board[7][5] = new Position(bishop20, 7, 5);
		Piece knight10 = new Piece(" 马 ", player1,1);
		game_board[7][6] = new Position(knight10, 7, 6);
		Piece rock77 = new Piece(" 车 ", player1,1);
		game_board[7][7] = new Position(rock77, 7, 7);
		
		for(int i = 0; i < 8; i++){
			Piece pawnw = new Piece(" 兵 ", player1, 1);
			Piece pawnb = new Piece(" 兵 ", player2, 2);
			game_board[1][i] = new Position(pawnb, 1, i);
			game_board[2][i] = new Position(2, i);
			game_board[3][i] = new Position(3, i);
			game_board[4][i] = new Position(4, i);
			game_board[5][i] = new Position(5, i);
			game_board[6][i] = new Position(pawnw, 6, i);
		}		
}
				
	public void initboard_go(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				game_board[i][j] = new Position(i, j);
			}
		}
	}
}
