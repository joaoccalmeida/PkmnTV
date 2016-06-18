// Licensed under GPLv2 or any later version
// Refer to the license.txt file included.
package pkmntv.logic;

import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author João
 */
public class PkmnForms {
    
    
    private static final Map<String, List<String>> PKMN_FORM_TYPE_MAP;
    static {
        Map<String, List<String>> aMap = new HashMap<>();
            aMap.put("castform",   ImmutableList.of("sunny", "rainy", "snowy"));
            aMap.put("wormadam",   ImmutableList.of("sandy", "trash"));
            aMap.put("rotom",      ImmutableList.of("heat", "frost", "fan", "mow"));
            aMap.put("shaymin",    ImmutableList.of("sky"));
            aMap.put("darmanitan", ImmutableList.of("zen"));
            aMap.put("meloetta",   ImmutableList.of("pirouette"));
            aMap.put("hoopa",      ImmutableList.of("unbound"));
            aMap.put("arceus",     ImmutableList.of("fighting", "flying", "poison",
                                        "ground", "rock", "bug", "ghost", "steel",
                                        "fire", "water", "grass", "electric",
                                        "psychic", "ice", "dragon", "dark", "fairy")
            );
         PKMN_FORM_TYPE_MAP = aMap;   
    }
    
    public static boolean hasSpecialFormes(String name){
        return PKMN_FORM_TYPE_MAP.containsKey(name);
    }
    
    public static List<String> getForms(String name){
        return PKMN_FORM_TYPE_MAP.get(name);
    }
}
