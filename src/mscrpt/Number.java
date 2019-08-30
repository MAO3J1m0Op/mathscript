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
public abstract class Number {
    
    // Constants
    /**
     * Represents one as an Integer.
     */
    public static final Integer ONE = new Integer(1);
    /**
     * Represents zero as an Integer.
     */
    public static final Integer ZERO = new Integer(0);
    /**
     * Represents negative one as an Integer.
     */
    public static final Integer MINUS_ONE = new Integer(-1);
    /**
     * Represents the square root of -1, i, as a Complex number.
     */
    public static final Complex I = new Complex(ZERO, ONE);
    
    /**
     * Represents positive infinity.
     */
    public static final Infinity INFINITY = Infinity.INFINITY;
    
    /**
     * Represents negative infinity.
     */
    public static final Infinity NEGATIVE_INFINITY = Infinity.NEGATIVE_INFINITY;
    
    /**
     * Represents NaN.
     */
    public static final Infinity NaN = Infinity.NaN;
    
    /**
     * Adds a number to this instance and returns the sum.
     * @param other the other number to add to this instance.
     * @return a new instance representing the sum of this instance and the
     * other provided instance.
     */
    public abstract Number add(Number other);
    
    /**
     * Returns the mathematical opposite of this number. By default, this is 
     * done with the following code:
     * <code>
     *   return multiply(MINUS_ONE);
     * </code>
     * @return a new instance representing the mathematical opposite of this
     * number.
     */
    public Number opposite () {
        return multiply(MINUS_ONE);
    }
        
    public Number subtract (Number other) {
        return this.add(other.opposite());
    }

    /**
     * Multiplies a number by this instance and returns the product.
     * @param other the other number to multiply by this instance.
     * @return a new instance representing the product of this instance and the
     * other provided instance.
     */
    public abstract Number multiply(Number other);
    
    /**
     * Returns the mathematical reciprocal of this number. By default, this is 
     * done with the following code:
     * <code>
     *   return new Fraction(ONE, this);
     * </code>
     * @return a new instance representing the mathematical reciprocal of this
     * number.
     */
    public Number reciprocal () {
        return new Fraction(ONE, this);
    }

    public Number divide (Number other) {
        return this.multiply(other.reciprocal());
    }

    public Number toPower (Integer exp) {
        
        if (exp.equals(ZERO)) return toPower(exp.opposite());
        else {
            
            Number value = ONE;
            for (int n = 0; n < exp.value; ++n) value.multiply(this);
            return value;
        }
    }
    
    public final Number sqrt () {
        return new Radical(this).simplify();
    }
    
    @Override
    public abstract boolean equals(Object other);
    
    @Override
    public abstract int hashCode();
    
    /**
     * @return a Number instance equivalent to this Number instance.
     */
    public abstract Number simplify();
    
    /**
     * @return the regular expression, or regex, that is used to define the
     * formatting needed to create this type of Number.
     */
    public abstract String regex();

    /**
     * @return a string representation of this number.
     */
    @Override
    public abstract String toString();
}
