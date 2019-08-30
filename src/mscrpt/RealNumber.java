/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mscrpt;

/**
 * Indicates that the implementing type is a real number, and can be converted
 * to an (approximate) decimal. Real numbers can be compared with other real
 * numbers, and can be graphed.
 * @author willharris
 */
public abstract class RealNumber extends Number implements Comparable<Double> {
    /**
     * Returns an approximation of the value in a decimal form.
     * @return see above.
     */
    public abstract double toDecimal();
    
    @Override
    public int compareTo(Double other) {
        return new Double(this.toDecimal()).compareTo(other);
    }
}
