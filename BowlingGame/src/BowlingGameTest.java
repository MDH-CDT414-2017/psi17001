/** BowlingGameTest 
 *
 * @author CDT414 Student:
 * @version 1.0 
 * @date 2016-11-24
 */
import org.junit.Test;

import junit.framework.TestCase;

/** BowlingGame Score calculator test cases 
 *  
 */	 
public class BowlingGameTest extends TestCase {
        
	/** test01 
	 * 	
	 *  If no game is provided, score should be -1 (error)   
	 */	   
	@Test
	public void test01() {
       BowlingGame bowlingGame = new BowlingGame("[1,5][3,6]");
//        assertEquals(0, bowlingGame.checkType());
       assertEquals(-1, bowlingGame.getScore());
    }	
	
	@Test
	public void test2() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(81, game1.getScore());
	}
	@Test
	public void testStrike() {
		
		BowlingGame game1 = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(94, game1.getScore());
	}
	@Test
	public void testMultipleStrikes() {
		
		BowlingGame game1 = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(112, game1.getScore());
	}
	@Test
	public void testSpare() {
		
		BowlingGame game1 = new BowlingGame("[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, game1.getScore());
	}
	@Test
	public void testMultipleSpares() {
		
		BowlingGame game1 = new BowlingGame("[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(98, game1.getScore());
	}
	@Test
	public void testStrikeSpare() {
		
		BowlingGame game1 = new BowlingGame("[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(103, game1.getScore());
	}
	@Test
	public void testLastSpare() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
		assertEquals(90, game1.getScore());
	}
	@Test
	public void testLastStrike() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
		assertEquals(92, game1.getScore());
	}
	@Test
	public void testLastSpareStrike() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");
		assertEquals(93, game1.getScore());
	}
	@Test
	public void testMaximum() {
		
		BowlingGame game1 = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(300, game1.getScore());
	}
	@Test
	public void testString()
	{
		BowlingGame game1 = new BowlingGame("[2,3][3,3][4,5][2,4][4,3][3,4][5,5][3,4][2,1][5,3]");
		 assertEquals(true, game1.verifyStringFormat("[2,3][3,3][4,5][2,4][4,3][3,4][5,5][3,4][2,1][5,3]"));
	}
	@Test
	public void testLastStrikeFormatString()
	{
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
		 assertEquals(true, game1.verifyLastStrikeStringFormat("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]"));
	}
	@Test
	public void testLastSpareFormatString()
	{
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
		 assertEquals(true, game1.verifyLastSpareStringFormat("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]"));
	}
	@Test
	public void testLastDoubleSpare() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,2][2,8][7]");
        
        assertEquals(93, bowlingGame.getScore());
    }
	@Test
	public void testLastDoubleStrike() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][10,0][10,0][7,2]");
        
        assertEquals(110, bowlingGame.getScore());
    }
}