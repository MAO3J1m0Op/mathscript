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
public class Fraction extends RealNumber {
        
    /**
     * The numerator.
     */
    public final Number num;
    /**
     * The denominator.
     */
    public final Number den;

    public Fraction (Number num, Number den) {
        this.num = num;
        this.den = den;
    }
    
    @Override
    public Number add (Number other) {
        if (other == null) throw new NullPointerException("Parameter 'other'"
                + "was null when passed.");
        
        Fraction castedOther = other instanceof Fraction 
                ? (Fraction)other
                : new Fraction(other, ONE);
        
        // Create new fractions for multiplication
        Fraction newThis = new Fraction(this.num.multiply(castedOther.den),
                this.den.multiply(castedOther.den)
        );
        Fraction newOther = new Fraction(castedOther.num.multiply(this.den),
                castedOther.den.multiply(this.den)
        );
        
        // Add the new fractions since the denominators are the same
        assert newThis.den == newOther.den;
        return new Fraction(newThis.num.add(newOther.num), newThis.den);
    }
    
    @Override
    public Number multiply (Number other) {
        if (other == null) throw new NullPointerException("Parameter 'other'"
                + "was null when passed.");
        
        Fraction castedOther = other instanceof Fraction 
                ? (Fraction)other
                : new Fraction(other, ONE);
        
        return new Fraction(this.num.multiply(castedOther.num), 
                this.den.multiply(castedOther.den));
    }
    
    @Override
    public Fraction reciprocal () {
        return new Fraction(den, num);
    }
    
    @Override
    public Number divide (Number other) {
        return this.multiply(reciprocal());
    }
    
    @Override
    public Number simplify () {
        throw new UnsupportedOperationException(); // TODO
    }
    
    @Override
    public boolean equals (Object other) {
        if (other == null) return false;
        
        if (other instanceof Fraction) {
            Fraction castedOther = (Fraction)other;
            
            return this.num.equals(castedOther.num) &&
                   this.den.equals(castedOther.den);
            
        } else return false;
    }

    @Override
    public int hashCode() {
       return this.num.hashCode() / this.den.hashCode();
    }
    
    @Override
    public String regex () {
        return "/.+ ?\\/ ?.+/";
    }

    @Override
    public String toString () {
        return "(" + num + " / " + den + ")";
    }
    
    @Override
    public double toDecimal () {
        
        if (!(num instanceof RealNumber && den instanceof RealNumber)) {
            return Double.NaN;
        }
        
        return ((RealNumber)num).toDecimal() / ((RealNumber)den).toDecimal();
    }
}
