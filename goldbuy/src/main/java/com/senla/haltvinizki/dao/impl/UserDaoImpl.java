package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

   private final List<User> userList;

    public UserDaoImpl() {
        userList=new ArrayList<>();
        userList.add(new User(0,0,0,"Oleg","+375332234234","ole@gmail.com"));
        userList.add(new User(1,1,1,"Lesha","+3757898","lesha@gmail.com"));
    }

    @Override
 public User delete(User user) {
  userList.remove(user);
  return user;
 }

 @Override
 public User create(User user) {
     userList.add(user);
     return user;
 }

 @Override
 public User update(User user) {
     for (User soughtUser: read()){
      if (soughtUser.getId()==user.getId()){
       soughtUser=user;
      }
     }
     return user;
 }


 @Override
    public List<User> read() {
     return userList;
    }
}
