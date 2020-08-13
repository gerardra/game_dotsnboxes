package au.com.dotsnboxes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import au.com.dotsnboxes.Position;

public class GameBoard {
	
	private int[] rows;
	private String columns;
	private Map<Integer, StringBuilder> gameBoardRowMappings;
	private int firstRow;
	private int lastRow;
	private char firstColumn;
	private char lastColumn;
	private String astrickRow;
	private String emptyRow;

	public GameBoard(int[] rows, String columns, String astrickRow, String emptyRow){
		this.rows = rows;
		this.columns = columns;
		this.astrickRow = astrickRow;
		this.emptyRow = emptyRow;
		this.gameBoardRowMappings = buildInitialGameBoard();
		this.firstRow = rows[0];
		this.lastRow = rows[rows.length - 1];
		this.firstColumn = columns.charAt(2);
		this.lastColumn = columns.charAt(columns.length() - 2);
	}
	
	public int getFirstRow() {
		return firstRow;
	}

	public int getLastRow() {
		return lastRow;
	}

	public char getFirstColumn() {
		return firstColumn;
	}

	public char getLastColumn() {
		return lastColumn;
	}

	public Map<Integer, StringBuilder> buildInitialGameBoard() {
		Map<Integer, StringBuilder> gameBoardRowMappings = new HashMap<>();
		for (int i = 0; i < this.rows.length; i++) {
			if (i % 2 == 0) {
				gameBoardRowMappings.put(i, new StringBuilder(astrickRow));
			} else {
				gameBoardRowMappings.put(i, new StringBuilder(emptyRow));
			}
		}
		return gameBoardRowMappings;
	}
	
	public StringBuilder drawGameBoard() {
		StringBuilder gameBoard = new StringBuilder(columns);
		for (Entry<Integer, StringBuilder> e : gameBoardRowMappings.entrySet()) {
			gameBoard.append(e.getKey()).append(e.getValue());
		}
		return gameBoard;
	}
	
	public StringBuilder printGameBoardWithScoreCard(int score1, int score2) {
		String scoreCard = String.format("SCORE Player 1: %s Player 2: %s \n", score1, score2);
		return drawGameBoard().append(scoreCard);
	}
	
	public char getValueIn(Position position) {
		StringBuilder row = gameBoardRowMappings.get(position.getX());
		int column = columns.indexOf(position.getY()) - 1;
		return row.charAt(column);
	}

	public void updateGameBoard(Position position, char value) {
		StringBuilder row = gameBoardRowMappings.get(position.getX());
		int column = columns.indexOf(position.getY()) - 1;
		char pos = row.charAt(column);
		if (pos == ' ') {
			row.setCharAt(column, value);
		}
	}
	
	public boolean positionAlreadyPlayed(Position position) {
		int YPosition = columns.indexOf(position.getY()) - 1;
		char symbol = gameBoardRowMappings.get(position.getX()).charAt(YPosition);
		return '-' == symbol || '|' == symbol;
	}
}
