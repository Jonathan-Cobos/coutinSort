/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coutingsort;

import java.util.Iterator;

/**
 *
 * @author Acer
 */
public class CoutingSort{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int A[]=new int[7];
        Couting lista =new Couting(A);
        Iterator it=lista.iterator();
        A[0]=1;
        A[1]=3;
        A[2]=4;
        A[3]=3;
        A[4]=1;
        A[5]=5;
        A[6]=2;
        
        System.out.println("Lista desordenada");
         for (Object s : A) {
            System.out.println(s.toString());
        }
         //vemos si esta ordenada
         System.out.println("la lista esta ordenada? = " + lista.isSorted(A));
         
         //////////////
         System.out.println("Lista desordenadacon cambio");
        
        lista.exch(A, 0, 1);
        
        for (Object s : A) {
             
            System.out.println(s.toString());
        }
        System.out.println("la lista esta ordenada? = " + lista.isSorted(A));
////////
        lista.sort(A);
      
        System.out.println("lista ordenada ");
        
        while(it.hasNext()){
            System.out.println(it.next());
            
        }
        
      System.out.println("Usamos el less para comparar dos valores del arrelo y vemos si "
                + "el  de la izquierda es menor a la derecha sera true y si no false  ");
      
        System.out.println(lista.less(A[5], A[1]));
        System.out.println("la lista esta ordenada? = " + lista.isSorted(A));
    
    }
        
    }
    

