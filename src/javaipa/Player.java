package javaipa;

import java.util.*;

class Playerdetail {
	private int playerId;
	private String playerName;
	private int run;
	private String playerType;
	private String matchType;
	
	public Playerdetail(int playerId,String playerName,int run,String playerType,String matchType) {
		this.playerId=playerId;
		this.playerName=playerName;
		this.run=run;
		this.playerType=playerType;
		this.matchType=matchType;
	}
		public int getplayerId() {
		return playerId;
	}
	public String getplayerName() {
		return playerName;
	}
	public int getrun() {
		return run;
	}
	public String getplayerType() {
		return playerType;
	}
	public String getmatchType() {
		return matchType;
	}

}
public class Player{
	public static int findPlayerWithLowestRuns(Playerdetail[] Playerdetails,String PlayerType) {
		int minrun=Integer.MAX_VALUE;
		for(Playerdetail p:Playerdetails) {
			if(p.getplayerType().equals(PlayerType)) {
			if(minrun>p.getrun()) {
				minrun=p.getrun();
			}
			}
		}
			if(minrun==Integer.MAX_VALUE)return 0;
			else return minrun;
	}
	public static Playerdetail[] findPlayerByMatchType(Playerdetail[] Playerdetails,String matchType) {
//		name of arraylist must be same as of array name
		ArrayList<Playerdetail> list = new ArrayList<>();
		for(Playerdetail p:Playerdetails) {
			if(p.getmatchType().equalsIgnoreCase(matchType)) {
				list.add(p);
				}
			}
		list.sort(Comparator.comparing(Playerdetail::getplayerId).reversed());
	    if(list.isEmpty()) {
	        return null;
	    }
	    return list.toArray(new Playerdetail[0]);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Playerdetail arr[]=new Playerdetail[4];
		for(int i=0;i<arr.length;i++) {
//			to do change order
			int a=sc.nextInt();
			sc.nextLine();
			String b=sc.next();
			int c=sc.nextInt();
			sc.nextLine();
			String d=sc.nextLine();
//			if there is gap in sentence then we should use nextLine()(ex.- in "one day" nextLine is required and in "one" next() is sufficient)
			String e=sc.nextLine();
			
			arr[i]=new Playerdetail(a, b, c, d, e) ; 
		}
		String playerType=sc.nextLine();
	
		String matchType=sc.nextLine();
		
		int playerrun=findPlayerWithLowestRuns(arr,playerType);
		
		Playerdetail[] p=findPlayerByMatchType(arr,matchType);
		
		if(playerrun==0) {
			System.out.println("No such player");
		}
		else System.out.println(playerrun);
		
		
		
		if(p!=null) {
			for(Playerdetail l:p) {
				System.out.println(l.getplayerId());
		}
		}
		else {
			System.out.println("No Player with given matchType");
		}
	}
}
