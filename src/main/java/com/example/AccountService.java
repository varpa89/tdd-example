package com.example;

import org.springframework.stereotype.Service;

/**
 * @author Pavel S Varchenko
 * @since 24.04.2017
 */
@Service
public class AccountService {

    public Account persist(Account account){
        account.setId("888");
        return account;
    }
}
