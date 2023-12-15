/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author dclon
 */
public class UserDAO extends BaseDAO<User> {

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT id, username, password, first_name, last_name, "
                    + "avatar, role_ID,   email\n"
                    + "FROM Users";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            try {
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setFirs_name(rs.getString("first_name"));
                    u.setLast_name(rs.getString("last_name"));
                    u.setAvatar(rs.getString("avatar"));
                    u.setRole_id(rs.getInt("role_ID"));
                    u.setEmail(rs.getString("email"));
                    users.add(u);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        return users;
    }

    public User getAccountByUsername(String username) {
        User u = new User();
        try {
            String sql = "SELECT id, username, password, first_name, last_name, avatar, role_ID, email\n"
                    + "From Users\n"
                    + "WHERE [username] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setFirs_name(rs.getString("first_name"));
                u.setLast_name(rs.getString("last_name"));
                u.setAvatar(rs.getString("avatar"));
                u.setRole_id(rs.getInt("role_ID"));
                u.setEmail(rs.getString("email"));
                return u;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }

    public User getAccountByUsernameAndPassword(String username, String password) {
        User u = new User();
        try {
            String sql = "SELECT id, username, password, first_name, last_name, avatar, role_ID,  email\n"
                    + "From Users\n"
                    + "WHERE [username] = ? and [password] = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setFirs_name(rs.getString("first_name"));
                u.setLast_name(rs.getString("last_name"));
                u.setAvatar(rs.getString("avatar"));
                u.setRole_id(rs.getInt("role_ID"));
                u.setEmail(rs.getString("email"));
                return u;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }

    public void insertUser(User s) {
        try {
            String sql = "INSERT INTO Users(first_name,last_name,username, [password], role_ID, email)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
             st.setString(1, s.getFirs_name());
            st.setString(2, s.getLast_name());
            st.setString(3, s.getUsername());
            st.setString(4, s.getPassword());
            st.setInt(5, s.getRole_id());
            st.setString(6, s.getEmail());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateUser(User u) {
        try {
            String sql = "Update Users\n"
                    + "SET first_name = ?, last_name = ?, password = ?, email=?\n"
                    + "WHERE id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getFirs_name());
            st.setString(2, u.getLast_name());
            st.setString(3, u.getPassword());
            st.setString(4, u.getEmail());
            st.setInt(5, u.getId());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateUserToAdmin(int id) {
        try {
            String sql = "UPDATE Users\n"
                    + "set role_ID = 2\n"
                    + "where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

   

    
     public void deleteUser(int Uid) {
        try {
            String sql = "DELETE FROM dbo.Users WHERE [id] = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, Uid);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    


    public static void main(String[] args) {
        // Create a User object with updated data
        User user = new User();
        user.setId(1); // Set the ID of the user you want to update
        user.setFirs_name("Updated First Name");
        user.setLast_name("Updated Last Name");
        user.setPassword("updatedpassword");
        user.setEmail("updatedemail@example.com");

        // Create an instance of your UserDAO class
        UserDAO userDAO = new UserDAO();

        // Call the updateUser method with the User object
        userDAO.updateUser(user);
    }
}
