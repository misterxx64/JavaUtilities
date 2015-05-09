/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import java.util.Comparator;

/**
 *
 * @author cristy
 */
public class Termine implements Comparable<Termine> {

    private int exp;
    private int coeff;

    public Termine(int exp, int coeff) {
        this.exp = exp;
        this.coeff = coeff;
    }

    public int getExp() {
        return exp;
    }

    public int getCoeff() {
        return coeff;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.exp;
        hash = 47 * hash + this.coeff;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Termine other = (Termine) obj;

        return compareTo(other) == 0;
    }

    @Override
    public String toString() {
        return "Termine{" + "exp=" + exp + ", coeff=" + coeff + '}';
    }

    @Override
    public int compareTo(Termine o) {
        if (o.exp == this.exp) {
            return 0;
        }
        if (o.exp < this.exp) {
            return -1;
        }
        return 1;
    }

    

}
