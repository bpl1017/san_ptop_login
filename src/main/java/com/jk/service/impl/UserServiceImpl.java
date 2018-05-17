package com.jk.service.impl;

import com.jk.dao.UserDao;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2018/5/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserBean login(UserBean userBean) {
        return userDao.login(userBean);
    }

    @Override
    public void updatemima(Integer userid, String passwo3) {
        userDao.updatemima(userid,passwo3);
    }

    @Override
    public Integer querysaverenshu(String format) {
       Integer  count= userDao.querysaverenshu(format);
        return count;
    }

    @Override
    public Integer queryzongrenshu() {
        Integer  count=  userDao.queryzongrenshu();
        return count;
    }

    @Override
    public Integer queryloginrenshu(String format) {
        Integer  count=  userDao.queryloginrenshu(format);
        return count;
    }
}
