package uk.co.clockworktitan.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.clockworktitan.IncomeTypeRepository;
import uk.co.clockworktitan.model.IncomeType;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/IncomeType") // This means URL's start with /demo (after Application path)


public class IncomeTypeController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private IncomeTypeRepository incometypeRepository;

    //@GetMapping(path="/add") // Map ONLY GET Requests
    @PostMapping(path="/add")
    public @ResponseBody  String addNewUser (@RequestBody IncomeType incometype) {

        IncomeType n = new IncomeType();
        if (incometype.getId()!= null)
        {
            //Record ID is being passed, so must be updating an existing record
            System.out.println("System ID: " + incometype.getId());
            n.setId(incometype.getId());
        }
        else
            // no ID passed, so must be a new record
        {System.out.println("Blank System ID "); }

        n.setIncomeTypeName(incometype.getIncomeTypeName());
        n.setIncomeTypeWeighting(incometype.getIncomeTypeWeighting());
        n.setIndexLinked(incometype.getIndexLinked());
        incometypeRepository.save(n);

        JSONObject obj = new JSONObject();

        obj.put("id", n.getId());

        return obj.toJSONString();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<IncomeType> getAllUsers() {
        // This returns a JSON or XML with the users
        return incometypeRepository.findAll();
    }

    @GetMapping(path="/FindbyID/{IncomeTypeID}")
    public @ResponseBody IncomeType getSingleIncomeType(@PathVariable(value="IncomeTypeID") int num1 ) {
        // This returns a JSON or XML with a single user
        System.out.println("Query Paramter:" + num1);
        return incometypeRepository.findOne(num1);
    }

    @GetMapping(path="/DeletebyID/{UserID}")
    public @ResponseBody void DeleteSingleUser(@PathVariable(value="UserID") int num2 ) {
        // This returns a JSON or XML with a single user
       // System.out.println("Query Paramter:" + num1);
        incometypeRepository.delete(num2);
    }
}
