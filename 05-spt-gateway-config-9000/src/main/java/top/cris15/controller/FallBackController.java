package top.cris15.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date： 2023/11/8
 * time： 07:02
 * author： cris
 * description：
 **/

@RestController
public class FallBackController {

    @RequestMapping(value = "/fb")
    public String fallBackHandle(){
        return "this is a gateway fallback";
    }
}
