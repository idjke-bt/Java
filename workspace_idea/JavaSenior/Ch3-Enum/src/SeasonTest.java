import java.util.Arrays;

/**
 * 一、 枚举类的使用：
 * 1. 枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只一个对象，则可以作为单例模式的实现方式。
 *
 * @author YangFeng
 * @create 2021-01-16 20:52
 */
public class SeasonTest {

    public static void main(String[] args) {
        Season winter;
        winter = Season.valueOf("WINTER");
        System.out.println(winter.toString());

    }
}


enum Season{
    //1.提供当前枚举类的对象
    SPRING("春天","spring"),
    SUMMER("夏天","summer"),
    AUTUMN("秋天","autumn"),
    WINTER("冬天","winter");


    //1.声明Season对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;


    //2.私有化类的构造器
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //4.其他诉求：toString

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
