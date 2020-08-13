package au.com.dotsnboxes;

public class Position {
	
	private int x;
	private char y;
	private Position(int x, char y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public char getY() {
		return y;
	}
	
	public static Position getUpPosition(Position position) {
		return new Position(position.getX() - 2, position.getY());
	}

	public static Position getDownPosition(Position position) {
		return new Position(position.getX() + 2, position.getY());
	}
	
	public static Position getLeftPosition(Position position) {
		int prvY = position.getY() -2;
		return new Position(position.getX(), (char)prvY);
	}

	public static Position getRightPosition(Position position) {
		int nxtY = position.getY() + 2;
		return new Position(position.getX(), (char)nxtY);
	}
	
	public static Position getUpRightPosition(Position position) {
		int nxtY = position.getY() + 1;
		return new Position(position.getX() - 1, (char)nxtY);
	}

	public static Position getDownLeftPosition(Position position) {
		int prvY = position.getY() - 1;
		return new Position(position.getX() + 1, (char)prvY);
	}
	
	public static Position getUpLeftPosition(Position position) {
		int prvY = position.getY() - 1;
		return new Position(position.getX() -1, (char)prvY);
	}

	public static Position getDownRightPosition(Position position) {
		int nxtY = position.getY() + 1;
		return new Position(position.getX() + 1, (char)nxtY);
	}
	
	public static Position getPosition(int x, char y) {
		return new Position(x, y);
	}
	
	public boolean validate() {
		if ((x % 2 != 1 && y % 2 != 0)) {
			return false;
		}
		return true;
	}
	
	public char getDelimiter(int y) {
		char delimiter = ' ';
		if (y % 2 == 0) {
			delimiter = '-';
		} else {
			delimiter = '|';
		}
		return delimiter;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}
