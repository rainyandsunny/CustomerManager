package dean.swjtu.usermanager.controller;

import dean.swjtu.usermanager.domain.Customer;
import dean.swjtu.usermanager.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yanghaipeng on 2017/6/27.
 */

@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CustomerService service;

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
        service.saveCustomer(customer);

        //TODO 此处可以跳转新界面（或者刷新当前界面）

    }

    @RequestMapping(value = "/listUsers",method = RequestMethod.GET)
    public String listAllUsers(Model model){

        logger.debug("listAllUsers");
        List<Customer> customers = service.getAllCustomers();
        model.addAttribute("customers",customers);
        return "index";
    }


    @RequestMapping(value = "/listPageUsers",method = RequestMethod.GET)
    public void listUsersByPages(){

        //TODO 分页暂时未做
    }


    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public String findUserById(@RequestParam(value = "id", required = true)String id,Model model){

        logger.debug("findUserById");
        Long customId = Long.getLong(id);
        List<Customer> customers = service.getCustomerById(customId);
        model.addAttribute("customers",customers);
        return "index";
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public void updateUser(
                        @RequestParam(value = "id", required = true)long id,
                        @RequestParam(value = "name", required = true)String name,
                        @RequestParam(value = "sex", required = true)String sex,
                        @RequestParam(value = "age", required = true)int age,
                        @RequestParam(value = "address", required = true)String address){

        logger.debug("updateUser");
        logger.debug("id: " + id + ",name: " + name +" ,sex: " + sex + ",age: " + age + ",address: " + address);
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setAge(age);
        customer.setSex(sex);
        customer.setAddress(address);
        service.updateCustomer(customer);

        //TODO
        
    }
}