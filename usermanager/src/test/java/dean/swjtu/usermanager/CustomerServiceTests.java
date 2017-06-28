package dean.swjtu.usermanager;

import com.avaje.ebean.EbeanServer;
import dean.swjtu.usermanager.domain.Customer;
import dean.swjtu.usermanager.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by yanghaipeng on 2017/6/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    EbeanServer server;

    @Test
    public void addTest(){

        assertNotNull(server);
        for(int i = 0; i < 10; i ++){
            Customer customer = new Customer();
            customer.setName("杨海鹏" + i);
            customer.setSex("男");
            customer.setAge(24);
            customer.setAddress("陕西省咸阳市");
            server.save(customer);
        }
    }

    @Test
    public void getAllTest(){

        assertNotNull(server);
        List result = server.find(Customer.class).findList();
        assertEquals(result.size(),1);
    }

    @Test
    public void getCustomerById(){

        assertNotNull(server);
        List result = server.find(Customer.class).where().idEq(1).findList();
        assertNotEquals(result.size(),0);
    }
}
