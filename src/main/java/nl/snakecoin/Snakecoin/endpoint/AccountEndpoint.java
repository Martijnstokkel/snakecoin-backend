package nl.snakecoin.Snakecoin.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.snakecoin.Snakecoin.domain.Account;
import nl.snakecoin.Snakecoin.service.AccountService;

@RestController 
@RequestMapping(
		path = "aanmelden"
		,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		)

public class AccountEndpoint {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Account> apiCreate(@RequestBody Account Account) {
		if (Account.getId() != 0) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Account>(
				accountService.save(Account), 
				HttpStatus.OK);
	}
	
	
	@GetMapping 	// Retrieve
	public ResponseEntity<Iterable<Account>> apiGetAll() {
		return new ResponseEntity<Iterable<Account>>(
				accountService.findAll(), 
				HttpStatus.OK);
	}

	@GetMapping (path ="{id}")
	public ResponseEntity<Optional<Account>> apiGetById(
			@PathVariable long id) {
		Optional<Account> account = accountService.findById(id);
		return new ResponseEntity<>(
				account, 
				account.isPresent() 
					? HttpStatus.OK 
					: HttpStatus.NOT_FOUND);
	}
	@DeleteMapping(path="{id}") 	// Delete
	public ResponseEntity<Account> apiDeleteById(@PathVariable("id") long id) {
		if (!accountService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			accountService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
