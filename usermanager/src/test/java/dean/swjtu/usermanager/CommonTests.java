package dean.swjtu.usermanager;

import org.junit.Test;

/**
 * Created by yanghaipeng on 2017/6/28.
 */
public class CommonTests {


    @Test
    public void strToLong(){

        long a = Long.getLong("str");
        System.out.println("a: " + a);
    }
}
