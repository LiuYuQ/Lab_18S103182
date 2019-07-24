import java.util.Scanner;

public class MyChessAndGoGame{

	public static void main(String []args)
	{

//		System.out.println("Hello \u001b[1;37m red \u001b[0m world!");
		Game G=null;
		Scanner sc = new Scanner(System.in);
		int inputtypeover = 0;
		while(inputtypeover == 0){
			System.out.println("Choose chess or go?");
			String type = sc.next();
			if(type.equals("chess")){
				inputtypeover = 1;
				G = new Chess("chess");
			}
			else if (type.equals("go")){
				inputtypeover = 1;
				G = new Go("go");
			}
		}		
		G.print();
		System.out.println("\nPlease input the names of player1 and player2:");		
		String player1name = sc.next();
		String player2name = sc.next();
		G.setplayer(player1name, player2name);
		int flag_end = 0;
		while(flag_end == 0){
			int flag_keep_turn = 1;
			System.out.printf("\n--------------------------------\nPlayer1(white):%10s\n--------------------------------\n", G.player1.name);
			while(flag_keep_turn ==1){
				flag_keep_turn = G.player1.action(G);
			}
			G.print();
			flag_keep_turn = 1;
			System.out.printf("--------------------------------\nPlayer2(black):%10s\n--------------------------------\n", G.player2.name);
			while(flag_keep_turn == 1){
				flag_keep_turn = G.player2.action(G);
			}
			G.print();
		}
	}
}
