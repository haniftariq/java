package com.day6;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;



 class Array {


    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(array));

        // Using a LinkedHashSet to maintain insertion order
        Set<Integer> uniqueElements = new LinkedHashSet<>();
        for (int num : array) {
            uniqueElements.add(num);
        }

        // Converting the Set back to an array
        int[] result = new int[uniqueElements.size()];
        int i = 0;
        for (int num : uniqueElements) {
            result[i++] = num;
        }

        System.out.println("Array after removing duplicates: " + Arrays.toString(result));
    }
}

