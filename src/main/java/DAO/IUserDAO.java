package DAO;


import Model.User;

import java.util.List;

public interface IUserDAO {
    public User save(User u);
    public List<User> userByUsername(String username);
    public List<User> ListUsers();
    public User getUser(String username);
    public User updateUser(User u);
    public void deleteUser(String username);
}
