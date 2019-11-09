package nl.snakecoin.Snakecoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import nl.snakecoin.Snakecoin.domain.Highscore;
import nl.snakecoin.Snakecoin.repository.HighscoreRepository;

@Service
@Transactional
public class HighscoreService {

	@Autowired
	HighscoreRepository highscoreRepository;
	
	public Highscore save(Highscore highscore) {
		return highscoreRepository.save(highscore);
	}

	public Iterable<Highscore> findAll() {
		return highscoreRepository.findAll();
	}

	public Iterable<Highscore> findByGebruikersnaam(String gebruikersnaam){
		return highscoreRepository.findByGebruikersnaam(gebruikersnaam);
	}

}
