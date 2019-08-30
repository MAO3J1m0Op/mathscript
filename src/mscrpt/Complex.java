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
public class Complex extends Number {
    /**
     * The real part of the Complex number.
     */
    public final Number real;
    /**
     * The imaginary (i) part of the Complex number.
     */
    public final Number imag;
    
    public Complex(Number real, Number imag) {
        this.real = real;
        this.imag = imag;
    }
    
    @Override
    public Complex add (Number other) {
        if (other == null) throw new NullPointerException("Parameter 'other'"
                + "was null when passed.");
        
        if (other instanceof Complex) {
            Complex castedOther = (Complex)other;
            
            return new Complex(
                    this.real.add(castedOther.real), 
                    this.imag.add(castedOther.imag)
            );
        } else return new Complex(
                    this.real.add(other),
                    this.imag.add(other)
        );
    }
    
    @Override
    public Complex multiply (Number other) {
        if (other == null) throw new NullPointerException("Parameter 'other'"
                + "was null when passed.");
        
        if (other instanceof Complex) {
            Complex castedOther = (Complex)other;
            
            // FOIL
            Number f = this.real.multiply(castedOther.real); // Real
            Number o = this.real.multiply(castedOther.imag); // Imag
            Number i = this.imag.multiply(castedOther.real); // Imag
            Number l = this.imag.multiply(castedOther.imag); // Real, i^2=-1
            return new Complex(f.subtract(l), o.add(i));
            
        } else return new Complex(
                    this.real.multiply(other),
                    this.imag.multiply(other)
        );
    }
    
    @Override
    public Number divide (Number other) {
        throw new UnsupportedOperationException(); // TODO
    }
    
    @Override
    public boolean equals (Object other) {
        if (other == null) return false;
        
        if (other instanceof Complex) {
            Complex castedOther = (Complex)other;
            
            return this.real.equals(castedOther.real) &&
                   this.imag.equals(castedOther.imag);
            
        } else return false;
    }
    
    @Override
    public int hashCode () {
        return real.hashCode() * imag.hashCode() * 17;
    }
    
    @Override
    public Number simplify () {
        
        // Simplifies each piece.
        Complex newThis = new Complex(real.simplify(), imag.simplify());
        
        // If the Complex number has no imaginary parts, then we can remove
        // the complex part.
        if (newThis.imag.equals(Number.ZERO)) {
            return newThis.real;
        }
        
        // If both parts are fractions, let's convert this complex into a
        // fraction.
        if (newThis.real instanceof Fraction && 
                newThis.imag instanceof Fraction) {
            
            Fraction castedImag = (Fraction)newThis.imag;
            return real.add(new Fraction(
                    castedImag.num.multiply(Number.I), castedImag.den)
            ).simplify();
        }
        
        return newThis;
    }
    
    @Override
    public String regex () {
        return "/.+ ?\\+ ?.+i/";
    }
    
    @Override
    public String toString () {
        return real + " + " + imag + "i";
    }
}
