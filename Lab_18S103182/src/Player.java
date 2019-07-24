import java.util.Scanner;

public class Player{
	public String name;
	public int total = 0;
	public int id;
	public String history = "";
	public Player(String inputname, int inputsize, int inputid){
		name = inputname;
		if(inputsize == 8) total = 16;
		if(inputsize == 18) total = 0;
		id = inputid;
	}
	public int action(Game G){
		int actionid;
		Action todo = new Action(id);
		System.out.println("\n请选择你要进行的操作：\n1.落子\n2.移子\n3.提子\n4.吃子\n5.查询\n6.计算双方棋子总数\n7.跳过\n8.end");
		Scanner sc = new Scanner(System.in);
		actionid = sc.nextInt();
		int x, y, x1, y1, x2, y2, flag =0;
		Position srcp, destp, p;
		switch(actionid){
			case 1:
				if(G.name=="chess"){
					System.out.println("\nError:该操作不适用于国际象棋！");
					break;
				}
				System.out.println("\n请输入落子位置坐标:");
				x = sc.nextInt();
				y = sc.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				destp = G.board.game_board[x][y];
				flag = todo.put(destp,this);
				if(flag == 1) total++;
				break;
			case 2:
				if(G.name=="go"){
					System.out.println("\nError:该操作不适用于围棋！");
					break;
				}
				System.out.println("\n请输入移子的初始坐标和目的坐标:");
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				srcp = G.board.game_board[x1][y1];
				destp = G.board.game_board[x2][y2];
				flag = todo.move(srcp, destp, this);
				break;
			case 3:
				if(G.name=="chess"){
					System.out.println("\nError:该操作不适用于国际象棋！");
					break;
				}
				System.out.println("\n请输入提子坐标:");
				x = sc.nextInt();
				y = sc.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				p = G.board.game_board[x][y];
				flag = todo.take(p, this);	
				break;
			case 4:
				if(G.name=="go"){
					System.out.println("\nError:该操作不适用于围棋！");
					break;
				}
				System.out.println("\n请输入吃子的初始坐标和目的坐标:");
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				srcp = G.board.game_board[x1][y1];
				destp = G.board.game_board[x2][y2];
				flag = todo.eat(srcp, destp, this);
				break;
			case 5:
				System.out.println("\n请输入要查询位置的坐标:");
				x = sc.nextInt();
				y = sc.nextInt();
				if(G.name=="chess"){
					if(x<0 || x>7 || y<0 || y>7){
						System.out.printf("\nError:坐标超出棋盘范围！");
						break;
					}
				}
				else{
					if(x<0 || x>15 || y<0 || y>15){
						System.out.printf("\nError:坐标超出棋盘范围！");
						break;
					}
				}
				destp = G.board.game_board[x][y];
				flag = todo.select(destp);
				if(flag == 0) System.out.printf("位置(%d, %d)没有棋子\n", x, y);
				else{
					System.out.printf("位置(%d, %d)的棋子是("+destp.p.color+")%s\n", x, y, destp.p.name);
				}
				break;
			case 6:
				System.out.println("\n"+G.player1.name+"棋子总数："+G.player1.total);
				System.out.println(G.player2.name+"棋子总数："+G.player2.total);
				break;
			case 7:
				return 0;
			case 8:
				System.out.println("\n--------------------------------\nHistory\n--------------------------------\n\nPlayer1:" + G.player1.name + "\n" +  G.player1.history);	
				System.out.println("Player2:" + G.player2.name + "\n"+ G.player2.history);				
				System.exit(0);
				break;
		}
		if(flag == 1 && (actionid == 1 || actionid == 2 || actionid == 3 || actionid == 4))
			return 0;
		else return 1;
	}
}
