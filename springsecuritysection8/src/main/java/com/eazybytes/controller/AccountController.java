package com.eazybytes.controller;

import com.eazybytes.model.Accounts;
import com.eazybytes.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) { //클라이언트로부터 id를 받는다.
        Accounts accounts = accountsRepository.findByCustomerId(id); //그 id를 기반으로 계좌정보 가져옴
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

}
