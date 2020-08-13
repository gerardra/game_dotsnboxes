package au.com.dotsnboxes;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class GameBoardTest {
	
	private static int[] validXValues = {0, 1, 2};
	private static String validYString = "  ABC\n";
	private static String ASTRICKCOLUMN = " * *\n";
	private static String EMPTYROW = "    \n";
	
	@Test
	public void testBuildInitialGameBoard(){
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		Map<Integer, StringBuilder> board = drawGameBoard.buildInitialGameBoard();
		Assert.assertEquals(3, board.size());
	}
	
	@Test
	public void testDrawGameBoard(){
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		StringBuilder board = drawGameBoard.drawGameBoard();
		Assert.assertNotNull(board);
	}
	
	@Test
	public void testPrintGameBoardWithScoreCard(){
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		StringBuilder board = drawGameBoard.printGameBoardWithScoreCard(1, 0);
		Assert.assertTrue(board.toString().contains("SCORE Player 1:"));
	}
	
	@Test
	public void testFirstColumn(){
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		char firstColumn = drawGameBoard.getFirstColumn();
		Assert.assertTrue('A' == firstColumn);
	}
	
	@Test
	public void testLastColumn(){
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		char lastColumn = drawGameBoard.getLastColumn();
		Assert.assertTrue('C' == lastColumn);
	}

	@Test
	public void testFirstRow(){
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		int firstRow = drawGameBoard.getFirstRow();
		Assert.assertTrue(0 == firstRow);
	}

	@Test
	public void testLastRow(){
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		int lastRow = drawGameBoard.getLastRow();
		Assert.assertTrue(2 ==lastRow);
	}
	
	@Test
	public void testUpdateGameBoardWithHiphen(){
		Position position = Position.getPosition(0, 'B');
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		drawGameBoard.updateGameBoard(position, '-');
		Assert.assertTrue('-' == drawGameBoard.getValueIn(position));
	}
	
	@Test
	public void testUpdateGameBoardWithPlayer(){
		Position position = Position.getPosition(0, 'B');
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		drawGameBoard.updateGameBoard(position, '1');
		Assert.assertTrue('1' == drawGameBoard.getValueIn(position));
	}
	
	@Test
	public void testPositionAlreadyPlayed(){
		Position position = Position.getPosition(0, 'B');
		GameBoard drawGameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
		drawGameBoard.updateGameBoard(position, '-');
		Assert.assertTrue(drawGameBoard.positionAlreadyPlayed(position));
	}
	
}
