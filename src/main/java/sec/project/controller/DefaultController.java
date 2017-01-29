package sec.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/redirect?redirect=/view";
    }
    
    
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(@RequestParam String redirect){
        return "redirect:" + redirect;
    }
    
}
