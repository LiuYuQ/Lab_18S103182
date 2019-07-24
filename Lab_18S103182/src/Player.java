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
		System.out.println("\n��ѡ����Ҫ���еĲ�����\n1.����\n2.����\n3.����\n4.����\n5.��ѯ\n6.����˫����������\n7.����\n8.end");
		Scanner sc = new Scanner(System.in);
		actionid = sc.nextInt();
		int x, y, x1, y1, x2, y2, flag =0;
		Position srcp, destp, p;
		switch(actionid){
			case 1:
				if(G.name=="chess"){
					System.out.println("\nError:�ò����������ڹ������壡");
					break;
				}
				System.out.println("\n����������λ������:");
				x = sc.nextInt();
				y = sc.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				destp = G.board.game_board[x][y];
				flag = todo.put(destp,this);
				if(flag == 1) total++;
				break;
			case 2:
				if(G.name=="go"){
					System.out.println("\nError:�ò�����������Χ�壡");
					break;
				}
				System.out.println("\n���������ӵĳ�ʼ�����Ŀ������:");
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				srcp = G.board.game_board[x1][y1];
				destp = G.board.game_board[x2][y2];
				flag = todo.move(srcp, destp, this);
				break;
			case 3:
				if(G.name=="chess"){
					System.out.println("\nError:�ò����������ڹ������壡");
					break;
				}
				System.out.println("\n��������������:");
				x = sc.nextInt();
				y = sc.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				p = G.board.game_board[x][y];
				flag = todo.take(p, this);	
				break;
			case 4:
				if(G.name=="go"){
					System.out.println("\nError:�ò�����������Χ�壡");
					break;
				}
				System.out.println("\n��������ӵĳ�ʼ�����Ŀ������:");
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				srcp = G.board.game_board[x1][y1];
				destp = G.board.game_board[x2][y2];
				flag = todo.eat(srcp, destp, this);
				break;
			case 5:
				System.out.println("\n������Ҫ��ѯλ�õ�����:");
				x = sc.nextInt();
				y = sc.nextInt();
				if(G.name=="chess"){
					if(x<0 || x>7 || y<0 || y>7){
						System.out.printf("\nError:���곬�����̷�Χ��");
						break;
					}
				}
				else{
					if(x<0 || x>15 || y<0 || y>15){
						System.out.printf("\nError:���곬�����̷�Χ��");
						break;
					}
				}
				destp = G.board.game_board[x][y];
				flag = todo.select(destp);
				if(flag == 0) System.out.printf("λ��(%d, %d)û������\n", x, y);
				else{
					System.out.printf("λ��(%d, %d)��������("+destp.p.color+")%s\n", x, y, destp.p.name);
				}
				break;
			case 6:
				System.out.println("\n"+G.player1.name+"����������"+G.player1.total);
				System.out.println(G.player2.name+"����������"+G.player2.total);
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
