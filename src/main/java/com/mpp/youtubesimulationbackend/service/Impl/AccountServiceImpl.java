package com.mpp.youtubesimulationbackend.service.Impl;


import com.mpp.youtubesimulationbackend.Exception.AccountNotFoundException;
import com.mpp.youtubesimulationbackend.dao.AccountRepository;
import com.mpp.youtubesimulationbackend.model.Account;
import com.mpp.youtubesimulationbackend.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public List<Account> getAllAccounts() {
        List<Account> accounts=new ArrayList<>();
        for(Account ac:accountRepository.findAll()) {
            accounts.add(ac);
        }
        return accounts;
    }
    public Account createAccount( Account account) {
        return accountRepository.save(account);
    }
    public Account getAccountById(Long accId) {
        return accountRepository.findById(accId)
                .orElseThrow(() -> new AccountNotFoundException("Account", "id", accId));
    }
    public Account updateAccount(Long accId, Account accountDetails) {

        Account account = accountRepository.findById(accId).orElseThrow(() -> new AccountNotFoundException("Account", "id", accId));

        account.setUserName(accountDetails.getUserName());
        account.setPassword(accountDetails.getPassword());
        account.setEmail(accountDetails.getEmail());

        Account updatedAccount = accountRepository.save(account);
        return updatedAccount;
    }
    public ResponseEntity<?> deleteAccount(Long accID) {
        Account note = accountRepository.findById(accID)
                .orElseThrow(() -> new AccountNotFoundException("Account", "id", accID));

        accountRepository.delete(note);

        return ResponseEntity.ok().build();
    }
//    public Account authenticateAccount(Long id, Account account,  String userName, String password){
//
//
//        if(account.getUserName().equals(userName) && account.getPassword().equals(new BCryptPasswordEncoder().encode(password))) {
//            return account;
//
//        }
//        else {
//            throw new AccountNotFoundException("Account","id",id);
//        }
//
//    }




}