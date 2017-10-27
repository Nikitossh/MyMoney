package system.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/expenses")
public class ExpensesController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getCostsList(String name, Model model) {

        model.addAttribute("name", name);
        return "costsList";
    }

}
