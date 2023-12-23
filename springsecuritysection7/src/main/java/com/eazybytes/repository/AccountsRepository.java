package com.eazybytes.repository;

import com.eazybytes.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts findByCustomerId(int customerId); //유저가 로그인할때면 계좌정보를 받으려고

}
