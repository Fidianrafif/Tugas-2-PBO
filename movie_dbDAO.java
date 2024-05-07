/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOmovie_db;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.movie_dbimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lenovo
 */
public class movie_dbDAO implements movie_dbimplement{
    Connection connection;
    
    final String select = "select * from movie_db;";
    final String insert = "INSERT INTO movie_Db (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "update movie_db set judul=?, alur=?, penokohan=?, akting=?, nilai=? where id=?";
    final String delete = "delete from movie_db set judul=?, alur=?, penokohan=?, akting=?, nilai=? where id=?";
    public movie_dbDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(movie_db p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getjudul());
            statement.setString(2, p.getalur());
            statement.setString(3, p.getpenokohan());
            statement.setString(4, p.getakting());
            statement.setInt(5, p.getnilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(movie_db p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getjudul());
            statement.setString(2, p.getalur());
            statement.setString(3, p.getpenokohan());
            statement.setString(4, p.getakting());
            statement.setInt(5, p.getnilai());
            statement.setInt(6, p.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<movie_db> getAll() {
        List<movie_db> dp = null;
        try{
            dp = new ArrayList<movie_db>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                movie_db hp = new movie_db();
                hp.setId(rs.getInt("id"));
                hp.setjudul(rs.getString("judul"));
                hp.setalur(rs.getString("alur"));
                hp.setpenokohan(rs.getString("penokohan"));
                hp.setakting(rs.getString("akting"));
                hp.setnilai(rs.getInt("nilai"));
                dp.add(hp);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(movie_dbDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dp;
    }
}
