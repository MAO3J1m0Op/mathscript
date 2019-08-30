/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mscrpt;

import java.util.Objects;

/**
 * Represents a constant value.
 * @author willharris
 */
public final class Constant {
    
    /**
     * The value of the actual constant.
     */
    public final double value;
    
    /**
     * The symbol that represents this constant.
     */
    public final String symbol;
    
    public Constant (double value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int)(Double.doubleToLongBits(this.value) ^ 
                (Double.doubleToLongBits(this.value) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.symbol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        
        if (obj instanceof Constant) {
            Constant castedOther = (Constant)obj;
            
            return value == castedOther.value &&
                   symbol.equals(castedOther.symbol);
        }
        
        return false;
    }
}
