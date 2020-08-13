package au.com.dotsnboxes;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PlayGameTest {
	
	private static int[] validXValues = {0, 1, 2};
	private static String validYString = "  ABC\n";
	private static String ASTRICKCOLUMN = " * *\n";
	private static String EMPTYROW = "    \n";
	
	@Test
	public void testNoWin(){
		GameBoard gameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		Map<String, Integer> scoreMap = new HashMap<String, Integer>() {{
            put("1", 0);
            put("2", 0);
        }};
		Position position = Position.getPosition(0, 'B');
		PlayGame playGame = new PlayGame(position, gameBoard, 1);
		int numOfWins = playGame.play("1", scoreMap);
		Assert.assertEquals(0, numOfWins);
	}
	
	@Test
	public void testWithWin(){
		GameBoard gameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		Map<String, Integer> scoreMap = new HashMap<String, Integer>() {{
            put("1", 0);
            put("2", 0);
        }};
        gameBoard.updateGameBoard(Position.getPosition(0, 'B'), '-');
        gameBoard.updateGameBoard(Position.getPosition(1, 'C'), '|');
        gameBoard.updateGameBoard(Position.getPosition(2, 'B'), '-');
        PlayGame playGame = new PlayGame(Position.getPosition(1, 'A'), gameBoard, 1);
        int numOfWins = playGame.play("1", scoreMap);
        Assert.assertEquals(1, numOfWins);
        
	}

}
