/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmntv.dbconn;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkmntv.logic.Pokemon;
import pkmntv.logic.TypeEffect;

/**
 *
 * @author João
 */
public class InfoGetter {
    
    //private final String name;
    private static Connection conn;
    /*
    public InfoGetter(String name){
        this.name = name;
    }*/
    
    public static Pokemon getPkmnInfo(String name){
        Pokemon pkmn = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.
                    getConnection("jdbc:h2:file:./src/resources/PkmnType", "sa", "");
            
            PreparedStatement prepSt = conn.prepareStatement("SELECT PKMNTYPE FROM PKMNTYPE WHERE PKMNNAME=?");
            prepSt.setString(1, name);
            ResultSet rs = prepSt.executeQuery();
            
            if(!rs.next()){
                prepSt.close();
                rs.close();
                conn.close();
                return null;
            }
            String type1 = rs.getString(1);
            String type2 = rs.next() ? rs.getString(1) : null; 
            pkmn = new Pokemon(name, type1, type2);
            
            prepSt.close();
            rs.close();
            conn.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InfoGetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pkmn;
    }
    
    public static boolean getPkmnTypeEffect(String type1, String type2){
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.
                    getConnection("jdbc:h2:file:./src/resources/PkmnType", "sa", "");
            
            PreparedStatement prepSt = conn.prepareStatement("SELECT MOVETYPE, EFFECTIVNESSFACTOR FROM TYPEEFFECT WHERE PKMNTYPE=? OR PKMNTYPE=?");
            prepSt.setString(1, type1);
            prepSt.setString(2, type2);
            ResultSet rs = prepSt.executeQuery();
            
            while(rs.next()){
                TypeEffect.setValue(rs.getString(1), rs.getDouble(2));
            }
            
            prepSt.close();
            rs.close();
            conn.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InfoGetter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }  
}
