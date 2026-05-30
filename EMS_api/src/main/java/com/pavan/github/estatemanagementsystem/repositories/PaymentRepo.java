package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, String> {
}
