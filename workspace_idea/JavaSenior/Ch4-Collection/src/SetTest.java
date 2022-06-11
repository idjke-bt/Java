import org.junit.Test;

import java.util.*;

/**
 * @author YangFeng
 * @create 2021-01-24 17:45
 */
public class SetTest {

    @Test
    public void test1(){

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if( o1 instanceof User && o2 instanceof  User){
                    User user1 = (User)o1;
                    User user2 = (User)o2;
                    return -Integer.compare(user1.getAge(), user2.getAge());
                }else{
                    throw  new RuntimeException("输入类型不匹配");
                }
            }
        };

        Set set = new TreeSet(comparator);
        set.add(new User("Tom", 120));
        set.add(new User("Tim", 2));
        set.add(new User("mm", 12));
        set.add(new User("Tqm", 72));
        set.add(new User("eom", 56));



        Iterator iterator = set.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }

    @Test
    public void test2(){
        User u1 = new User("Tom", 12);
        HashSet hashSet = new HashSet();
        hashSet.add(u1);

        u1.setAge(11);
        for(Object obj:hashSet){
            System.out.println(obj);
        }
    }
}

class User implements Comparable{

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    //按照年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            Integer integer = age;
            return integer.compareTo(user.age);
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
