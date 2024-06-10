package com.example.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {

    //@ResponseBody
    //@RequestMapping("say-hello")
    //public String sayHello(){
      //  return "Hello! What are you learning today?";
    //}

   // @ResponseBody
    //@RequestMapping("say-hello-html")
   // public String sayHelloHtml(){

     //   StringBuffer sb = new StringBuffer();
     //   sb.append("<html>");
     //   sb.append("<head>");
     //   sb.append("<title> My First Html Page </title>");
     //   sb.append("</head>");
     //   sb.append("<body>");
     //   sb.append("My first html page with body - change");
     //   sb.append("</body>");
     //   sb.append("</html>");

       // return sb.toString();
    //}

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}
