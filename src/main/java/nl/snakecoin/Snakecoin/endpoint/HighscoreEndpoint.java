package nl.snakecoin.Snakecoin.endpoint;

import java.util.Optional;

import javax.management.timer.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.snakecoin.Snakecoin.domain.Account;
//import nl.snakecoin.Snakecoin.domain.Account;
import nl.snakecoin.Snakecoin.domain.Highscore;
import nl.snakecoin.Snakecoin.service.AccountService;
import nl.snakecoin.Snakecoin.service.HighscoreService;

@RestController
@RequestMapping(path = "highscore", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })
public class HighscoreEndpoint {
	Timer timer = new Timer();
	@Autowired
	HighscoreService highscoreService;
	AccountService accountService;

	@PostMapping
	public ResponseEntity<Highscore> apiCreate(@RequestBody Highscore highscore) {

		 if (highscore.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Highscore>(highscoreService.save(highscore), HttpStatus.OK);
	}
	
	@PostMapping (path = "starten")
	public ResponseEntity<Highscore> startTimer(){
		System.out.println("activeert dit?");
		if(!this.timer.isActive()) {
			this.timer.start();
			return new ResponseEntity<Highscore>(HttpStatus.OK);
		}else {
			this.timer.stop();
			return new ResponseEntity<Highscore>(HttpStatus.OK);
		}
		
	}
	
	
	
	@GetMapping // Retrieve
	public ResponseEntity<Iterable<Highscore>> apiGetAll() {
		return new ResponseEntity<Iterable<Highscore>>(highscoreService.findAll(), HttpStatus.OK);
	}
	@GetMapping (path ="{id}")
	public ResponseEntity<Iterable<Highscore>> findByGebruikersnaam(String gebruikersnaam){
//		Iterable<Highscore> highscore = highscoreService.findByGebruikersnaam(gebruikersnaam);
//		
//		if(highscore != null) {
		System.out.println(highscoreService.findAll().equals(gebruikersnaam));
		System.out.println(highscoreService.findByGebruikersnaam(gebruikersnaam).equals(gebruikersnaam));
		return new ResponseEntity<Iterable<Highscore>>(highscoreService.findByGebruikersnaam(gebruikersnaam), HttpStatus.OK);
//		}
//		return new ResponseEntity<Iterable<Highscore>>(HttpStatus.CONFLICT);
	}
}
