package nl.snakecoin.Snakecoin.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;



@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String voornaam;
	private String achternaam;
	private String wachtwoord;
	@Size (min = 7, max = 15)
	@Column(unique=true)
	private String gebruikersnaam;
	private String emailadres;


	public Account() {}
	public Account(String voornaam,  String achternaam, String gebruikersnaam,String wachtwoord, String emailadres) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.gebruikersnaam = gebruikersnaam;
		this.emailadres= emailadres;
	}
	
	public long getId() {
		return id;
	}
	
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}
	public String getEmailadres() {
		return emailadres;
	}
	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}
}
