package au.com.dotsnboxes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
	
	private static String PLAYER = "1";
	private static String MESSAGE = "Player %s, input a move <column><row> (or 'Q' to quit):";
	private static int TOTALGAMES = 9;
	private static String INPUT_REGEX = "^[a-gA-G][0-6]$";
	private static int[] validXValues = {0, 1, 2, 3, 4, 5, 6};
	private static String validYString = "  ABCDEF\n";
	private static String ASTRICKCOLUMN = "-------\n";
	private static String EMPTYROW = "| | | |\n";
    
    public static void main( String[] args ) {
    	Game game = new Game();
    	GameBoard gameBoard = new GameBoard(validXValues, validYString, ASTRICKCOLUMN, EMPTYROW);
    	game.processUserInput(gameBoard);
    }

    public void processUserInput(GameBoard gameBoard) {
    	System.out.println(gameBoard.drawGameBoard());
    	Map<String, Integer> scoreMap = new HashMap<String, Integer>() {{
            put("1", 0);
            put("2", 0);
        }};
    	while(true) {
    		Position position = getUserInput(gameBoard);
    		PlayGame playGame = new PlayGame(position, gameBoard, TOTALGAMES);
    		int numOfWins = playGame.play(PLAYER, scoreMap);
    		if(numOfWins == 0) {
    			if ("1".equals(PLAYER)) {
    				PLAYER = "2";
            	} else {
            		PLAYER = "1";
            	}
    		} else if (playGame.isGameOver(scoreMap)){
				if (scoreMap.get("1") > scoreMap.get("2")) {
					System.out.println("Game over. Player 1 is the winner!");
				} else {
					System.out.println("Game over. Player 2 is the winner!");
				}
    			System.out.println("Thanks for playing! Goodbye!");
    			System.exit(0);
    		}
            
    	}
    }
    
    public Position getUserInput(GameBoard gameBoard) {
    	Scanner scanner = new Scanner(System.in);  
    	Position position = null;
        System.out.println(String.format(MESSAGE, PLAYER));
        String input = scanner.nextLine();
        if ("Q".equals(input.toUpperCase())) {
        	System.out.println("Thanks for playing! Goodbye!");
        	System.exit(0);
        } 
        if (validateUserInput(input)){
        	int x  = Integer.parseInt(String.valueOf(input.charAt(1)).toUpperCase());
    		char y = Character.toUpperCase(input.charAt(0));
    		position = Position.getPosition(x, y);
    		if (!position.validate() || gameBoard.getValueIn(position) != ' ') {
    			System.out.println("Invalid move. Please try again.");
    			position = getUserInput(gameBoard);
    		}
        } else {
        	System.out.println("Invalid move. Please try again.");
			position = getUserInput(gameBoard);
        }
        
		return position;
    }
    
    private boolean validateUserInput(String input) {
    	return input.matches(INPUT_REGEX);
    }
    
}
