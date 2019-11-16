package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.User;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.beans.DepositeAndWithdrawRequests;
import com.bankapp.web.controller.beans.TransferRequests;

@RestController
@RequestMapping(path="api")
public class TransactionController {

	@Autowired
	private AccountService accountService;
	
	
	@PostMapping(path = "transaction/deposite")
	public ResponseEntity<Account> depositeAmount(@RequestBody DepositeAndWithdrawRequests req,Principal principal ){
		accountService.deposit(req.getAccountNumber(), req.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	
	@PostMapping(path = "transaction/withdraw")
	public ResponseEntity<Account> withdrawAmount(@RequestBody DepositeAndWithdrawRequests req,Principal principal){
		accountService.withdraw(req.getAccountNumber(), req.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@PostMapping(path = "transaction/transfer")
	public ResponseEntity<Account> transferAmount(@RequestBody TransferRequests req,Principal principal){
		accountService.transfer(req.getFromAccount(),req.getToAccount(),req.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	
}




//@PostMapping(path = "/account/deposite/{id}/{amount}", produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity<Account> depositeAmount(@PathVariable(name="id") Long accountNumber,
//		@PathVariable(name="amount") Double amount){
//	accountService.deposit(accountNumber, amount);
//	return new ResponseEntity<Account>(HttpStatus.OK);
//}



//@PostMapping(path = "/account/withdraw/{id}/{amount}", produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity<Account> withdrawAmount(@PathVariable(name="id") Long accountNumber,
//		@PathVariable(name="amount") Double amount){
//	accountService.withdraw(accountNumber, amount);
//	return new ResponseEntity<Account>(HttpStatus.OK);
//}

//@PostMapping(path = "/account/transfer/{fromAccount}/{toAccount}/{amount}", produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity<Account> transferAmount(@PathVariable(name="fromAccount") Long fromAccount,
//		@PathVariable(name="toAccount") Long toAccount,
//		@PathVariable(name="amount") Double amount){
//	accountService.transfer(fromAccount,toAccount, amount);
//	return new ResponseEntity<Account>(HttpStatus.OK);
//}
