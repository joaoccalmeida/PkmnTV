// Licensed under GPLv2 or any later version
// Refer to the license.txt file included.

package pkmntv.logic;

/**
 *
 * @author João
 */
public class Pokemon {
    
    private final String name;
    private final String type1, type2;
    
    public Pokemon(String name, String type1, String type2){
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
    }
    
    public String getFirstType(){
        return type1;
    }
    
    public String getSecondType(){
        return type2;
    }
    
    public String getName(){
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
