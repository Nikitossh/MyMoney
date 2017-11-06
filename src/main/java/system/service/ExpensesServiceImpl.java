package system.service;

import system.entity.Cost;
import system.repository.CostRepository;

import java.util.Collection;

public class ExpensesServiceImpl implements ExpensesService {
    @Override
    public Collection<Cost> findCosts() {
        return CostRepository.findAll();
    }
}
