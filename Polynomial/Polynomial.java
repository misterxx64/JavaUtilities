/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author cristy
 */
public class Polynomial {

    private Polinomio termini;

    public Polynomial(Polinomio termini) {
        this.termini = termini;
        fillTheGaps();
        this.termini.sort((Termine e1, Termine e2) -> {
            if (e1.getExp() < e2.getExp()) {
                return 1;
            } else {
                return -1;
            }
        });

        //for(int i=0;i<this.termini.size();i++)
        //   System.out.println(this.termini.get(i).toString());
    }
    
    public Polynomial prodotto(Polynomial p){
        Polinomio newPoli = new Polinomio();
        for(int i=0;i<termini.size();i++){
            int oneExp = termini.get(i).getExp();
            int oneCoeff = termini.get(i).getCoeff();
            for(int k=0;k<p.termini.size();k++){
                Termine newTerm = new Termine(oneExp + p.termini.get(k).getExp(),oneCoeff* p.termini.get(k).getCoeff());
                newPoli.add(newTerm);
            }
        }
        return new Polynomial(newPoli);
    }

    public Polynomial somma(Polynomial p) {
        Polinomio newPoli = new Polinomio();
        Polinomio biggest;
        Polinomio lowest;
        if (this.termini.size() > p.termini.size()) {
            biggest = this.termini;
            lowest = p.termini;

        } else {
            biggest = p.termini;
            lowest = this.termini;
        }

        for (int i = 0; i < biggest.size(); i++) {
            int mioExp = biggest.get(i).getExp();
            int mioCoeff = biggest.get(i).getCoeff();
            int suoIndice = p.ricerca(mioExp);
            if (suoIndice >= 0) {
                newPoli.add(new Termine(mioExp, mioCoeff + lowest.get(suoIndice).getCoeff()));
                // System.out.println("Sommo "+mioCoeff + " e " + lowest.get(suoIndice).getCoeff());
            } else {
                newPoli.add(new Termine(mioExp, mioCoeff));
                //System.out.println("Sommo "+mioCoeff + " e " + 0);

            }
        }

        return new Polynomial(newPoli);
    }

    private int ricerca(int exp) {
        for (int i = 0; i < this.termini.size(); i++) {
            if (termini.get(i).getExp() == exp) {
                return i;
            }
        }

        return -1;
    }

    private void fillTheGaps() {
        int maxExp = termini.get(0).getExp();
        int nextExp = 0;

        for (int i = 0; i < maxExp; i++, nextExp++) {
            if (termini.get(i).getExp() != nextExp) {
                termini.add(i, new Termine(nextExp, 0));
            }
        }

    }

    public Polynomial derivata() {
        Polinomio newTerms = new Polinomio();
        for (int i = 0; i < this.termini.size(); i++) {
            int exp = this.termini.get(i).getExp();
            int coeff = this.termini.get(i).getCoeff();
            int newCoeff = (exp) * coeff;
            int newExp = exp - 1;
            Termine derivato = new Termine(newExp, newCoeff);
            newTerms.add(derivato);
        }
        return new Polynomial(newTerms);

    }

    @Override
    public String toString() {
        String s = "Polynomial{ ";
        for (int i = 0; i < termini.size(); i++) {
            int coeff = termini.get(i).getCoeff();
            int exp = termini.get(i).getExp();
            if (coeff != 0 && exp != 0) {
                if (coeff > 0 && i != 0) {
                    s += "+" + coeff + "x^" + exp;
                } else if (i != 0) {
                    s += coeff + "x^" + exp;
                }

                if (coeff > 0 && i == 0) {
                    s += coeff + "x^" + exp;
                } else if (i == 0) {
                    s += coeff + "x^" + exp;
                }
            }
            
            if (coeff != 0 && exp == 0) {
                if (coeff > 0 && i != 0) {
                    s += "+" + coeff;
                } else if (i != 0) {
                    s += coeff ;
                }

                if (coeff > 0 && i == 0) {
                    s += coeff ;
                } else if (i == 0) {
                    s += coeff;
                }
            }
        }
        return s + " }";
    }

    public static void main(String args[]) {
        Polinomio termini = new Polinomio();
        termini.add(new Termine(2, 3));
        termini.add(new Termine(4,1));
        Polynomial poli = new Polynomial(termini);
        
        Polinomio termini1 = new Polinomio();
        termini1.add(new Termine(2, 3));
        termini1.add(new Termine(-4, 3));
        Polynomial poli1 = new Polynomial(termini1);

        System.out.println(poli.toString());
        System.out.println(poli1.toString());
        
       
    }

}
