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
	private String gebruikersnaam;
	public Highscore() {}
	
	public Highscore(double highscore, String gebruikersnaam) {
		this.highscore = highscore;
		this.gebruikersnaam = gebruikersnaam;
	}
	
	public double getHighscore() {
		return highscore;
	}
	public void setHighscore(double highscore) {
		this.highscore = highscore;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public long getId() {
	
		return id;
	}
	
}
