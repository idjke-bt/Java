package exer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author YangFeng
 * @create 2021-01-27 11:44
 */
public class PersonTest {

    @Test
    public void test(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1); //存入的是p1的地址,存放的位置是address1
        set.add(p2);

        p1.name = "CC"; //由于set中存放的是地址，故set中"AA"----->"CC"

        set.remove(p1); //remove的第一步：计算p1的hash值，得到在set中的位置address2。
                        // 由于p1的name属性发生了变化，因此相应的hash值也发生了变化，由hash值计算得到的在
                        //set中的位置address2(!=address1)，因此此次删除是无效的
        System.out.println(set);//有两个对象

        set.add(new Person(1001,"CC")); //计算hash值，得到存放在set中的位置为address2(!=address1),
                                                 //所以不调用equals方法，添加成功
        System.out.println(set);//有三个对象

        set.add(new Person(1001, "AA")); //计算hash值，得到存放在set中的位置为address1
                                                  //比较(1001,AA)和p1=(1001, CC)的hash值,不相同,添加成功
        System.out.println(set);//有四个对象
    }

}

class Person{

    int id;
    String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
