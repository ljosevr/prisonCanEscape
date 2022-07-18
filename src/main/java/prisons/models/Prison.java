package prisons.models;

public class Prison {
	private int contador = 0;
	
	private char[][] prisonStructure;
	
	public Prison(String[] prisonArray) {
		prisonStructure = new char[prisonArray.length][prisonArray[0].length()];
		for(int row = 0 ; row < prisonArray.length; row++) {
			for(int column = 0; column < prisonArray[row].length(); column++) {
				prisonStructure[row][column] = prisonArray[row].charAt(column);
			}
		}
	}
    
	public int getContador() {
		return contador;
	}

	public void increaseContador() {
		contador++;
	}

	public char[][] getPrison() {
		return prisonStructure;
	}

	public void setPrison(char[][] prison) {
		this.prisonStructure = prison;
	}
	
    
	@Override
    public String toString() { 
        String salida = ""; 
        for (int x=0; x<prisonStructure.length; x++) {
            for (int y=0; y<prisonStructure[x].length; y++) { 
            	salida += prisonStructure[x][y] + " "; 
            }
            salida += "\n"; 
        }
        return salida;
    }
}
