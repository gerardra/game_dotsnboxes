package au.com.dotsnboxes;

import java.util.Map;

public class PlayGame {
	
	private Position position;
	private GameBoard gameBoard;
	private int totalGames;
	
	public PlayGame(Position position, GameBoard gameBoard, int totalGames){
		this.position = position;
		this.gameBoard = gameBoard;
		this.totalGames = totalGames;
	}

	public int play(String player, Map<String, Integer> scoreMap) {
		gameBoard.updateGameBoard(position, position.getDelimiter(position.getY()));
		int numOfWins = timesPlayerWon(player);
		scoreMap.computeIfPresent(player, (k, v) -> v + numOfWins);
		System.out.println(gameBoard.printGameBoardWithScoreCard(scoreMap.get("1"), scoreMap.get("2")));
		return numOfWins;
	}
	
	private int timesPlayerWon(String player) {
		int numOfWins = 0;
		if (position.getDelimiter(position.getY()) == '|') {
			if (pipeLoopUpRightSide() > 0) {
				int newY = position.getY() + 1;
				gameBoard.updateGameBoard(Position.getPosition(position.getX(), (char)newY), player.charAt(0));
			}
			if (pipeLoopUpLeftSide() > 0) {
				int newY = position.getY() - 1;
				gameBoard.updateGameBoard(Position.getPosition(position.getX(), (char)newY), player.charAt(0));
			}
			numOfWins = pipeLoopUpRightSide() + pipeLoopUpLeftSide();
		} else {
			if (hifenLoopUpLeft() > 0) {
				gameBoard.updateGameBoard(Position.getPosition(position.getX() - 1, position.getY()), player.charAt(0));
			}
			if (hifenLoopDownRight() > 0) {
				gameBoard.updateGameBoard(Position.getPosition(position.getX() + 1, position.getY()), player.charAt(0));
			}
			numOfWins = hifenLoopUpLeft() + hifenLoopDownRight();
		}
		return numOfWins;
	}
	
	private int pipeLoopUpRightSide() {
		boolean isWon = false;
		if (gameBoard.getLastColumn() != position.getY()) {
			isWon =  gameBoard.positionAlreadyPlayed(Position.getUpRightPosition(position)) &&gameBoard. positionAlreadyPlayed(Position.getRightPosition(position))
					&& gameBoard.positionAlreadyPlayed(Position.getDownRightPosition(position)) && gameBoard.positionAlreadyPlayed(position);
		}
		return isWon ? 1 : 0;
	}
	
	private int pipeLoopUpLeftSide() {
		boolean isWon = false;
		if (gameBoard.getFirstColumn() != position.getY()) {
			isWon = gameBoard.positionAlreadyPlayed(Position.getUpLeftPosition(position)) && gameBoard.positionAlreadyPlayed(Position.getLeftPosition(position))
			&& gameBoard.positionAlreadyPlayed(Position.getDownLeftPosition(position)) && gameBoard.positionAlreadyPlayed(position);
		}
		return isWon ? 1 : 0;
	}
	
	private int hifenLoopDownRight() {
		boolean isWon = false;
		if (gameBoard.getLastRow() != position.getX()) {
			isWon = gameBoard.positionAlreadyPlayed(Position.getDownRightPosition(position)) && gameBoard.positionAlreadyPlayed(Position.getDownPosition(position))
					&& gameBoard.positionAlreadyPlayed(Position.getDownLeftPosition(position)) && gameBoard.positionAlreadyPlayed(position);
		}
		return isWon ? 1 : 0;
	}
	
	
	private int hifenLoopUpLeft() {
		boolean isWon = false;
		if (gameBoard.getFirstRow() != position.getX()) {
			isWon = gameBoard.positionAlreadyPlayed(Position.getUpLeftPosition(position)) && gameBoard.positionAlreadyPlayed(Position.getUpPosition(position))
					&& gameBoard.positionAlreadyPlayed(Position.getUpRightPosition(position)) && gameBoard.positionAlreadyPlayed(position);
		}
		return isWon ? 1 : 0;
	}
	
	public boolean isGameOver(Map<String, Integer> scoreMap) {
		return scoreMap.get("1") + scoreMap.get("2") == totalGames;
	}
}
