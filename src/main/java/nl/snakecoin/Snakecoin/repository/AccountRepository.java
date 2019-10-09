package nl.snakecoin.Snakecoin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.snakecoin.Snakecoin.domain.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	
	
}