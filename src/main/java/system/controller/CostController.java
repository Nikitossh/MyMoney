package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.entity.Cost;
import system.entity.Costs;
import system.service.CostService;

import java.util.Map;

@Controller
@RequestMapping(value = "/cost")
public class CostController {

    private final CostService costService;

    @Autowired
    public CostController(CostService costService) {
        this.costService = costService;
    }

    /** Outputting ALL costs in /mvc/expenses/list
     * @param model automatically by Spring ???
     * @return view costAll.jsp */

    @GetMapping("/list")
    public String ShowCostsList(Map<String, Object> model) {
        Costs costs = new Costs();
        costs.getCostList().addAll(this.costService.findCosts());
        model.put("cost", costs);
        return "cost/costAll";
    }

    @GetMapping("/month")
    public String ShowMonthCost(Map<String, Object> model) {
        Costs costs = new Costs();
        costs.getCostList().addAll(this.costService.findMonthCost());
        model.put("monthCost", costs);
        return "cost/costMonth";
    }


}
