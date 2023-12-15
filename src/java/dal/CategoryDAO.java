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
import model.Category;
import model.Role;

/**
 *
 * @author dclon
 */
public class CategoryDAO extends BaseDAO<Category> {

    @Override
    public ArrayList<Category> getAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT id, name\n"
                    + "FROM Category";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                int id = rs.getInt("id");
                c.setId(id);
                c.setName(rs.getString("name"));
                c.setTotal_Album(getTotal_Album(id));
                c.setTotal_Liked(getTotal_Liked(id));
                c.setTotal_User(getTotal_User(id));
                categories.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public int getTotal_Album(int category_ID) {
        try {
            String sql = "SELECT count(*) AS total_Album\n"
                    + "FROM Albums \n"
                    + "WHERE Albums.category_ID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_ID);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt("total_Album");
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotal_Liked(int category_ID) {
        try {
            String sql = "WITH t AS (\n"
                    + "	SELECT Albums.category_ID, COUNT(liked.id) AS total_Like\n"
                    + "	FROM Albums left join liked ON Albums.id = liked.album_ID\n"
                    + "	GROUP BY Albums.category_ID\n"
                    + ")\n"
                    + "SELECT total_Like\n"
                    + "FROM t\n"
                    + "WHERE t.category_ID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_ID);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt("total_Like");
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotal_User(int category_ID) {
        try {
            String sql = "WITH t AS (\n"
                    + "	SELECT user_ID, COUNT(liked.id) as totalLiked\n"
                    + "	FROM Albums join liked ON Albums.id = liked.album_ID and Albums.category_ID = ?\n"
                    + "	GROUP BY liked.user_ID\n"
                    + ")\n"
                    + "SELECT COUNT(*) AS total_User\n"
                    + "FROM t";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_ID);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt("total_User");
        } catch (Exception e) {
        }
        return 0;
    }

}
