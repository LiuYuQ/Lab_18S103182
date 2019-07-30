
public class Action{
	public int playerid;
	public Position src, dest;
	public Action(int id){
		playerid = id;
	}
	
	//��ѯ
	public int search(Position p){
		if(p.flag == 1) 
			return 1;
		else 
			return 0;
	}
	
	//����
	public int put(Position p, Player player){
		if(p.x<0 || p.x>15 || p.y<0 || p.y>15){
			System.out.printf("Put fail:���곬�����̷�Χ��");
			return 0;
		}
		if(search(p) == 0){
			if(playerid == 1){
				Piece new_piece = new Piece(" �� ", player, 1);
				p.put(new_piece);
				player.history += "Put \u001b[1;37m" + new_piece.name + "\u001b[0m on (" + p.x + ", " + p.y + ")\n";
				System.out.println("Put succeed!");
				return 1;
			}
			else{
				Piece new_piece = new Piece(" �� ", player, 2);
				p.put(new_piece);
				System.out.println("Put succeed!");
				player.history += "Put "+ new_piece.name + " on ("+p.x+", " + p.y +")\n";
				return 1;
			}
		}
		else if(p.p.color=="black")
			System.out.printf("Put fail:λ��(%d, %d)��������"+"%s\n", p.x, p.y, p.p.name);
		else
			System.out.printf("Put fail:λ��(%d, %d)��������\u001b[1;37m"+"%s\u001b[0m\n", p.x, p.y, p.p.name);
		return 0;
	}
	
	//����
	public int move(Position src, Position dest, Player player){
		if(src.x<0 || src.x>7 || src.y<0 || src.y>7 || dest.x<0 || dest.x>7 || dest.y<0 || dest.y>7){
			System.out.printf("Put fail:���곬�����̷�Χ��");
			return 0;
		}
		if(search(src) == 1){
			if(src.p.belongto != playerid){
				System.out.println("Move fail:�����������\n");
				return 0;
			}
			else if(search(dest) == 1){
				if(dest.p.color=="black")
					System.out.printf("Move fail:λ��(%d, %d)�ѱ�" + "%sռ��\n", dest.x, dest.y, dest.p.name);
				else
					System.out.printf("Move fail:λ��(%d, %d)�ѱ�\u001b[1;37m" + "%s\u001b[0mռ��\n", dest.x, dest.y, dest.p.name);
				return 0;
			}
			else{
				if(src.p.color=="black")
					player.history += "Move " + src.p.name + " from ("+src.x+", " + src.y +") to ("+dest.x + ", "+dest.y+")\n";
				else
					player.history += "Move \u001b[1;37m" + src.p.name + "\u001b[0m from ("+src.x+", " + src.y +") to ("+dest.x + ", "+dest.y+")\n";
				dest.put(src.p);
				src.remove();
				System.out.println("Move succeed!");
				return 1;
			}
		}
		System.out.printf("Move fail:λ��(%d, %d)û������\n", src.x, src.y);
		return 0;
	}
	
	//����
	public int take(Position p, Player player){
		if(p.x<0 || p.x>15 || p.y<0 || p.y>15){
			System.out.printf("Put fail:���곬�����̷�Χ��");
			return 0;
		}
		if(search(p)==0){
			System.out.printf("Take fail:λ��(%d, %d)û������\n", p.x, p.y);
			return 0;
		}
		else if(p.p.belongto == playerid){
			System.out.printf("Take fail:λ��(%d, %d)���ǶԷ�������\n", p.x, p.y);
			return 0;
		}
		else{
			if(p.p.color=="black")
				player.history += "Take " + p.p.name + " from ("+p.x+", " + p.y +")\n";	
			else
				player.history += "Take \u001b[1;37m"+ p.p.name + "\u001b[0m from ("+p.x+", " + p.y +")\n";	
			p.p.player.total--;		
			p.remove();
			System.out.println("Take succeed!");
			return 1;
		}
	}
	
	//����
	public int eat(Position src, Position dest, Player player){
		if(src.x<0 || src.x>7 || src.y<0 || src.y>7 || dest.x<0 || dest.x>7 || dest.y<0 || dest.y>7){
			System.out.printf("Put fail:���곬�����̷�Χ��");
			return 0;
		}
		if(search(src) == 1){
			if(src.p.belongto != playerid){
				System.out.println("Eat fail:�����������\n");
				return 0;
			}
			else if(search(dest) == 0){
				System.out.printf("Eat fail:λ��(%d, %d)û������\n", dest.x, dest.y);
				return 0;
			}
			else if(dest.p.belongto == playerid){
				System.out.printf("Eat fail:λ��(%d, %d)�����Լ�������\n", dest.x, dest.y);
				return 0;
			}
			else{
				if(src.p.color=="black")
					player.history += "Eat \u001b[1;37m" + dest.p.name+ "\u001b[0m("+dest.x + ", " + dest.y + ") use " + src.p.name+"("+ src.x +", " + src.y + ")\n";
				else
					player.history += "Eat " + dest.p.name+ "("+dest.x + ", " + dest.y + ") use \u001b[1;37m" + src.p.name+"\u001b[0m("+ src.x +", " + src.y + ")\n";
				dest.p.player.total--;				
				dest.put(src.p);
				src.remove();
				System.out.println("Eat succeed!");
				return 1;
			}
		}
		System.out.printf("Eat fail:λ��(%d, %d)û������\n", src.x, src.y);
		return 0;
	}		
	
}
