package dochef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dochef.model.Consejo;
import dochef.service.ConsejoService;


@Controller
@RequestMapping(value = "/public/consejos")
public class ConsejosController {
	
	@Autowired
	private ConsejoService consejoService;

	
    @RequestMapping(method = {RequestMethod.GET})
    public String consejos(Model model){
    	
    	List<Consejo> consejos = consejoService.findByAll();
    	model.addAttribute("consejos", consejos);    	
        return "consejos";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String mostrarReceta(@PathVariable("id") int id, Model model){
    	Consejo consejo = consejoService.findById(id);
    	model.addAttribute("consejo", consejo);
    	return "consejo";
    }    


}
