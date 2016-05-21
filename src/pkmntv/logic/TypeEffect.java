/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmntv.logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author João
 */
public class TypeEffect {
    
    public static final Double NORMAL_FACTOR = 1.0;
    public static final Double IMMUNE_FACTOR = 0.0;
    private static final Map<String, Double> TYPE_MAP;
    static {
        Map<String, Double> aMap = new HashMap<>();
            aMap.put("normal",   NORMAL_FACTOR); 
            aMap.put("fighting", NORMAL_FACTOR);
            aMap.put("flying",   NORMAL_FACTOR);
            aMap.put("poison",   NORMAL_FACTOR);
            aMap.put("ground",   NORMAL_FACTOR);
            aMap.put("rock",     NORMAL_FACTOR);
            aMap.put("bug",      NORMAL_FACTOR);
            aMap.put("ghost",    NORMAL_FACTOR);
            aMap.put("steel",    NORMAL_FACTOR);
            aMap.put("fire",     NORMAL_FACTOR);
            aMap.put("water",    NORMAL_FACTOR);
            aMap.put("grass",    NORMAL_FACTOR);
            aMap.put("electric", NORMAL_FACTOR);
            aMap.put("psychic",  NORMAL_FACTOR);
            aMap.put("ice",      NORMAL_FACTOR);
            aMap.put("dragon",   NORMAL_FACTOR);
            aMap.put("dark",     NORMAL_FACTOR);
            aMap.put("fairy",    NORMAL_FACTOR);
            TYPE_MAP = aMap;
    }
    
    public static void resetTypeMap(){
        TYPE_MAP.replaceAll((k,v) -> v = NORMAL_FACTOR);
    }
    
    public static void setValue(String type, Double value){
        TYPE_MAP.replace(type, getValue(type)*value);
    }
    
    public static Map getMap(){
        return TYPE_MAP;
    }
    
    private static Double getValue(String type){
        return TYPE_MAP.get(type);
    }
}
