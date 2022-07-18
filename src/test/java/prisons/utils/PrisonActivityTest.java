package prisons.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import prisons.models.PositionInPrison;
import prisons.models.Prison;

class PrisonActivityTest {
	
	@Autowired
	PrisonActivity prisonActivity;
	
	@Test
	void testValidatePrison() {
		String[] data = {"||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		Prison prison = new Prison(data);
		PositionInPrison positionInPrison = PrisonActivity.whereIsPrisoner(data);
		
		boolean validatePrison = PrisonActivity.validatePrison(positionInPrison.getRow(), positionInPrison.getColumn(), prison);
		Assertions.assertEquals(true, validatePrison);
	}
	
	@Test
	void testValidatePrisonNotValid() {
		String[] data = {"|||||||||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		Prison prison = new Prison(data);
		PositionInPrison positionInPrison = PrisonActivity.whereIsPrisoner(data);
		
		boolean validatePrison = PrisonActivity.validatePrison(positionInPrison.getRow(), positionInPrison.getColumn(), prison);
		Assertions.assertEquals(false, validatePrison);
	}
	
	@Test
	void testIsGuardRange() {
		String[] data = {"||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		Prison prison = new Prison(data);
		
		boolean isGuardRange = PrisonActivity.isGuardRange(3, 5, prison);
		Assertions.assertEquals(true, isGuardRange);
		
		isGuardRange = PrisonActivity.isGuardRange(4, 1, prison);
		Assertions.assertEquals(true, isGuardRange);
		
		isGuardRange = PrisonActivity.isGuardRange(3, 7, prison);
		Assertions.assertEquals(false, isGuardRange);
		
		
	}
	
	@Test
	void testWhereIsExit() {
		String[] data = {"||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		
		PositionInPrison positionInPrison = PrisonActivity.whereIsExit(data);
		Assertions.assertEquals(0, positionInPrison.getRow());
		Assertions.assertEquals(6, positionInPrison.getColumn());
	}

	@Test
	void testWhereIsPrisoner() {
		String[] data = {"||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		
		PositionInPrison positionInPrison = PrisonActivity.whereIsPrisoner(data);
		Assertions.assertEquals(1, positionInPrison.getRow());
		Assertions.assertEquals(1, positionInPrison.getColumn());
	}

}
