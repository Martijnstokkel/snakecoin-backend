package nl.snakecoin.Snakecoin.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.snakecoin.Snakecoin.repository.AccountRepository;
import nl.snakecoin.Snakecoin.domain.Account;


@Service
@Transactional
public class AccountService {

	@Autowired
	AccountRepository AccountRepository;
	
	public Account save (Account account) {
		return AccountRepository.save(account);
	}
	
	public Iterable<Account> findAll() {
		return AccountRepository.findAll();
	}

	public  void deleteById(long id) {
		AccountRepository.deleteById(id);
	}
	public Optional<Account> findById(long id) {
		return AccountRepository.findById(id);
	}
	
}