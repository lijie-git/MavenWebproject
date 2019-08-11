package Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVC {
    @RequestMapping("/hello")
    public String read(){
        return "xx";
    }
}
