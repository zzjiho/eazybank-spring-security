package com.eazybytes.controller;

import com.eazybytes.model.Loans;
import com.eazybytes.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

//    SELECT *
//    FROM Customer
//    WHERE customerId = #{customerId}
//    ORDER BY startDt DESC;
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loan = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loan != null) {
            return loan;
        } else {
            return null;
        }
    }

}
