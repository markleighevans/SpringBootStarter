package uk.co.clockworktitan.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.clockworktitan.OutgoingsTypeRepository;
import uk.co.clockworktitan.model.OutgoingsType;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/OutgoingsType") // This means URL's start with /demo (after Application path)


public class OutgoingsTypeController {
    @Autowired // This means to get the bean called OutgoingsTypeRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private OutgoingsTypeRepository OutgoingsTypeRepository;

    //@GetMapping(path="/add") // Map ONLY GET Requests
    @PostMapping(path="/add")
    public @ResponseBody  String addNewOutgoingsType (@RequestBody OutgoingsType OutgoingsType) {

        OutgoingsType n = new OutgoingsType();
        if (OutgoingsType.getId()!= null)
        {
            //Record ID is being passed, so must be updating an existing record
            System.out.println("System ID: " + OutgoingsType.getId());
            n.setId(OutgoingsType.getId());
        }
        else
            // no ID passed, so must be a new record
        {System.out.println("Blank System ID "); }

        n.setOutgoingsTypeName(OutgoingsType.getOutgoingsTypeName());
        n.setIndexLinked(OutgoingsType.getIndexLinked());
        OutgoingsTypeRepository.save(n);

        JSONObject obj = new JSONObject();

        obj.put("id", n.getId());

        return obj.toJSONString();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<OutgoingsType> getAllOutgoingsTypes() {
        // This returns a JSON or XML with the OutgoingsTypes
        return OutgoingsTypeRepository.findAll();
    }

    @GetMapping(path="/FindbyID/{OutgoingsTypeID}")
    public @ResponseBody OutgoingsType getSingleOutgoingsType(@PathVariable(value="OutgoingsTypeID") int num1 ) {
        // This returns a JSON or XML with a single OutgoingsType
        System.out.println("Query Paramter:" + num1);
        return OutgoingsTypeRepository.findOne(num1);
    }

    @GetMapping(path="/DeletebyID/{OutgoingsTypeID}")
    public @ResponseBody void DeleteSingleOutgoingsType(@PathVariable(value="OutgoingsTypeID") int num2 ) {
        // This returns a JSON or XML with a single OutgoingsType
       // System.out.println("Query Paramter:" + num1);
        OutgoingsTypeRepository.delete(num2);
    }
}
