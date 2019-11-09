package nl.snakecoin.Snakecoin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import nl.snakecoin.Snakecoin.domain.Highscore;

@Repository
public interface HighscoreRepository extends CrudRepository<Highscore, Long> {

	Iterable<Highscore> findByGebruikersnaam(String gebruikersnaam);
}
