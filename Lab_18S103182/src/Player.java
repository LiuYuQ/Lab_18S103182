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
		System.out.println("\n��ѡ����Ҫ���еĲ�����\n1.����\n2.����\n3.����\n4.����\n5.��ѯ\n6.����˫����������\n7.����\n8.end");
		int action_id;
		Scanner scan = new Scanner(System.in);
		action_id = scan.nextInt();
		int x, y, x1, y1, x2, y2, flag =0;
		Position p, srcp, destp;
		switch(action_id){
			case 1:
				if(game.name=="chess"){
					System.out.println("\nError:�ò����������ڹ������壡");
					break;
				}
				System.out.println("\n����������λ������:");
				x = scan.nextInt();
				y = scan.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				destp = game.board.position[x][y];
				flag = action.put(destp,this);
				if(flag == 1) total++;
				break;
			case 2:
				if(game.name=="go"){
					System.out.println("\nError:�ò�����������Χ�壡");
					break;
				}
				System.out.println("\n���������ӵĳ�ʼ�����Ŀ������:");
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				srcp = game.board.position[x1][y1];
				destp = game.board.position[x2][y2];
				flag = action.move(srcp, destp, this);
				break;
			case 3:
				if(game.name=="chess"){
					System.out.println("\nError:�ò����������ڹ������壡");
					break;
				}
				System.out.println("\n��������������:");
				x = scan.nextInt();
				y = scan.nextInt();
				if(x<0 || x>15 || y<0 || y>15){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				p = game.board.position[x][y];
				flag = action.take(p, this);	
				break;
			case 4:
				if(game.name=="go"){
					System.out.println("\nError:�ò�����������Χ�壡");
					break;
				}
				System.out.println("\n��������ӵĳ�ʼ�����Ŀ������:");
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				if(x1<0 || x1>7 || y1<0 || y1>7 || x2<0 || x2>7 || y2<0 || y2>7){
					System.out.printf("\nError:���곬�����̷�Χ��");
					break;
				}
				srcp = game.board.position[x1][y1];
				destp = game.board.position[x2][y2];
				flag = action.eat(srcp, destp, this);
				break;
			case 5:
				System.out.println("\n������Ҫ��ѯλ�õ�����:");
				x = scan.nextInt();
				y = scan.nextInt();
				if(game.name=="chess"){
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
				destp = game.board.position[x][y];
				flag = action.search(destp);
				if(flag == 0) System.out.printf("λ��(%d, %d)û������\n", x, y);
				else{
					System.out.printf("λ��(%d, %d)��������("+destp.p.color+")%s\n", x, y, destp.p.name);
				}
				break;
			case 6:
				System.out.println("\n"+game.player1.name+"����������"+game.player1.total);
				System.out.println(game.player2.name+"����������"+game.player2.total);
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
