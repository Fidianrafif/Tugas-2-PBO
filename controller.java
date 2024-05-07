/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOmovie_db.movie_dbDAO;
import DAOImplement.movie_dbimplement;
import model.*;
import view.MainView;
/**
 *
 * @author lenovo
 */

public class controller {
    MainView frame;
    movie_dbimplement implmovie_db;
    List<movie_db> dp;
    
    public controller(MainView frame){
        this.frame = frame;
        movie_dbDAO movie_db = new movie_dbDAO();
        dp = implmovie_db.getAll();
    }
    public void isitabel(){
        dp = implmovie_db.getAll();
        modeltabelmovie_db mp = new modeltabelmovie_db(dp);
        frame.getTabelMovie().setModel(mp);
    }
    
    public void insert(){
        movie_db dp = new movie_db();
        dp.setjudul(frame.getJudul().getText());
        dp.setalur(frame.getAlur().getText());
        dp.setpenokohan(frame.getPenokohan().getText());
        dp.setakting(frame.getAkting().getText());
        dp.setnilai(Integer.valueOf(frame.getNilai().getText()));
        implmovie_db.insert(dp);
        
    }
    
    public void update(){
        movie_db dp = new movie_db();
        dp.setjudul(frame.getJudul().getText());
        dp.setalur(frame.getAlur().getText());
        dp.setpenokohan(frame.getPenokohan().getText());
        dp.setakting(frame.getAkting().getText());
        dp.setnilai(Integer.valueOf(frame.getNilai().getText()));
        dp.setId(Integer.valueOf(frame.getJudul().getText()));
        implmovie_db.update(dp);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJudul().getText());
        implmovie_db.delete(id);
    }
}
