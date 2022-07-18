package prisons.models.dto;

import java.io.Serializable;

public class PrisonDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String[] prison;

	public String[] getPrison() {
		return prison;
	}

	public void setPrison(String[] prison) {
		this.prison = prison;
	}
	
}
