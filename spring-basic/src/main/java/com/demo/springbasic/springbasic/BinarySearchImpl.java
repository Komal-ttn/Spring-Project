package com.demo.springbasic.springbasic;

import com.demo.springbasic.springbasic.sort.SortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    private SortAlgorithm sortAlgorithm;

    @Autowired
    private BinarySearchAlgo binarySearchAlgo;
    //Setter Method Injection

    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

  /*  //Constructor Injection
    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }*/

    public int binarySearch(int []numbers,int numberToSearch){

        //1. Implement Bubble Sorting Logic
       // BubbleSortAlgo bubbleSort=new BubbleSortAlgo();    //Tight Coupling
        int[] sortedNumber=sortAlgorithm.sort(numbers);       //Loose Coupling
        System.out.println(sortAlgorithm);
     
        //2. Search the array

        int x=binarySearchAlgo.binarySearchAlgo(numbers,0,numbers.length-1,numberToSearch);
        //3.Result result
        return x;           //dummy value
    }

}
