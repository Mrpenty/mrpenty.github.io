/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MyMethod;
import model.Slider;

/**
 *
 * @author dclon
 */
public class SliderDAO extends BaseDAO<Slider> {

    @Override
    public ArrayList<Slider> getAll() {
        ArrayList<Slider> sliders = new ArrayList<>();
        try {
            String sql = "SELECT id, album_ID, heading, text\n"
                    + "FROM Slider ";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AlbumDAO ad = new AlbumDAO();
                Slider s = new Slider();
                s.setId(rs.getInt("id"));
                s.setAlbum(ad.getAlbumByID(rs.getInt("album_ID")));
                s.setHeading(rs.getString("heading"));
                s.setText(rs.getString("text"));
                sliders.add(s);
            }
        } catch (Exception e) {
        }
        return sliders;
    }

}
