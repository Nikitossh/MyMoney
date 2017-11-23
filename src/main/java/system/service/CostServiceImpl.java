package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Cost;
import system.repository.CostRepository;

import java.util.Collection;

@Service
public class CostServiceImpl implements CostService {
    private CostRepository costRepository;

    @Autowired
    public CostServiceImpl(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    @Override
    public Collection<Cost> findCosts() {
        return costRepository.findAll();
    }

    @Override
    public Collection<? extends Cost> findMonthCost() {
        return this.costRepository.findMonthCost();
    }

}
