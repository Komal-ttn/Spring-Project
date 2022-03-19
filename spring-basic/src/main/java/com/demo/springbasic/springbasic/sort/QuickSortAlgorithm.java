package com.demo.springbasic.springbasic.sort;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm {
    public int[] sort(int[] numbers) {
        int start = 0, end = numbers.length-1;
        quick(numbers, start, end);
        return numbers;
    }

    private void quick(int[] numbers, int start, int end) {
        if (start < end) {
            int p = partition(numbers, start, end); //p is the partitioning index
            quick(numbers, start, p - 1);
            quick(numbers, p + 1, end);
        }
    }

    private int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end]; // pivot element
        int i = (start - 1);
        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than the pivot
            if (numbers[j] < pivot) {
                i++; // increment index of smaller element
                int t = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = t;
            }
        }
        int t = numbers[i + 1];
        numbers[i + 1] = numbers[end];
        numbers[end] = t;
        return (i + 1);
    }

}

