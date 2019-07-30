
public class Board{
	public int size = 0;
	public Position position[][];
	public Board(int input_size){
		size = input_size;
		position = new Position[size][size];
	}
	
	public void create_chess(Player player1, Player player2){
		Piece rook00 = new Piece(" 车 ", player2, 2);
		position[0][0] = new Position(rook00, 0, 0);
		Piece knight01 = new Piece(" 马 ", player2, 2);
		position[0][1] = new Position(knight01, 0, 1);
		Piece bishop02 = new Piece(" 相 ", player2, 2);
		position[0][2] = new Position(bishop02, 0, 2);
		Piece queen03 = new Piece(" 后 ", player2,2);
		position[0][3] = new Position(queen03, 0, 3);
		Piece king04 = new Piece(" 王 ", player2,2);
		position[0][4] = new Position(king04, 0, 4);
		Piece bishop05 = new Piece(" 相 ", player2, 2);
		position[0][5] = new Position(bishop05, 0, 5);
		Piece knight06 = new Piece(" 马 ", player2, 2);
		position[0][6] = new Position(knight06, 0, 6);
		Piece rook07 = new Piece(" 车 ", player2, 2);
		position[0][7] = new Position(rook07, 0, 7);

		Piece rook70 = new Piece(" 车 ", player1, 1);
		position[7][0] = new Position(rook70, 7, 0);
		Piece knight71 = new Piece(" 马 ", player1, 1);
		position[7][1] = new Position(knight71, 7, 1);
		Piece bishop72 = new Piece(" 相 ", player1, 1);
		position[7][2] = new Position(bishop72, 7, 2);
		Piece queen73 = new Piece(" 后 ", player1, 1);
		position[7][3] = new Position(queen73, 7, 3);
		Piece king74 = new Piece(" 王 ", player1, 1);
		position[7][4] = new Position(king74, 7, 4);
		Piece bishop75 = new Piece(" 相 ", player1, 1);
		position[7][5] = new Position(bishop75, 7, 5);
		Piece knight76 = new Piece(" 马 ", player1, 1);
		position[7][6] = new Position(knight76, 7, 6);
		Piece rook77 = new Piece(" 车 ", player1, 1);
		position[7][7] = new Position(rook77, 7, 7);
		
		for(int i = 0; i < 8; i++){
			Piece pawn1 = new Piece(" 兵 ", player1, 1);
			Piece pawn2 = new Piece(" 兵 ", player2, 2);
			position[1][i] = new Position(pawn2, 1, i);
			position[2][i] = new Position(2, i);
			position[3][i] = new Position(3, i);
			position[4][i] = new Position(4, i);
			position[5][i] = new Position(5, i);
			position[6][i] = new Position(pawn1, 6, i);
		}		
}
				
	public void create_go(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				position[i][j] = new Position(i, j);
			}
		}
	}
}
