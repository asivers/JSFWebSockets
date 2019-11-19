package JSFWebSockets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView redirectPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("template");
        return modelAndView;
    }

}
