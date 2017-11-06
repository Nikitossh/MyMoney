package system.service;

import system.entity.Cost;
import system.repository.CostRepository;
import system.repository.jpa.CostRepositoryImpl;

import java.util.Collection;

public class ExpensesServiceImpl implements ExpensesService {
    @Override
    public Collection<Cost> findCosts() {
        return CostRepositoryImpl.findAll();
    }
}
