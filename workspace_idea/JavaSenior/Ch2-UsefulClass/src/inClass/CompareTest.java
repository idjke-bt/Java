package inClass;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2021-01-16 11:11
 */
public class CompareTest {

    @Test
    public void test(){
        //对商品对象进行排序
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovo", 11);
        arr[1] = new Goods("huaWei", 22);
        arr[2] = new Goods("xiaoMi", 15);
        arr[3] = new Goods("Apple", 1);


        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        Object o1 = new Goods();
        if(o1 instanceof Goods){

        }



    }
}
