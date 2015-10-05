import java.util.Scanner;
public class Zork {	
	private static String item="a dead scorpion", direction1="north",direction2=null,direction3=null, location="foyer";
	private static int v=0, h=1, doors=0,score=0;
	private static String[][] room=new String[3][3];
	public static void main(String[] args){
			 	
			String input="null";
			Scanner keyboard= new Scanner(System.in);
			
			room[0][1]="foyer";
			room[1][1]="front room";
			room[1][0]="library";
			room[1][2]="kitchen";
			room[2][0]="dining room";
			room[2][1]="vault";
			room[2][2]="parlor";
			
			while (!input.equals("exit")){
			System.out.print("You are standing in the " +location +" of an old house.\n"
					+ "You see " +item+ "\n "
					+ "Exit to the ");
			Direction(location);
			System.out.println("?\n(Input exit to leave house)\nYour score is: "+score/2);
			input=keyboard.next();
			Change(input);
			Room(location);				
			
			}
			
			System.out.println("You jumped out the window. Your final score is: "+score/2);
			
			keyboard.close();
		}
		public static void Direction(String g){
			Room(g);
			if (doors==1) System.out.print(direction1);
			if (doors==2) System.out.print(direction1+" or " +direction2);
		    if (doors==3) System.out.print(direction1+", "+direction2+" or "+direction3);
		}
	
		public static void Change(String d){
			if(d.equals("north")){
				v++;
				location=room[v][h];
			}
			if(d.equals("south")){
				v--;
				location=room[v][h];
			}
			if(d.equals("west")){
				h--;
				location=room[v][h];
			}
			if(d.equals("east")){
				h++;
				location=room[v][h];
			}
			
		}
		public static void Room(String a){
			direction1=null;direction2=null;direction3=null;
			if (a.equals("foyer")){
				item="a dead scorpion.";
				
				direction1="north";
				doors=1;
				
			}
			if (a.equals("front room")){
				item="a piano.";
				direction1="south";
				direction2="west";
				direction3="east";
				doors=3;
				score=score+1;
			}
			if (a.equals("library")){
				item="some spiders.";
				
				direction1="east";
				direction2="north";
				doors=2;
				score=score+1;
			}
			if (a.equals("kitchen")){
				item="some bats.";
				
				direction1="west";
				
				direction2="north";
				doors=2;
				score=score+1;
			}
			if (a.equals("dining room")){
				item="some dust and an empty box.";
				direction1="south";
				doors=1;
				score=score+1;
			
			}
			if (a.equals("vault")){
				item="3 walking skeletons.";
				
				direction1="east";
				doors=1;
				score=score+2;
				
			}
			if (a.equals("parlor")){
				item="a treasure chest.";
				direction1="south";
				direction2="west";
				doors=2;
				score=score+1;
			}
		
		}
}
