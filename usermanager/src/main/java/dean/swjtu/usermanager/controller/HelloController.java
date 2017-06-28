package dean.swjtu.usermanager.controller;

import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yhp5210 on 2017/6/26.
 */

@RestController
public class HelloController {

    private static final String TAG = "HelloController";


    //惯例
    @RequestMapping("/")
    public String hello(){
        return "hello world";
    }

    //配置环境辛苦了
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloToMyself(){
        return "hello Haipeng Yang";
    }


}
