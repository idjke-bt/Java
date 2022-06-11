package com.generics.serivce;

import com.generics.bean.User;
import com.generics.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangFeng
 * @create 2022-05-07 16:16
 */
@Service
public class UserService extends BaseService<User>{
}
