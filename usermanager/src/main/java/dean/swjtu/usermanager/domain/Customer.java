package dean.swjtu.usermanager.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yhp5210 on 2017/6/26.
 */

@Entity
@Table(name = "customer")
public class Customer extends BaseModel{


    @Column(name = "name",length = 20)
    private String name;

    @Column(name = "sex",length = 10)
    private String sex;

    @Column(name = "age",length = 5)
    private int age;

    @Column(name = "address",length = 100)
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
