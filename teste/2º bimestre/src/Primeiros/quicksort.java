package Primeiros;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
 
public class quicksort<E extends Comparable<? super E>> {
    public static final Random RND = new Random();
 
    private void swap(E[] array, int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
 
    private int partition(E[] array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1);
        E pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (array[i].compareTo(pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }
 
    private void qsort(E[] array, int begin, int end) {
        if (end > begin) {
            int index = partition(array, begin, end);
            qsort(array, begin, index - 1);
            qsort(array, index + 1, end);
        }
    }
 
    public void sort(E[] array) {
        qsort(array, 0, array.length - 1);
    }
 
    public static void main(String[] args) {

    	int receber;
    	receber = Integer.parseInt(JOptionPane.showInputDialog("Deseja digitar quanto numeros "));
        Integer[] l1 = new Integer[receber];
        for (int i = 0 ; i < receber ; i++)
        {
        	l1[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero"));
        }
        System.out.println("l1  start:" + Arrays.toString(l1));
        quicksort<Integer> qs = new quicksort<Integer>();
        qs.sort(l1);
        System.out.println("l1 sorted:" + Arrays.toString(l1));
        
    }
}
