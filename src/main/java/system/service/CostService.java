package system.service;

import system.entity.Cost;

import java.util.Collection;

public interface CostService {
    Collection<Cost> findCosts();
    Collection<? extends Cost> findMonthCost();
}
