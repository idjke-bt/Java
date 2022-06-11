package exer;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author YangFeng
 * @create 2021-01-27 10:47
 */
public class JavaLab {

    public static void main(String[] args) {

        Employee e1 = new Employee("Tom",8,new MyDate(2001,12,12));
        Employee e2 = new Employee("Jack",12,new MyDate(2010,2,12));
        Employee e3 = new Employee("Mikk",22,new MyDate(1901,6,26));
        Employee e4 = new Employee("Joe",43,new MyDate(1954,7,9));
        Employee e5 = new Employee("Kitty",57,new MyDate(2001,1,15));

        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    MyDate date1 = ((Employee)o1).getBirthday();
                    MyDate date2 = ((Employee)o2).getBirthday();

                    int temp = Integer.compare(date1.getYear(), date2.getYear());
                    if(temp == 0){
                        temp = Integer.compare(date1.getMonth(), date2.getMonth());
                        if(temp == 0){
                            return Integer.compare(date1.getDay(), date2.getDay());
                        }else {
                            return temp;
                        }

                    }else {
                        return temp;
                    }
                }else {
                    throw new RuntimeException("输入类型不匹配！");
                }
            }
        };

        TreeSet treeSet =new TreeSet(com);
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        for(Object obj:treeSet){
            System.out.println(obj);
        }

    }
}
