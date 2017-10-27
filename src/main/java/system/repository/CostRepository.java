package system.repository;

import system.entity.Costs;

import java.util.Collection;

public interface CostRepository {
    Collection<Costs> findAll(); 
}
