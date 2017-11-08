package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.entity.Costs;
import system.service.ExpensesService;

import java.util.Map;

@Controller
@RequestMapping(value = "/expenses")
public class CostController {

    private final ExpensesService expensesService;

    @Autowired
    public CostController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String ShowCostsList(Map<String, Object> model) {
        Costs costs = new Costs();
        costs.getCostList().addAll(this.expensesService.findCosts());
        model.put("costs", costs);
        return "costs/costsList";
    }

}
