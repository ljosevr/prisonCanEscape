package prisons.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import prisons.models.Prison;

class PrisonTest {

	@Test
	void testPrison9x7() {
		String[] data = {"||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		Prison prison = new Prison(data);

		Assertions.assertEquals(7, prison.getPrison().length);
		Assertions.assertEquals(9, prison.getPrison()[0].length);
	}
	
	@Test
	void testIncreaseContador() {
		String[] data = {"||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		Prison prison = new Prison(data);
		
		prison.increaseContador();
		Assertions.assertEquals(1, prison.getContador());
		prison.increaseContador();
		Assertions.assertEquals(2, prison.getContador());
	}
	
}
