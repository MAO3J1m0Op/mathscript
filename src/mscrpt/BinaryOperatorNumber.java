/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mscrpt;

/**
 * Functional interface for a binary operator that takes two Numbers as input
 * and returns a Number.
 * @author willharris
 */
@FunctionalInterface
public interface BinaryOperatorNumber {
    public Number operate(Number left, Number right);
}
