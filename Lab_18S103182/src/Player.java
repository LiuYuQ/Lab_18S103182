import java.util.Scanner;

public class Player{
	public String name;
	public int id, total = 0;
	public String history = "";
	
	public Player(String input_name, int size, int input_id){
		name = input_name;
		if(size == 8) total = 16;
		if(size == 18) total = 0;
		id = input_id;
	}
	public int action(Game game){
		Action action = new Action(id);
		System.out.println("\n请选择你要进行的操作：\n1.落子\n2.移子\n3.提子\n4.吃子\n5.查询\n6.计算双方棋子总数\n7.跳过\n8.end");
		int action_id;
		Scanner scan = new Scanner(System.in);
		action_id = scan.nextInt();
		int x, y, x1, y1, x2, y2, flag =0;
		Position p, srcp, destp;
		switch(action_id){
			case 1:
				if(game.name=="chess"){
					System.out.println("\nError:该操作不适用于国际象棋！");
					break;
				}
				System.out.println("\n请输入落子位置坐标:");
				x = scan.nextInt();
				y = scan.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				destp = game.board.position[x][y];
				flag = action.put(destp,this);
				if(flag == 1) total++;
				break;
			case 2:
				if(game.name=="go"){
					System.out.println("\nError:该操作不适用于围棋！");
					break;
				}
				System.out.println("\n请输入移子的初始坐标和目的坐标:");
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				srcp = game.board.position[x1][y1];
				destp = game.board.position[x2][y2];
				flag = action.move(srcp, destp, this);
				break;
			case 3:
				if(game.name=="chess"){
					System.out.println("\nError:该操作不适用于国际象棋！");
					break;
				}
				System.out.println("\n请输入提子坐标:");
				x = scan.nextInt();
				y = scan.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				p = game.board.position[x][y];
				flag = action.take(p, this);	
				break;
			case 4:
				if(game.name=="go"){
					System.out.println("\nError:该操作不适用于围棋！");
					break;
				}
				System.out.println("\n请输入吃子的初始坐标和目的坐标:");
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:坐标超出棋盘范围！");
					break;
				}
				srcp = game.board.position[x1][y1];
				destp = game.board.position[x2][y2];
				flag = action.eat(srcp, destp, this);
				break;
			case 5:
				System.out.println("\n请输入要查询位置的坐标:");
				x = scan.nextInt();
				y = scan.nextInt();
				if(game.name=="chess"){
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
				destp = game.board.position[x][y];
				flag = action.search(destp);
				if(flag == 0) System.out.printf("位置(%d, %d)没有棋子\n", x, y);
				else{
					System.out.printf("位置(%d, %d)的棋子是("+destp.p.color+")%s\n", x, y, destp.p.name);
				}
				break;
			case 6:
				System.out.println("\n"+game.player1.name+"棋子总数："+game.player1.total);
				System.out.println(game.player2.name+"棋子总数："+game.player2.total);
				break;
			case 7:
				
				return 0;
			case 8:
				System.out.println("\n--------------------------------\nHistory\n--------------------------------\n\nPlayer1:" + game.player1.name + "\n" +  game.player1.history);	
				System.out.println("Player2:" + game.player2.name + "\n"+ game.player2.history);				
				System.exit(0);
				break;
		}
		
		if(flag == 1 && (action_id == 1 || action_id == 2 || action_id == 3 || action_id == 4))
			return 0;
		else 
			return 1;
	}
	
}
