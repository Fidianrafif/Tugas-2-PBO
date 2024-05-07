/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author lenovo
 */
public class modeltabelmovie_db extends AbstractTableModel{

    List<movie_db> dp;
    public modeltabelmovie_db(List<movie_db>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "JUDUL";
            case 2:
                return "ALUR";
            case 3:
                return "PENOKOHAN";
            case 4:
                return "AKTING";
            case 5:
                return "NILAI";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getjudul();
            case 2:
                return dp.get(row).getalur();
            case 3:
                return dp.get(row).getpenokohan();
            case 4:
                return dp.get(row).getakting();
            case 5:
                return dp.get(row).getnilai();
            default:
                return null;
        }
    }
    
}
