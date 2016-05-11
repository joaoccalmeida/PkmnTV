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
    
    private Map<String, Double> typeMap;
    public final Double NORMAL_FACTOR = 1.0;
    public final Double IMMUNE_FACTOR = 0.0;
    
    public TypeEffect(){
        typeMap = new HashMap();
        fillTypeMap();
    }
    
    private void fillTypeMap(){
      typeMap.put("normal",   NORMAL_FACTOR); 
      typeMap.put("fighting", NORMAL_FACTOR);
      typeMap.put("flying",   NORMAL_FACTOR);
      typeMap.put("poison",   NORMAL_FACTOR);
      typeMap.put("ground",   NORMAL_FACTOR);
      typeMap.put("rock",     NORMAL_FACTOR);
      typeMap.put("bug",      NORMAL_FACTOR);
      typeMap.put("ghost",    NORMAL_FACTOR);
      typeMap.put("steel",    NORMAL_FACTOR);
      typeMap.put("fire",     NORMAL_FACTOR);
      typeMap.put("water",    NORMAL_FACTOR);
      typeMap.put("grass",    NORMAL_FACTOR);
      typeMap.put("electric", NORMAL_FACTOR);
      typeMap.put("psychic",  NORMAL_FACTOR);
      typeMap.put("ice",      NORMAL_FACTOR);
      typeMap.put("dragon",   NORMAL_FACTOR);
      typeMap.put("dark",     NORMAL_FACTOR);
      typeMap.put("fairy",    NORMAL_FACTOR);
    }
    
    public void resetTypeMap(){
        typeMap.replaceAll((k,v) -> v = NORMAL_FACTOR);
    }
    
    public void setValue(String type, Double value){
        typeMap.replace(type, this.getValue(type)*value);
    }
    
    public Map<String, Double> getMap(){
        return typeMap;
    }
    
    private Double getValue(String type){
        return typeMap.get(type);
    }
}
