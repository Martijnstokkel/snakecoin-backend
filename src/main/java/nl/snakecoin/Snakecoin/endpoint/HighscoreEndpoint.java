package nl.snakecoin.Snakecoin.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import nl.snakecoin.Snakecoin.domain.Account;
import nl.snakecoin.Snakecoin.domain.Highscore;
import nl.snakecoin.Snakecoin.service.HighscoreService;

@RestController
@RequestMapping(path = "Highscore", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })
public class HighscoreEndpoint {

	@Autowired
	HighscoreService highscoreService;

	@PostMapping
	public ResponseEntity<Highscore> apiCreate(@RequestBody Highscore highscore) {
		if (highscore.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Highscore>(highscoreService.save(highscore), HttpStatus.OK);
	}

	@GetMapping // Retrieve
	public ResponseEntity<Iterable<Highscore>> apiGetAll() {
		return new ResponseEntity<Iterable<Highscore>>(highscoreService.findAll(), HttpStatus.OK);
	}
}
