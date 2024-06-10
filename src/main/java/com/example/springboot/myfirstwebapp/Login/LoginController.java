package com.example.springboot.myfirstwebapp.Login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    //public Logger logger = LoggerFactory.getLogger(getClass());
    //http://localhost:8080/login?name=Ranga           passing parameters with url

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String goToLoginPage(){       // from the request parameter now tied to 'name'

        //logger.debug("Request param is {}",name);
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model){

        if (authenticationService.authenticate(name,password)){
            model.put("name", name);
            return "welcome";
        }
        model.put("ErrorMessage","Invalid Credentials! Please try again.");
        return "login";
    }
}
