package nl.snakecoin.Snakecoin.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Highscore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private double highscore;
	
	public Highscore() {}
	
	public Highscore(double highscore) {
		this.highscore = highscore;
	}
	
	public double getHighscore() {
		return highscore;
	}
	public void setHighscore(double highscore) {
		this.highscore = highscore;
	}

	public long getId() {
	
		return id;
	}
	
}
