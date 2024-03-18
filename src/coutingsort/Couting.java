/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coutingsort;

import java.util.Iterator;

/**
 *
 * @author Acer
 */
public class Couting implements Iterable {
    /*
     public static int[] integerA(String[] a){
    int b[]=new int [a.length];   
         for (int i = 0; i < a.length; i++) {
          int x=Integer.parseInt(a[i]);
           b[i]=x;
        }
    return b;
    }*/
    
    int c[];
     
    public Couting(int[] a){
        this.c=a;
    }

    public static void sort(int[] a) {
        //definimos el valor maximo de "a" usando el metodo bus Max
        int max=busMax(a, a.length);
        //usaremos un arrelo auxiliar para almacenar los numeros para acomodarlos despues 
        int aux[]=new int[a.length];
        //con coun vamos a revizar la cantidad de veces que se repite el numero en el arrelo que usamos de parametro osea a 
        int count[]=new int[max+1];
        //estos dos int los usamos para almacenar los int sin que se pierdan y facilite el movimeinto de los mismos 
        int num,newNum,j;
        
        //vamos a ahcer que los valores del arrelo count sea 0 para inicializarlo 
        for (j = 0; j <= max; j++) {
            count[j]=0;   
        }
        //en esete ciclo for cuenta las veces que "n" numero se repite en el arrelo principal
        for (j = 0; j < a.length; j++) {
            num=a[j];
            /*ejemplo si j inicia en 0, en nuetro arrelo inicial es A[0]=1, en el arrelo num[1] sumara 1 las veces que se repita siendo que ahora 
            vale Cont[1]=1 y si en un caso ipotetico A[n] donde n>0 hay un uno ahora count[1]=2*/
            count[num]++; 
        }
        
        /*ahora tenemos que sumar los valores del arrelo count, esto lo hacemos sumando Count[n]+conut[n-1] (donde n>0)de forma continua 
        osea si count[0]=1 y count[1]=1 con la suma count[1]=2 ya qeu tenia un 1 atras */
        for (j = 1; j <= max; j++) {
            count[j]+=count[j-1];
        }
        //ahora con el arrelo auxiliar vamos a ir ordenando los numeros de mayor a menor 
        for (j = 0; j < a.length; j++) {
            num=a[j];
            
            newNum=count[num]-1;
        /*la resta se hace para ir decrementado el numero que teniamos en el arrelo de count osea el acomulado y asi saver en que posicion 
        devemos poner el arrelo euxiliar*/
        
            aux[newNum]=num;
            /*ahora recordemos que por cada n que ya pusimos si tenemos que restar 1 a count ya que con este vamos a ir uiando donde vamos a
            ubicar el mismo n si se repite*/
            count[num]--;
            
        }
        
        /*ahora solo nos queda remplazar los valores ya ordenados que tenemos en el aux al principal y listo, tendriamos la lista ordenada 
        de mayor a menor*/ 
        for (j = 0; j < a.length; j++) {
            a[j]=aux[j];
        }
    }
   
    //obtener el elemento mayor 
    public static int busMax(int A[], int size){
    int max=A[0];
        for (int i = 0; i < size; i++) {
            if(A[i]>max){
            max=A[i];
            }
        }
    return max;
    }
    
    //less
    
    /*less lo usamos para comparar si dos valores si estan ordenados de menor a mayor */
    public static boolean less(Comparable v, Comparable w){
    return v.compareTo(w)<0;
    }
    //exch
    public static void exch(int[] a, int j, int i){
    int t=a[i];
    a[i]=a[j];
    a[j]=t;
     
    }
    
    //isSorted
    public static boolean isSorted(int[] a){
        //i inisia en unio por que no tenemos un A[-1]
        for (int i = 1; i < a.length; i++){ 
            if(less(a[i], a[i-1]))return false;
        }
        return true;
       
    }

    @Override
    public Iterator iterator() {
      return new ArrayIterator ();  
    }
    
    
 private class ArrayIterator implements Iterator {

          private int a[]=c;
          private int i=0;
             @Override
             public boolean hasNext() {
                if(i<a.length){
                 if(a[i]!=0){
                      i++;
                 return true;
                 }}
               
                 return false;
               
             }

        @Override
        public Object next() {
            int x=a[i-1];
            
            return x;
        }

             
         };    
    

}
