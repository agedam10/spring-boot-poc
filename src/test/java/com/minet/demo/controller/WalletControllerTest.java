package com.minet.demo.controller;

import com.minet.demo.dao.WalletRepository;
import com.minet.demo.entity.Wallet;
import com.minet.demo.service.WalletService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(WalletController.class)
public class WalletControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletService walletService;
    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void testUpdateWallet() {
        Wallet wallet = Wallet.builder()
                .runningBalance(2)
                .customerId(1)
                .build();
        List<Wallet> walletList = new ArrayList<>();
        walletList.add(wallet);
        walletService.saveOrUpdateWallet(221.23F,1);
    }
}
