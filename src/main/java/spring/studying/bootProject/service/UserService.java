package spring.studying.bootProject.service;


import spring.studying.bootProject.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    User show(int id);

    void update(int id, User user);

    void delete(int id);
}
