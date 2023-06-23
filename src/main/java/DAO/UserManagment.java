package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagment implements IUserDAO{

    static Connection conn = SingletonConnection.getConnection();
    @Override
    public User save(User u) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES (?,?,?) ;");
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPassword());
            ps.setBoolean(3,u.isAdmin());
            ps.executeUpdate();
            ps.close();
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> userByUsername(String username) {
        List<User> UL = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username LIKE ? ;");
            ps.setString(1,"%"+username+"%");
            ResultSet RS = ps.executeQuery();
            while (RS.next()){
                UL.add(new User(RS.getString("username"),RS.getString("password"),RS.getBoolean("admin")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UL;
    }

    @Override
    public List<User> ListUsers() {
        List<User> UL = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user;");
            ResultSet RS = ps.executeQuery();
            while (RS.next()){
                UL.add(new User(RS.getString("username"),RS.getString("password"),RS.getBoolean("admin")));
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return UL;
    }

    @Override
    public User getUser(String username) {
        User U = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username = ? ;");
            ps.setString(1,username);
            ResultSet RS = ps.executeQuery();
            while (RS.next()){
                U = new User(RS.getString("username"),RS.getString("password"),RS.getBoolean("admin"));
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return U;
    }

    @Override
    public User updateUser(User u) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE user SET password = ? WHERE username = ?");
            ps.setString(1,u.getPassword());
            ps.setString(2,u.getUsername());
            int RS = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public void deleteUser(String username) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE username = ?");

            ps.setString(1,username);
            int RS = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
