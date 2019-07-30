import java.util.Scanner;

public class MyChessAndGoGame{

	public static void main(String []args){

//		System.out.println("Hello \u001b[1;37m red \u001b[0m world!");
		Game game = null;
		Scanner scan = new Scanner(System.in);
		int choose_flag = 0;
		while(choose_flag == 0){
			System.out.println("Choose chess or go?");
			String choose = scan.next();
			if(choose.equals("chess")){
				choose_flag = 1;
				game = new Chess("chess");
			}
			else if (choose.equals("go")){
				choose_flag = 1;
				game = new Go("go");
			}
		}		
		game.print();
		System.out.println("\nPlease input the names of player1 and player2:");		
		String player1 = scan.next();
		String player2 = scan.next();
		game.scan_name(player1, player2);
		int end_flag = 0;
		while(end_flag == 0){
			int keep_flag = 1;
			System.out.printf("\n--------------------------------\nPlayer1(white):%10s\n--------------------------------\n", game.player1.name);
			while(keep_flag ==1){
				keep_flag = game.player1.action(game);
			}
			game.print();
			keep_flag = 1;
			System.out.printf("--------------------------------\nPlayer2(black):%10s\n--------------------------------\n", game.player2.name);
			while(keep_flag == 1){
				keep_flag = game.player2.action(game);
			}
			game.print();
		}
		scan.close();
	}
}
