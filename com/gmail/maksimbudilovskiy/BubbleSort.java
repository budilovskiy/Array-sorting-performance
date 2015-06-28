package com.gmail.maksimbudilovskiy;

public class BubbleSort extends Sort {

	@Override
	public int[] sorting(int[] array) {
		timeout = System.nanoTime();
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int buffer = array[j];
					array[j] = array[j + 1];
					array[j + 1] = buffer;
				}
			}
		}
		timeout = System.nanoTime() - timeout;
		System.out.printf("sorted by BubbleSort:\t\t");
		return array;
	}
}
