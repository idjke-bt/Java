import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author YangFeng
 * @create 2021-01-30 20:43
 */
public class GenericTest {

    @Test
    public void test(){

        Order<String> stringOrder = new Order<>();
        SubOrder<String> stringSubOrder = new SubOrder<>();
        stringOrder = stringSubOrder;


    }

}

class Order<T>{
    //类的内部结构就可以使用
    T orderT;

    public Order() {
    }

    public Order(T orderT) {
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderT=" + orderT +
                '}';
    }
}

class SubOrder<T> extends Order<T>{

}
