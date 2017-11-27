import java.util.ArrayList;
import java.util.List;

/** BowlingGame Score calculator 
 *
 * @author CDT414 Student: psi17001
 * @version 1.0 
 * @date 2016-11-24
 */


public class BowlingGame {

	/** BowlingGame Score calculator constructor which require string as input 
	 * @param game Expected format "[n,n][n,n]..[n,n]"
	 * 
	 */	 
	List<Frame> frame = new ArrayList<Frame>();
	String game;
	public BowlingGame(String game)
	{	
	//	game = game.substring(1, game.length()-1);
		//if(verifyStringFormat(game) && verifyLastSpareStringFormat(game) && verifyLastStrikeStringFormat(game)) {
		this.game=game;
		String[] frameArray = game.split("]");
		for(String frame: frameArray)	{	
			Frame two_throws=new Frame();

			frame =frame.substring(1, frame.length());
			
			String[] scoresArray = frame.split(",");
			
			
			if(scoresArray.length==2){
				two_throws.setThrow1(Integer.parseInt(scoresArray[0]));
				two_throws.setThrow2(Integer.parseInt(scoresArray[1]));
				this.frame.add(two_throws);
			}
			else {
				two_throws.setThrow1(Integer.parseInt(scoresArray[0]));
				this.frame.add(two_throws);
			}
			
		}
	
	}
		
	
	
	/** getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is -1 
	 */
	public int getScore() {
		
		if(verifyStringFormat(this.game) || verifyLastSpareStringFormat(this.game) || verifyLastStrikeStringFormat(this.game)) {
		int sum=0;
		
		for(int i=0; i<this.frame.size();i++){
			
			if(checkType(this.frame.get(i))==0){
				sum = sum + this.frame.get(i).getThrow1() + this.frame.get(i).getThrow2();
				}
			else if(checkType(this.frame.get(i))==1) {
				if(i==this.frame.size()-2) {
					if(this.frame.get(this.frame.size()-1).getThrow1()==10) {
					sum = sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
					return sum;
					}
					else {
						sum = sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
						return sum;
					}
				}
					else {
						if(this.frame.get(i+1).getThrow1()==10){
							sum= sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+2).getThrow1() + 10;
						}
						else
						sum= sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
					}
			}
			else if(checkType(this.frame.get(i))==2){
				if(i==this.frame.size()-2){
					sum = sum +  10 + this.frame.get(i+1).getThrow1();
					return sum;
					}
				else {
				sum= sum + 10 + this.frame.get(i+1).getThrow1();
				
				}
			}
		}
		return sum;
		}
		else return -1;
	}
	
	public int checkType(Frame two_throws) {
		if((two_throws.getThrow1()+two_throws.getThrow2()==10) && two_throws.getThrow2()==0){	
			two_throws.setStrike(true);
			return 1;
		}
		else if((two_throws.getThrow1()+two_throws.getThrow2()==10) && two_throws.getThrow2()!=0){
			two_throws.setSpare(true);
			return 2;
		}
		else return 0;
	}


	public boolean verifyStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}");
	}
	
	public boolean verifyLastStrikeStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10),([0-9]|10)\\]");
	}
	
	public boolean verifyLastSpareStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10)\\]");
	}

}