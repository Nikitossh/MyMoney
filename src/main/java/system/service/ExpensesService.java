package system.service;

import system.entity.Cost;

import java.util.Collection;

public interface ExpensesService {
    Collection<Cost> findCosts();
}
