package system.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple domain object representing a list of cost. Mostly here to be used for 'costs'
 * @author nik
 */

public class Costs {
    private List<Cost> costs;

    public List<Cost> getCostList() {
        if (costs == null) {
            costs = new ArrayList<>();
        }
        return costs;
    }
}
