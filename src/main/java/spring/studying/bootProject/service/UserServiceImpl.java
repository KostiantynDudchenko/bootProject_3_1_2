package spring.studying.bootProject.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.studying.bootProject.dao.UserDAO;
import spring.studying.bootProject.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDAO.update(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
