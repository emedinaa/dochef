package dochef.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dochef.model.Plan;
import dochef.service.PlanService;



@Controller
@RequestMapping(value = "/protected/planes")
public class ProtectedPlanesController {

	

	@Autowired
	private PlanService planService;
	
	
    @RequestMapping(value = "/{id}/archivos", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PREMIUM')")
    public String mostrarArchivos(@PathVariable("id") int id, Model model){
    	Plan plan = planService.findById(id);
    	model.addAttribute("plan", plan);
    	return "archivosPlan";
    }

    @RequestMapping(value = "/{id}/videos", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PREMIUM')")
    public String mostrarVideos(@PathVariable("id") int id, Model model){
    	Plan plan = planService.findById(id);
    	model.addAttribute("plan", plan);
    	return "videosPlan";
    }    
    
}
