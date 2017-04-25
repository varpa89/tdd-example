package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity<Accounts> getAccounts() {
        Accounts accounts = Accounts.builder().account(Account.builder().name("3345345").build()).build();
        return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<String> create() {
        Account account = Account.builder().build();
        Account persistedAccount = accountService.persist(account);
        return new ResponseEntity<>(persistedAccount.getId(), HttpStatus.CREATED);
    }

}
