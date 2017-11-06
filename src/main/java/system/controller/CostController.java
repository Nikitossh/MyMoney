package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.entity.Cost;
import system.entity.Costs;
import system.service.ExpensesService;
import system.service.ExpensesServiceImpl;

@Controller
@RequestMapping(value = "/expenses")
public class CostController {

    private final ExpensesService expensesService;

    @Autowired
    public CostController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String ShowCostsList(String name, Model model) {
        Costs costs = new Costs();
        costs.getCostList().addAll(this.expensesService.findCosts());
        //cost.getCostList().
        //ExpensesServiceImpl.findCosts();
        // Здесь вызов метода из ExpensesService
        model.addAttribute("name", name);
        return "costsList";
    }

}
