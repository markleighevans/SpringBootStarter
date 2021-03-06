package uk.co.clockworktitan.controller;
import jdk.nashorn.internal.objects.NativeJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;
import uk.co.clockworktitan.UserRepository;
import uk.co.clockworktitan.model.*;

import java.io.Console;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)


public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    //@GetMapping(path="/add") // Map ONLY GET Requests
    @PostMapping(path="/add")
    public @ResponseBody  String addNewUser (@RequestBody User user) {

        User n = new User();
        if (user.getId()!= null)
        {
            //Record ID is being passed, so must be updating an existing record
            System.out.println("System ID: " + user.getId());
            n.setId(user.getId());
        }
        else
            // no ID passed, so must be a new record
        {System.out.println("Blank System ID "); }

        n.setName(user.getName());
        n.setEmail(user.getEmail());
        n.setPassword(user.getPassword());
        userRepository.save(n);

        JSONObject obj = new JSONObject();

        obj.put("id", n.getId());
        //obj.put("name", user.getName());
        //obj.put("password", user.getPassword());
        //obj.put("email", user.getEmail());

        return obj.toJSONString();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/FindbyID/{UserID}")
    public @ResponseBody User getSingleUser(@PathVariable(value="UserID") int num1 ) {
        // This returns a JSON or XML with a single user
        System.out.println("Query Paramter:" + num1);
        return userRepository.findOne(num1);
    }

    @GetMapping(path="/DeletebyID/{UserID}")
    public @ResponseBody void DeleteSingleUser(@PathVariable(value="UserID") int num2 ) {
        // This returns a JSON or XML with a single user
       // System.out.println("Query Paramter:" + num1);
         userRepository.delete(num2);
    }
}
