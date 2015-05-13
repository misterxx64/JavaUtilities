//
//  Insiemi.java
//  
//
//  Created by cristy on 13/05/15.
//
//
import java.util.*;

public class MioSet<E> extends HashSet<E>{
    
    public MioSet<E> intersezione(MioSet<E> d){
        MioSet<E> newSet = new MioSet<E>();
        Iterator<E> iterator = d.iterator();
        while(iterator.hasNext()){
            E temp = iterator.next();
            if (this.contains(temp)) newSet.add(temp);
        }
        
        return newSet;
    
    }
    
    public MioSet<E> unione(MioSet<E> d){
        
        MioSet<E> newSet = new MioSet<E>();
        Iterator<E> myIt = this.iterator();
        while(myIt.hasNext()){
            newSet.add(myIt.next());
        }
        Iterator<E> hisIt = d.iterator();
        while(hisIt.hasNext()){
            newSet.add(hisIt.next());
        }
        return newSet;
        
    }
    


}
