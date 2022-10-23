package ItemWeb.ItemWeb.web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    @GetMapping("admin")
    public String admin(){
        return "home";
    }

    @GetMapping("admin_point")
    public String admin_point(){
        return "home";
    }

    @GetMapping("admin_remove")
    public String admin_remove(){
        return "home";
    }



}
