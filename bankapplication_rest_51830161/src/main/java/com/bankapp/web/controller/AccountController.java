package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.User;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@RestController
@RequestMapping(path="api")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping(path = "account/addaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {

		return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.OK);
	}
	
	@GetMapping(path="account/allaccounts",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAccounts(){
		return accountService.findAll();
	}
	
	@GetMapping(path = "account/accountid/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getUserByID(@PathVariable(name="id")Long id){
		Account account=accountService.findAccountById(id).orElseThrow(AccountNotFoundException::new);
		accountService.findAccountById(id);
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
	
	@PutMapping(path = "account/updateaccount/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAccount(@PathVariable(name = "id") Long id, @RequestBody Account account) {

		return new ResponseEntity<Account>(accountService.updateAccount(id, account), HttpStatus.OK);
	}


	@DeleteMapping(path = "account/deleteaccount/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> deleteAccount(@PathVariable(name = "id") Long id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
	}

}
