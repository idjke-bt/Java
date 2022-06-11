package exer;

import java.util.*;

/**
 * 实验二：自定义泛型类
 *
 * @author YangFeng
 * @create 2021-01-31 15:30
 */
public class DAO<T> {

    private Map<String, T> map = new HashMap<>();

    //保存T类型的对象到Map成员变量中
    public void save(String id, T entity){
        map.put(id, entity);
    }

    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }

    //替换Map中key为Id的内容
    public void update(String id, T entity){
        map.replace(id, entity);
    }

    //返回map中存放的所有T对象
    public List<T> list(){
       List<T> list = new ArrayList<>(map.size());
        Collection<T> values = map.values();
        for(T t:values){
            list.add(t);
        }
        return list;
    }

    //删除指定的id
    public void delete(String id){
        map.remove(id);
    }

}
