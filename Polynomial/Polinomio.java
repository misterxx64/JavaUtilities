/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author cristy
 */
public class Polinomio extends LinkedList<Termine> {
  
    @Override
    public Termine get(int i){
        ListIterator<Termine> iterator = this.listIterator();
        int k=0;
        Termine temp;
        while(iterator.hasNext()){
            temp = iterator.next();
            if (k==i)
                return temp;
            k++;
        }
        return null;
    }
    
    
}
