// Licensed under GPLv2 or any later version
// Refer to the license.txt file included.

package pkmntv.logic;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author João
 */
public class TypeEffect {
    
    private static final Double NORMAL_FACTOR = 1.0;
    private static final Double IMMUNE_FACTOR = 0.0;
    private static final List<Double> WEAK_FACTORS = ImmutableList.of(2.0, 4.0);
    private static final List<Double> RESISTANCE_FACTORS = ImmutableList.of(0.5, 0.25);
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
    
    private static Double getValue(String type){
        return TYPE_MAP.get(type);
    }
    
    public static Map getNormalEffectMap(){
        return Maps.filterValues(TYPE_MAP, Predicates.equalTo(NORMAL_FACTOR));
    }
    
    public static Map getWeakEffectMap(){
        return Maps.filterValues(TYPE_MAP, Predicates.in(WEAK_FACTORS));
    }
    
    public static Map getImmuneEffectMap(){
        return Maps.filterValues(TYPE_MAP, Predicates.equalTo(IMMUNE_FACTOR));
    }
    
    public static Map getResistantEffectMap(){
        return Maps.filterValues(TYPE_MAP, Predicates.in(RESISTANCE_FACTORS));
    }
}
