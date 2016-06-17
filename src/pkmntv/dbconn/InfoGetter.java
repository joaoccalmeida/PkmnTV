// Licensed under GPLv2 or any later version
// Refer to the license.txt file included.

package pkmntv.dbconn;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.jdbcx.JdbcConnectionPool;
import pkmntv.logic.Pokemon;
import pkmntv.logic.TypeEffect;

/**
 *
 * @author João
 */
public class InfoGetter {
    
    private final JdbcConnectionPool cp;
    
    /*
        Get the embeded database inside the .jar file
    */
    public InfoGetter(){
        String url = getClass().getClassLoader().getResource("resources/database/PkmnType.h2.db").getPath();
        // url = file:/G:/Project/PkmnTV/dist/run1967337433/PkmnTV.jar!/resources/database/PkmnType.h2.db
        
        /* 
            To remove the "file:" and ".h2.db" substrings. Because the url 
                turns spaces into "%20" notation, is used the replace method.
        */
        String path = url.substring(5, url.length()-6).replaceAll("%20", " "); 
        cp = JdbcConnectionPool.create("jdbc:h2:zip:" + path, "sa", "");
    }
    
    public Pokemon getPkmnInfo(String name){
        Pokemon pkmn = null;
        try {
            Connection conn = cp.getConnection();
            ResultSet rs;
            try (PreparedStatement prepSt = conn.prepareStatement("SELECT PKMNTYPE FROM PKMNTYPE WHERE PKMNNAME=?")) {
                prepSt.setString(1, name);
                rs = prepSt.executeQuery();
                if(!rs.next()){
                    closeResources(rs, conn);
                    return null;
                }   
                
                String type1 = rs.getString(1);
                String type2 = rs.next() ? rs.getString(1) : null;
                pkmn = new Pokemon(name, type1, type2);
            }
            closeResources(rs, conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(InfoGetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pkmn;
    }
    
    public boolean getPkmnTypeEffect(String type1, String type2){
        try {
            Connection conn = cp.getConnection();
            ResultSet rs;
            try (PreparedStatement prepSt = conn.prepareStatement("SELECT MOVETYPE, EFFECTIVNESSFACTOR FROM TYPEEFFECT WHERE PKMNTYPE=? OR PKMNTYPE=?")) {
                prepSt.setString(1, type1);
                prepSt.setString(2, type2);
                rs = prepSt.executeQuery();
                while(rs.next()){
                    TypeEffect.setValue(rs.getString(1), rs.getDouble(2));
                }
            }
            closeResources(rs, conn);
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(InfoGetter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    
    private static void closeResources(ResultSet rs, Connection conn) throws SQLException{
        rs.close();
        conn.close();
    }
}
