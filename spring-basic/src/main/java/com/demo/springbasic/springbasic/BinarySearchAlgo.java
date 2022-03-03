package com.demo.springbasic.springbasic;

public class BinarySearchAlgo {
    public int binarySearchAlgo(int arr[], int l, int r, int key)
    {
        if (r >= l && l <= arr.length - 1) {

            int mid = l + (r - l) / 2;

            if (arr[mid] == key)
                return mid;

            if (arr[mid] > key)
                return binarySearchAlgo(arr, l, mid - 1,key);

            return binarySearchAlgo(arr, mid + 1, r, key);
        }


        return -1;
    }
}
