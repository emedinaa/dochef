package dochef.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/accesoDenegado")
public class AccesoDenegadoController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    @PreAuthorize("isAuthenticated()") 
    public ModelAndView doGet() {
        return new ModelAndView("accesoDenegado");
    }
}
