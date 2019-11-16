package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void blockAccount(Long accountNumber) {
	
	}

	@Override
	public void createAccount(Account account) {
		accountRepository.save(account);
		customerRepository.save(account.getCustomer());
	}

	@Override
	public void deposit(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance() + amount);
		AccountTransaction accountTransaction=new AccountTransaction("deposit", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		
		TransactionLog log=new TransactionLog
				(accountNumber, null, "depoist", amount, "gunika", "done");
		transactionLogRepository.save(log);
		
	}

	@Override
	public void withdraw(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		// min bal should be 1000 in any case
		if (account.getBalance() - amount < 10)
			throw new NotSufficientFundException();
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		AccountTransaction accountTransaction=new AccountTransaction("withdraw", amount);
		account.addAccountTransaction(accountTransaction);
		
		TransactionLog log=new TransactionLog
				(accountNumber, null, "withdraw", amount, "amit", "done");
		transactionLogRepository.save(log);
	}

	
	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount) {
		this.withdraw(fromAccNumber, amount);
		this.deposit(toAccNumber, amount);
		AccountTransaction accountTransaction=new AccountTransaction("transfer", amount);
		//account.addAccountTransaction(accountTransaction);
		
		TransactionLog log=new TransactionLog
				(fromAccNumber, toAccNumber, "transfer", amount, "karthik", "done");
		transactionLogRepository.save(log);
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	
	

//	@Override
//	public Book updateBook(int id, Book book) {
//		
//		Book booktoBeUpdated=dao.findById(id).orElseThrow(BookNotFoundException::new);
//		booktoBeUpdated.setPrice(book.getPrice());
//		return dao.save(booktoBeUpdated);
//	}

	
	@Override
	public void deleteAccount(Long accountId) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(accountId);
	}

	@Override
	public Optional<Account> findAccountById(long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id);
	}

	@Override
	public Account updateAccount(Long Id, Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

}




