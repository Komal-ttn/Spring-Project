package com.demo.springbasic.springbasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    private SortAlgorithm sortAlgorithm;
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

        BinarySearchAlgo b=new BinarySearchAlgo();
        int x=b.binarySearchAlgo(numbers,0,numbers.length-1,numberToSearch);
        //3.Result result
        return x;           //dummy value
    }

}
