package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.User;

public interface AccountService {
	public void blockAccount(Long accountNumber);
    public void createAccount(Account account );
    public void deposit(Long accountNumber, double amount);
    public void withdraw(Long accountNumber, double amount);
    public void transfer(Long fromAccNumber, Long toAccNumber, double amount);
    
    public Account addAccount(Account account);
    public List<Account> findAll();
    public void deleteAccount(Long accountId);
    public Optional<Account>findAccountById(long id);
	public Account updateAccount(Long Id,Account account);
}
