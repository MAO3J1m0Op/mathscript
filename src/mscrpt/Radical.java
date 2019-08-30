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
public class Radical extends RealNumber {
    
    /**
     * The outside number, or coefficient of the Radical.
     */
    public final Number out;
    /**
     * The inside number, or actual number being square-rooted.
     */
    public final Number in;
    
    /**
     * Creates a radical with just the number inside.
     * @param in the number inside the radical sign.
     */
    public Radical (Number in) {
        this.out = Number.ONE;
        this.in = in;
    }
    
    public Radical (Number out, Number in) {
        this.out = out;
        this.in = in;
    }
    
    @Override
    public Number add (Number other) {
        throw new UnsupportedOperationException(); // TODO
    }
    
    @Override
    public Number multiply (Number other) {
        
        if (other instanceof Radical) {
            Radical castedOther = (Radical)other;
            
            return new Radical(
                    in.multiply(castedOther.in),
                    out.multiply(castedOther.out)
            );
            
        } else {
            return new Radical(in.multiply(other), out);
        }
    }
    
    @Override
    public Number simplify () {
        throw new UnsupportedOperationException(); // TODO
    }
    
    @Override
    public boolean equals (Object other) {
        if (other == null) return false;
        
        if (other instanceof Radical) {
            Radical castedOther = (Radical)other;
            
            return (this.out == castedOther.out &&
                    this.in == castedOther.in);
            
            
        } else return false;
    }
    
    @Override
    public int hashCode () {
        return out.hashCode() * (int)Math.sqrt(in.hashCode());
    }
    
    @Override
    public String regex () {
        return "/.+\\*?√.+/";
    }
    
    @Override
    public String toString () {
        return out + "√" + in;
    }
    
    @Override
    public double toDecimal () {
        
        if (!(out instanceof RealNumber && in instanceof RealNumber)) {
            throw new IllegalArgumentException("Cannot convert a Radical with "
                    + "nonreal components to a decimal.");
        }
        
        return ((RealNumber)out).toDecimal() / ((RealNumber)in).toDecimal();
    }
}
