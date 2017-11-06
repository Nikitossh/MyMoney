package system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.entity.Cost;
import system.service.ExpensesService;
import system.service.ExpensesServiceImpl;

@Controller
@RequestMapping(value = "/expenses")
public class ExpensesController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String ShowCostsList(String name, Model model) {
        Cost cost = new Cost();
        //cost.getCostList().
        ExpensesServiceImpl.findCosts();
        // Здесь вызов метода из ExpensesService
        model.addAttribute("name", name);
        return "costsList";
    }

}
