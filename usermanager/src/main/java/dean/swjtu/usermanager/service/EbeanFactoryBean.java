package dean.swjtu.usermanager.service;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by yhp5210 on 2017/6/26.
 */

@Component
public class EbeanFactoryBean  implements FactoryBean<EbeanServer> {

    DataSourceConfig dataSourceConfig = new DataSourceConfig();

    @Autowired
    CurrentUser currentUser;

    @Override
    public EbeanServer getObject() throws Exception {

        ServerConfig config = new ServerConfig();
        config.setName("db");
        config.loadFromProperties();
        config.setDefaultServer(true);
        config.setRegister(true);
        return EbeanServerFactory.create(config);

    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
