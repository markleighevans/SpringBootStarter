package uk.co.clockworktitan.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.clockworktitan.OutgoingsRepository;
import uk.co.clockworktitan.model.Outgoings;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/Outgoings") // This means URL's start with /demo (after Application path)


public class OutgoingsController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private OutgoingsRepository OutgoingsRepository;

    //@GetMapping(path="/add") // Map ONLY GET Requests
    @PostMapping(path="/add")
    public @ResponseBody  String addNewUser (@RequestBody Outgoings Outgoings) {

        Outgoings n = new Outgoings();
        if (Outgoings.getId()!= null)
        {
            //Record ID is being passed, so must be updating an existing record
            System.out.println("System ID: " + Outgoings.getId());
            n.setId(Outgoings.getId());
        }
        else
            // no ID passed, so must be a new record
        {System.out.println("Blank System ID "); }

        n.setOutgoingsTypeId(Outgoings.getOutgoingsTypeId());
        n.setOutgoingsDescription(Outgoings.getOutgoingsDescription());
        n.setFromDate(Outgoings.getFromDate());
        n.setToDate(Outgoings.getToDate());
        n.setAmount(Outgoings.getAmount());
        OutgoingsRepository.save(n);

        JSONObject obj = new JSONObject();

        obj.put("id",  n.getId());

        return obj.toJSONString();

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Outgoings> getAllUsers() {
        // This returns a JSON or XML with the users
        return OutgoingsRepository.findAll();
    }

    @GetMapping(path="/FindbyID/{OutgoingsID}")
    public @ResponseBody Outgoings getSingleOutgoings(@PathVariable(value="OutgoingsID") int num1 ) {
        // This returns a JSON or XML with a single user
        System.out.println("Query Paramter:" + num1);
        return OutgoingsRepository.findOne(num1);
    }

    @GetMapping(path="/DeletebyID/{UserID}")
    public @ResponseBody void DeleteSingleUser(@PathVariable(value="UserID") int num2 ) {
        // This returns a JSON or XML with a single user
       // System.out.println("Query Paramter:" + num1);
        OutgoingsRepository.delete(num2);
    }
}
