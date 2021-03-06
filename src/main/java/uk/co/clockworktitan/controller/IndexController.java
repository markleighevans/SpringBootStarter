package uk.co.clockworktitan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index() {
        return "home";
    }
    @GetMapping("/BS")
    public String BS() {
        return "Bootstrap";
    }

    @GetMapping("/viewall")
    public String viewall() {
        return "viewall";
    }

    @GetMapping("/IncomeType")
    public String IncomeType() {
        return "IncomeType";
    }


    @GetMapping("/Income")
    public String Income() {return "Income";}

    @GetMapping("/Outgoings")
    public String Outgoings() {return "Outgoings";}

    @GetMapping("/OutgoingsType")
    public String OutgoingsType() {return "OutgoingsType";}

    @GetMapping("/AffordabilityCase")
    public String AffordabilityCase() {return "AffordabilityCase";}

    @GetMapping("/QuoteSummary")
    public String QuoteSummary() {return "QuoteSummary";}

    @GetMapping("/Test")
    public String Test() {return "Test";}

}