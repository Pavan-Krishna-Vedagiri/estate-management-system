package com.pavan.github.estatemanagementsystem.services;

import com.pavan.github.estatemanagementsystem.entities.SequenceItem;
import com.pavan.github.estatemanagementsystem.repositories.SequenceItemRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SequenceServiceImp implements SequenceService {

    private final SequenceItemRepo sequenceItemRepo;

    public SequenceServiceImp(SequenceItemRepo sequenceItemRepo) {
        this.sequenceItemRepo = sequenceItemRepo;
    }

    @Override
    @Transactional
    public String nextSequenceValue(String sequenceName) {
        Optional<SequenceItem> sequenceItem = sequenceItemRepo.findById(sequenceName);

        String newSequenceId = String.valueOf(BigDecimal.valueOf(10000));
        if (sequenceItem.isPresent()) {
            SequenceItem nextSequenceItem = sequenceItem.get();
            newSequenceId = nextSequenceItem.getSequenceNumber();
            newSequenceId = new BigDecimal(newSequenceId).add(BigDecimal.ONE).toString();
            nextSequenceItem.setSequenceNumber(newSequenceId);
        }else {
            SequenceItem nextSequenceItem = new SequenceItem();
            nextSequenceItem.setSequenceNumber(newSequenceId);
            nextSequenceItem.setSequenceId(sequenceName);
            sequenceItemRepo.save(nextSequenceItem);
        }
        return newSequenceId;
    }
}
