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
public class Infinity extends Number {
    /**
     * CODE: Use + for positive infinity, - for negative infinity, and * for
     * NaN.
     */
    private final char inf;
    private Infinity (char inf) {
        
        assert inf == '*' || inf == '+' || inf == '-';
        
        this.inf = inf;
    }
    
    /**
     * Represents positive infinity.
     */
    static final Infinity INFINITY = new Infinity('+');
    
    /**
     * Represents negative infinity.
     */
    static final Infinity NEGATIVE_INFINITY = new Infinity('-');
    
    /**
     * Represents NaN.
     */
    static final Infinity NaN = new Infinity('*');

    @Override
    public Number add(Number other) {
        
        if (other instanceof Infinity) {
            if (this.equals(INFINITY) && other.equals(NEGATIVE_INFINITY)) {
                return NaN;
            }
            
            if (this.equals(NEGATIVE_INFINITY) && other.equals(INFINITY)) {
                return NaN;
            }
        }
        
        // Adding to an infinity changes nothing.
        return this;
        
    }

    @Override
    public Number multiply(Number other) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        
        if (other instanceof Infinity) {
            Infinity castedOther = (Infinity)other;
            
            return this.inf == castedOther.inf;
            
        } else return false;
    }

    @Override
    public int hashCode() {
        if (equals(INFINITY)) return java.lang.Integer.MAX_VALUE;
        if (equals(NEGATIVE_INFINITY)) return java.lang.Integer.MIN_VALUE;
        return -1; // NaN
    }

    @Override
    public Number simplify() {
        
        // Infinity instances cannot be simplified.
        return this;
    }
    
    @Override
    public Number divide(Number exp) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public String regex() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public String toString() {
        
        switch (inf) {
            case '+':
                return "infinity";
            case '-':
                return "-infinity";
            case '*':
                return "NaN";
            default:
                throw new IllegalArgumentException("This shouldn't ever "
                        + "happen. Encapsulation has been broken.");
        }
    }
}
