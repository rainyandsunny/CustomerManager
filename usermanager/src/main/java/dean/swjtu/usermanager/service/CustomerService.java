package dean.swjtu.usermanager.service;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.annotation.Transactional;
import dean.swjtu.usermanager.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by yhp5210 on 2017/6/26.
 */
@Service
public class CustomerService {

    @Autowired
    EbeanServer mServer;


    private static final String NAME = "name";
    private static final String SEX = "sex";
    private static final String AGE = "age";
    private static final String ADDRESS = "address";



    public List<Customer> getAllCustomers(){

        return mServer.find(Customer.class).findList();
    }

    public Customer getCustomerById(long id){

        return  mServer.find(Customer.class).where().idEq(id).findUnique();
    }


    public List<Customer> getCustomerByName(String name){

        return mServer.find(Customer.class).where().contains(NAME,name).findList();
    }

    public List<Customer> getCustomerByAddress(String address){

        return mServer.find(Customer.class).where().contains(ADDRESS,address).findList();
    }

    public List<Customer> getCustomerByAge(String age){

        return mServer.find(Customer.class).where().contains(AGE,age).findList();
    }

    public List<Customer> getCustomerBySex(String sex){

        return mServer.find(Customer.class).where().contains(SEX,sex).findList();
    }

    @Transactional
    public Customer save(Customer customer){

        mServer.save(customer);
        return customer;
    }

}
