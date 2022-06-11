package com.generics.dao;

import com.generics.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author YangFeng
 * @create 2022-05-07 16:15
 */
@Repository
public class UserDao extends BaseDao<User>{
    @Override
    public void save() {
        System.out.println("UserDao:保存用户.....");
    }
}
