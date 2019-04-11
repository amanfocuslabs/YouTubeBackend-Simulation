package com.mpp.youtubesimulationbackend.controller;

import com.mpp.youtubesimulationbackend.Exception.AccountNotFoundException;
import com.mpp.youtubesimulationbackend.model.Account;
import com.mpp.youtubesimulationbackend.service.Impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;

    // Get All Accounts
    @GetMapping("/accounts") //@RequestMapping(value="/notes", method=RequestMethod.GET)
    public List<Account> getAllAccounts() {

        return accountService.getAllAccounts();
    }

    // Create a new Account
    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }
    // Get a Single Account
    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable(value = "id") Long accId) {
        return accountService.getAccountById(accId);
    }

    // Update an Account
    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable(value = "id") Long accId,
                                 @Valid @RequestBody Account accountDetails) {

        return accountService.updateAccount(accId,accountDetails);
    }

    // Delete an Account
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accID) {
        return accountService.deleteAccount(accID);
    }
//    @GetMapping("/accounts/l")
//    public Account authenticateAccount( @Valid @RequestBody String userName,@Valid @RequestBody String password) {
//        List<Account> accounts=accountService.getAllAccounts();
//        for(Account acc:accounts){
//            if(acc.getUserName().equals(userName) && acc.getPassword().equals(new BCryptPasswordEncoder().encode(password))) {
//                return acc;
//            }
//        }
//        throw new AccountNotFoundException("userName","password","NotFound");
//
//    }
}