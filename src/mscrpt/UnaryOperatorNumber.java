/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mscrpt;

/**
 * Functional interface for a unary operator that takes a Number as input
 * and returns a Number.
 * @author willharris
 */
@FunctionalInterface
public interface UnaryOperatorNumber {
    public Number operate(Number x);
}
