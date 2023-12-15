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
import model.Background;

/**
 *
 * @author dclon
 */
public class BackgroundDAO extends BaseDAO<Background> {

    @Override
    public ArrayList<Background> getAll() {
        ArrayList<Background> bgs = new ArrayList<>();
        try {
            String sql = "SELECT id, name, path\n"
                    + "FROM Background";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Background bg = new Background();
                bg.setId(rs.getInt("id"));
                bg.setName(rs.getString("name"));
                bg.setPath(rs.getString("path"));
                bgs.add(bg);
            }
        } catch (SQLException ex) {
        }
        return bgs;
    }

}
