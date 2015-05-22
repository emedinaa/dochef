package dochef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dochef.model.Receta;
import dochef.service.RecetaService;


@Controller
@RequestMapping(value = "/public/recetas")
public class RecetasController {

	@Autowired
	private RecetaService recetaService;

    @RequestMapping(method = {RequestMethod.GET})
    public String recetas(Model model){
    	
    	List<Receta> recetas = recetaService.findByAll();
    	model.addAttribute("recetas", recetas);
    	
        return "recetas";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String mostrarReceta(@PathVariable("id") int id, Model model){
    	Receta receta = recetaService.findById(id);
    	model.addAttribute("receta", receta);
    	return "receta";
    }
    

}
