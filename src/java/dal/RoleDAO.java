/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

/**
 *
 * @author dclon
 */
public class RoleDAO extends BaseDAO<Role> {

    @Override
    public ArrayList<Role> getAll() {
        ArrayList<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT id, name\n"
                    + "FROM Roles";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                roles.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    public String getRoleName(int role_ID) {
        try {
            String sql = "select name\n"
                    + "FROM Roles\n"
                    + "WHERE id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role_ID);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getString("name");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
