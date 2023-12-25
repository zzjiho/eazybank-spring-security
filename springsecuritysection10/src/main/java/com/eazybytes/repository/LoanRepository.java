package com.eazybytes.repository;

import com.eazybytes.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Long> {

    //PreAuthorize는 메소드가 실행되기 전에 권한을 체크하는 어노테이션 ,
    // PostAuthorize는 메소드가 실행된 후에 권한을 체크하는 어노테이션
    // 무슨 차이냐면 PreAuthorize는 메소드가 실행되기 전에 권한을 체크하기 때문에 권한이 없으면 메소드가 실행되지 않는다.
    // 하지만 PostAuthorize는 메소드가 실행된 후에 권한을 체크하기 때문에 메소드는 실행되지만 권한이 없으면 예외가 발생한다.
    @PreAuthorize("hasRole('USER')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
