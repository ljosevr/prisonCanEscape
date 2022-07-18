package prisons.utils;

import org.apache.commons.lang3.StringUtils;

import prisons.models.PositionInPrison;
import prisons.models.Prison;

public class PrisonActivity {
	
	
	public static boolean validatePrison(int prisonerInitialRow, int prisonerInitialColumn, Prison prison){
        if (prisonerMove(prisonerInitialRow, prisonerInitialColumn, prison)) { 
        	prison.getPrison()[prisonerInitialRow][prisonerInitialColumn] = 'P';
        	return true;
	    }
        return false;
    }
	
    private static boolean prisonerMove(int prisonerMoveRow, int prisonerMoveColumn, Prison prison) {
    	prison.increaseContador();
	        if (prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]=='S'){
	            return true; // Encontro Salida
		    }
		    if (prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]=='|' 
		    	|| isGuardRange(prisonerMoveRow, prisonerMoveColumn, prison)
		    	|| prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]=='*'
		    	|| prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]== '^' || prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]== 'V' || prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]== '<' || prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]== '>') { 
		    	// si llegamos a una pared o al mismo punto o a un Guardia, No puede seguir por esta Ruta.
	            return false;
		    }
		    
		    prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]='*'; 
	        boolean result;	
		    
	        result	=	prisonerMove(prisonerMoveRow, prisonerMoveColumn+1, prison); //Se mueve arriba
		    if (result) {
		    	return true;
		    }
		    result	=	prisonerMove(prisonerMoveRow-1, prisonerMoveColumn, prison);  // Se mueve a la Izquierda
		    if (result) {
		    	return true; 
		    }
		    result	=	prisonerMove(prisonerMoveRow, prisonerMoveColumn-1, prison); // Se Mueve Abajo
		    if (result) {
		    	return true;
		    }
		    result	=	prisonerMove(prisonerMoveRow+1, prisonerMoveColumn, prison); // Se mueve a la derecha
		    if (result) {
		    	return true; 
		    }
		    
		    prison.getPrison()[prisonerMoveRow][prisonerMoveColumn]	=	' ';
		   
		    return false;

    }
    
    
    public static boolean isGuardRange(int row, int column, Prison prison) {
		
		//Validate Up
		int rowUp = row - 1;
		if(rowUp >= 0) {
			String data = prison.getPrison()[rowUp][column]+"";
			if(data.equalsIgnoreCase("V")) {
				return true;
			}
		}
		
		//Validate Right
		int columnRight = column + 1;
		
		if(columnRight <= prison.getPrison().length) {
			String data = prison.getPrison()[row][columnRight]+"";
			if(data.equalsIgnoreCase("<")) {
				return true;
			}
		}
		
		//ValidateDown
		int rowDown = row + 1;
		if(rowDown <= prison.getPrison().length) {
			String data = prison.getPrison()[rowDown][column]+"";
			if(data.equalsIgnoreCase("^")) {
				return true;
			}
		}
		
		
		//ValidateLeft
		int columnLeft = column - 1;
		if(columnLeft >= 0) {
			String data = prison.getPrison()[row][columnLeft]+"";
			if(data.equalsIgnoreCase(">")) {
				return true;
			}
		}
		return false;
	}
	
	public static PositionInPrison whereIsExit(String[] prison) {
		PositionInPrison positionInPrison = null;
		for(int fila = 0; fila < prison.length; fila ++) {
			
			if(StringUtils.containsIgnoreCase(prison[fila], "S")) {
				positionInPrison = new PositionInPrison();
				positionInPrison.setRow(fila);
				positionInPrison.setColumn(StringUtils.indexOf(prison[fila], "S"));
				break;
			}
			
		}
		
		return positionInPrison;
	
	}
	
	public static PositionInPrison whereIsPrisoner(String[] prison) {
		PositionInPrison positionInPrison = null;
		for(int fila = 0; fila < prison.length; fila ++) {
			
			if(StringUtils.containsIgnoreCase(prison[fila], "P")) {
				positionInPrison = new PositionInPrison();
				positionInPrison.setRow(fila);
				positionInPrison.setColumn(StringUtils.indexOf(prison[fila], "P"));
				break;
			}
			
		}
		
		return positionInPrison;
	
	}
	
}
