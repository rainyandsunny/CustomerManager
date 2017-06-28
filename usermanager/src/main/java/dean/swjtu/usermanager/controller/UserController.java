package dean.swjtu.usermanager.controller;

import dean.swjtu.usermanager.domain.Customer;
import dean.swjtu.usermanager.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yanghaipeng on 2017/6/27.
 */

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private CustomerService service = new CustomerService();

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public void addUser(@RequestParam(value = "name", required = true)String name,
                        @RequestParam(value = "sex", required = true)String sex,
                        @RequestParam(value = "age", required = true)int age,
                        @RequestParam(value = "address", required = true)String address){

        logger.debug("addUser");
        logger.debug("name: " + name +" ,sex: " + sex + ",age: " + age + ",address: " + address);
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSex(sex);
        customer.setAge(age);
        customer.setAddress(address);
        service.save(customer);

    }

    @RequestMapping(value = "/listUsers",method = RequestMethod.GET)
    public void listAllUsers(){

        logger.debug("listAllUsers");
        service.getAllCustomers();
    }


    @RequestMapping(value = "/listPageUsers",method = RequestMethod.GET)
    public void listUsersByPages(){

        //TODO 分页暂时未做
    }
    

    public String findUserById(@RequestParam(value = "id", required = true)String id){


        return null;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public void updateUser(
                        @RequestParam(value = "id", required = true)String id,
                        @RequestParam(value = "name", required = true)String name,
                        @RequestParam(value = "sex", required = true)String sex,
                        @RequestParam(value = "age", required = true)int age,
                        @RequestParam(value = "address", required = true)String address){

        logger.debug("updateUser");
        logger.debug("id: " + id + ",name: " + name +" ,sex: " + sex + ",age: " + age + ",address: " + address);
        
    }
}