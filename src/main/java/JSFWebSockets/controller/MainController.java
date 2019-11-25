package JSFWebSockets.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final Logger log = Logger.getLogger(MainController.class);

    /**
     * Go to index page.
     */
    @RequestMapping("/")
    public ModelAndView redirectPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("template");
        log.info("index page visited");
        return modelAndView;
    }

    /**
     * Favicon mapping to prevent exception.
     */
    @RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
    public void favicon() { }

}
