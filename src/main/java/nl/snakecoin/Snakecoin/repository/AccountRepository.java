package nl.snakecoin.Snakecoin.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import nl.snakecoin.Snakecoin.domain.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	
	Optional<Account> deleteByGebruikersnaam(String gebruikersnaam);

	Optional<Account> findByGebruikersnaam(String gebruikersnaam);
}