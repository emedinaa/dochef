package dochef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dochef.model.Plan;
import dochef.service.PlanService;


@Controller
@RequestMapping(value = "/public/planes")
public class PlanesController {

	@Autowired
	private PlanService planService;
	
    @RequestMapping(method = {RequestMethod.GET})
    public String planes(Model model){
    	
    	List<Plan> planes = planService.findByAll();
    	model.addAttribute("planes", planes);
    	
        return "planes";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String mostrarReceta(@PathVariable("id") int id, Model model){
    	Plan plan = planService.findById(id);
    	model.addAttribute("plan", plan);
    	return "plan";
    }

    
    
}
