package prisons.models.dto;

import java.io.Serializable;

public class StatsPrisonDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer countSuccessfulEscape;
	private Integer countUnsuccessfulEscape;
	private Double ratio;
	
	public Integer getCountSuccessfulEscape() {
		return countSuccessfulEscape;
	}
	public void setCountSuccessfulEscape(Integer countSuccessfulEscape) {
		this.countSuccessfulEscape = countSuccessfulEscape;
	}
	public Integer getCountUnsuccessfulEscape() {
		return countUnsuccessfulEscape;
	}
	public void setCountUnsuccessfulEscape(Integer countUnsuccessfulEscape) {
		this.countUnsuccessfulEscape = countUnsuccessfulEscape;
	}
	public Double getRatio() {
		return ratio;
	}
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
	
	
	
}
