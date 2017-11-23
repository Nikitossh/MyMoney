package system.repository;

import org.springframework.data.repository.CrudRepository;
import system.entity.Cost;

import java.util.Collection;

public interface CostRepository {
    Collection<Cost> findAll();
    Collection<? extends Cost> findMonthCost();
}
