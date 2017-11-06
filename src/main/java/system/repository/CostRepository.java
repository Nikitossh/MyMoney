package system.repository;

import system.entity.Cost;

import java.util.Collection;

public interface CostRepository {
    Collection<Cost> findAll();
}
