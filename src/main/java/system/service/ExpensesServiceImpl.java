package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Cost;
import system.repository.CostRepository;

import java.util.Collection;

@Service
public class ExpensesServiceImpl implements ExpensesService {
    private CostRepository costRepository;

    @Autowired
    public ExpensesServiceImpl(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    @Override
    public Collection<Cost> findCosts() {
        return costRepository.findAll();
    }
}
