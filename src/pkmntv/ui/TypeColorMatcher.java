// Licensed under GPLv2 or any later version
// Refer to the license.txt file included.

package pkmntv.ui;

import com.google.common.collect.ImmutableMap;
import java.awt.Color;
/**
 *
 * @author João
 */
public class TypeColorMatcher {
    
    static final ImmutableMap<String, Color> TC_MAP = ImmutableMap.<String, Color>builder()
        .put("normal",   (new Color(168, 168, 120)))
        .put("fighting", (new Color(192,  48,  40)))
        .put("flying",   (new Color(168, 144, 240)))
        .put("poison",   (new Color(160,  64, 160)))
        .put("ground",   (new Color(224, 192, 104)))
        .put("rock",     (new Color(184, 160,  56)))
        .put("bug",      (new Color(168, 184,  32)))
        .put("ghost",    (new Color(112,  88, 152)))
        .put("steel",    (new Color(184, 184, 208)))
        .put("fire",     (new Color(240, 128,  48)))
        .put("water",    (new Color(104, 144, 240)))
        .put("grass",   (new Color(120, 200,  80)))
        .put("electric", (new Color(248, 208,  48)))
        .put("psychic",  (new Color(248,  88, 136)))
        .put("ice",      (new Color(152, 216, 216)))
        .put("dragon",   (new Color(112,  56, 248)))
        .put("dark",     (new Color(112,  88,  72)))
        .put("fairy",    (new Color(238, 153, 172)))
    .build();
}
