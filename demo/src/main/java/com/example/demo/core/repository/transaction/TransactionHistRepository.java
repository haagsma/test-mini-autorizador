package com.example.demo.core.repository.transaction;

import com.example.demo.core.domain.credit_card.TransactionHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistRepository extends JpaRepository<TransactionHist, Long> {
}
