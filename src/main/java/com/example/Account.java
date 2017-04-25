package com.example;

import lombok.Builder;
import lombok.Data;

/**
 * @author Pavel S Varchenko
 * @since 23.04.2017
 */
@Data
@Builder
public class Account {
    private String id;
    private String name;
}
