/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mscrpt;

/**
 *
 * @author willharris
 */
public class Integer extends RealNumber {
        
    public final int value;

    public Integer (int value) {
        this.value = value;
    }

    @Override
    public final String toString () {
        return java.lang.Integer.toString(value);
    }
    
    @Override
    public final Number add (Number other) {
        if (other == null) throw new NullPointerException("Parameter 'other'"
                + "was null when passed.");
        
        if (other instanceof Integer) {
            Integer castedOther = (Integer)other;
            
            return new Integer(this.value + castedOther.value);
        } 
        else return other.add(this);
    }
    
    @Override
    public final Integer opposite () {
        return new Integer(value * -1);
    }
    
    @Override
    public final Number multiply (Number other) {
        
        if (other == null) throw new NullPointerException("Parameter 'other'"
                + "was null when passed.");
        
        if (other instanceof Number) {
            Integer castedOther = (Integer)other;
            
            return new Integer(this.value * castedOther.value);
        } 
        else return other.multiply(this);
    }
    
    @Override
    public final Number divide (Number other) {
        if (other == null) throw new NullPointerException("Parameter 'other'"
                + "was null when passed.");
        
        if (other instanceof Number) {
            Integer castedOther = (Integer)other;
            
            return new Integer(this.value / castedOther.value);
        }
        else return other.divide(this);
    }
    
    @Override
    public final Number simplify () {
        
        // Integers are already in simplest form!
        return this;
    }
    
    @Override
    public final boolean equals (Object other) {
        if (other == null) return false;
        
        if (other instanceof Integer) {
            Integer castedOther = (Integer)other;
            
            return this.value == castedOther.value;
            
        } else return false;
    }
    
    @Override
    public final int hashCode () {
        return value;
    }
    
    @Override
    public final String regex () {
        return "/[0-9]+/";
    }
    
    @Override
    public final double toDecimal () {
        return value;
    }
}
