package com.example;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * @author Pavel S Varchenko
 * @since 23.04.2017
 */
@Builder
@Data
public class Accounts {
    @Singular
    private List<Account> accounts;
}
