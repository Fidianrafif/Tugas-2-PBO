/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;

import java.util.List;
import model.*;

/**
 *
 * @author lenovo
 */
public interface movie_dbimplement {

    public void insert(movie_db p);
    public void update(movie_db p);
    public void delete(int id);
    public List<movie_db> getAll();
    
}
