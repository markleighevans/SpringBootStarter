package uk.co.clockworktitan.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.clockworktitan.ProjectionRepository;
import uk.co.clockworktitan.ProjectionRepository;
import uk.co.clockworktitan.model.AffordabilityCase;
import uk.co.clockworktitan.model.Projection;
import uk.co.clockworktitan.model.Projection;

import java.util.Iterator;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/Projection") // This means URL's start with /demo (after Application path)


public class ProjectionController {
    
    @Autowired
    private ProjectionRepository ProjectionRepository;

    //@GetMapping(path="/add") // Map ONLY GET Requests
    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewProjection(@RequestBody Projection Projection) {

        Projection n = new Projection();
        if (Projection.getId() != null) {
            //Record ID is being passed, so must be updating an existing record
            System.out.println("System ID: " + Projection.getId());
            n.setId(Projection.getId());
        } else
        // no ID passed, so must be a new record
        {
            System.out.println("Blank System ID ");
        }

        n.setAffordabilityCaseID(Projection.getAffordabilityCaseID());
        ProjectionRepository.save(n);

        JSONObject obj = new JSONObject();

        obj.put("id", n.getId());

        return obj.toJSONString();

    }

   
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Projection> getAllProjections() {
        // This returns a JSON or XML with the Projections
        return ProjectionRepository.findAll();
    }

    @GetMapping(path = "/FindbyID/{ProjectionID}")
    public @ResponseBody
    Projection getSingleProjection(@PathVariable(value = "ProjectionID") int num1) {
        // This returns a JSON or XML with a single Projection
        System.out.println("Query Paramter:" + num1);
        return ProjectionRepository.findOne(num1);
    }

    @GetMapping(path = "/DeletebyID/{ProjectionID}")
    public @ResponseBody
    void DeleteSingleProjection(@PathVariable(value = "ProjectionID") int num2) {
        // This returns a JSON or XML with a single Projection
        // System.out.println("Query Paramter:" + num1);
        ProjectionRepository.delete(num2);
    }

    @GetMapping(path = "/FindbyAffordabilityCaseID/{AffordabilityCaseID}")
    public @ResponseBody
    Iterable<Projection> getProjectionByAffordabilityCaseID(@PathVariable(value = "AffordabilityCaseID") int num1) {
        // This returns a JSON or XML with a single Projection
        System.out.println("Query Projection by AffordabilityCaseID: " + num1);
        return ProjectionRepository.findAllByAffordabilityCaseID(num1);
    }
}
