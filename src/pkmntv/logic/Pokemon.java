/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmntv.logic;

/**
 *
 * @author João
 */
public class Pokemon {
    
    //private int id;
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
        return name;
    }
}
