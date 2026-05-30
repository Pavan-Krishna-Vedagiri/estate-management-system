package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.RentInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentInvoiceRepo extends JpaRepository<RentInvoice, String> {

}
