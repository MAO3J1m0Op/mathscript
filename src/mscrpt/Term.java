/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mscrpt;

import java.util.HashMap;

/**
 * Represents a term with several values.
 * @author willharris
 */
public class Term extends Number {
    
    /**
     * The coefficient; the number that is not attached to a term.
     */
    public final Number coefficient;
    
    /**
     * The variables attached to this instance.
     */
    private final HashMap<String, Integer> vars;
    
    public Term (HashMap<String, Integer> variables) {
        this.vars = variables;
        this.coefficient = ONE;
    }
    
    public Term (Number coefficient, HashMap<String, Integer> variables) {
        this.vars = variables;
        this.coefficient = coefficient;
    }
    
    /**
     * @return a copy of the variable HashMap.
     */
    public HashMap<String, Integer> getVariables () {
        HashMap<String, Integer> value = new HashMap<>();
        
        vars.keySet().forEach((str) -> {
            value.put(str, vars.get(str));
        });
        
        return value;
    }
    
    public Number plug (String var, Number value) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public Number add(Number other) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public Number multiply(Number other) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public Number simplify() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public String regex() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException(); // TODO
    }
    
}
