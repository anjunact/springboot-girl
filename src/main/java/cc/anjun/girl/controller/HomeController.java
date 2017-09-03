package cc.anjun.girl.controller;

import cc.anjun.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {


    @Autowired
    private GirlProperties girl;

    @RequestMapping(value = "/say/{id}")
    public String say(@PathVariable(value = "id",required = false) Integer myId, @RequestParam(value = "name",required = false,defaultValue = "3") String name){
        return myId.toString()+name;
    }
}

