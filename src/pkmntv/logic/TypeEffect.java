/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmntv.logic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author João
 */
public class TypeEffect {
    
    private Map<String, Double> typeMap;
    
    public TypeEffect(){
        typeMap = new HashMap();
        fillTypeMap();
    }
    
    private void fillTypeMap(){
      typeMap.put("normal", 1.0); 
      typeMap.put("fighting", 1.0);
      typeMap.put("flying", 1.0);
      typeMap.put("poison", 1.0);
      typeMap.put("ground", 1.0);
      typeMap.put("rock", 1.0);
      typeMap.put("bug", 1.0);
      typeMap.put("ghost", 1.0);
      typeMap.put("steel", 1.0);
      typeMap.put("fire", 1.0);
      typeMap.put("water", 1.0);
      typeMap.put("grass", 1.0);
      typeMap.put("electric", 1.0);
      typeMap.put("psychic", 1.0);
      typeMap.put("ice", 1.0);
      typeMap.put("dragon", 1.0);
      typeMap.put("dark", 1.0);
      typeMap.put("fairy", 1.0);
    }
    
    public void resetTypeMap(){
        typeMap.replaceAll((k,v) -> v = 1.0);
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
    
    public <K, V extends Comparable<? super V>> Map<String, Double> sortByValue()
    {
        Map<String, Double> result = new LinkedHashMap<>();
        Stream<Map.Entry<String, Double>> st = typeMap.entrySet().stream();

        st.sorted( Map.Entry.comparingByValue() )
            .forEachOrdered( e -> result.put(e.getKey(), e.getValue()) );

        return result;
    }
}
