package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.SequenceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceItemRepo extends JpaRepository<SequenceItem, String> {
}
