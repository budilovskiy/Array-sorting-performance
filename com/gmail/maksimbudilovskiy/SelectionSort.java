package com.gmail.maksimbudilovskiy;

public class SelectionSort extends Sort {
	
	@Override
	public int[] sorting(int[] array) {
		timeout = System.nanoTime();
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			int buffer = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			buffer = array[i];
			array[i] = array[min];
			array[min] = buffer;
		}
		timeout = System.nanoTime() - timeout;
		System.out.printf("sorted by SelectionSort:\t");
		return array;
	}
}
