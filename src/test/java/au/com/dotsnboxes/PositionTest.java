package au.com.dotsnboxes;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {
	
	@Test
	public void testValidGetUpPosition() {
		Position position = Position.getUpPosition(Position.getPosition(2, 'A'));
		Assert.assertTrue(position.getX() == 0);
		Assert.assertTrue(position.getY() == 'A');
	}
	
	@Test
	public void testFirstRowGetUpPosition() {
		Position position = Position.getUpPosition(Position.getPosition(0, 'A'));
		Assert.assertTrue(position.getX() == -2);
		Assert.assertTrue(position.getY() == 'A');
	}
	
	@Test
	public void testDownLeftPosition() {
		Position position = Position.getDownLeftPosition(Position.getPosition(0, 'B'));
		Assert.assertTrue(position.getX() == 1);
		Assert.assertTrue(position.getY() == 'A');
	}

	@Test
	public void testDownPosition() {
		Position position = Position.getDownPosition(Position.getPosition(0, 'B'));
		Assert.assertTrue(position.getX() == 2);
		Assert.assertTrue(position.getY() == 'B');
	}
	
	@Test
	public void testDownRightPosition() {
		Position position = Position.getDownRightPosition(Position.getPosition(0, 'B'));
		Assert.assertTrue(position.getX() == 1);
		Assert.assertTrue(position.getY() == 'C');
	}
	
	@Test
	public void testRightPosition() {
		Position position = Position.getRightPosition(Position.getPosition(0, 'B'));
		Assert.assertTrue(position.getX() == 0);
		Assert.assertTrue(position.getY() == 'D');
	}

	@Test
	public void testUpPosition() {
		Position position = Position.getUpPosition(Position.getPosition(2, 'B'));
		Assert.assertTrue(position.getX() == 0);
		Assert.assertTrue(position.getY() == 'B');
	}
	
	@Test
	public void testUpRightPosition() {
		Position position = Position.getUpRightPosition(Position.getPosition(2, 'B'));
		Assert.assertTrue(position.getX() == 1);
		Assert.assertTrue(position.getY() == 'C');
	}
	
	@Test
	public void testLeftPosition() {
		Position position = Position.getLeftPosition(Position.getPosition(2, 'C'));
		Assert.assertTrue(position.getX() == 2);
		Assert.assertTrue(position.getY() == 'A');
	}
}
