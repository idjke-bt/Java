package com.generics.serivce;

import com.generics.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author YangFeng
 * @create 2022-05-07 20:19
 */
public class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;
    public void save(){
        System.out.println("====正在调用"+ baseDao+"====");
        baseDao.save();
    }
}
