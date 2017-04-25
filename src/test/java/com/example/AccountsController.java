package com.example;

/**
 * @author Pavel S Varchenko
 * @since 23.04.2017
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountsController {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Test
    public void should_return_accounts() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/accounts"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].name").value("3345345"));
    }

    @Test
    public void should_create_account() throws Exception {

        Mockito.when(accountService.persist(Matchers.any())).thenReturn(Account.builder().id("111").build());

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("111"));
    }

}
