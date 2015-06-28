package com.gmail.maksimbudilovskiy;

/*при запуске программы она рандомно подбирает размер массива, рандомно его заполняет,
 * сортирует разными способами, и результаты заносит в сортед-мэп,
 * где ключ - размер массива, а значение - время сортировки. И так несколько раз (зависит от константы).
 * Выводит, соотвественно, тоже красиво
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Application {
	private final static int NUMBER_OF_CICLES = 25;
	private final static int MAX_SIZE_OF_ARRAY = 50000;

	public static int[] createRandomInput() {
		int arraySize = (int) (Math.random() * MAX_SIZE_OF_ARRAY);  // случайный размер массива
		int[] array = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = (int) (Math.random() * arraySize * 5); // заполнение массива случайными значениями
		}
		return array;
	}

	public static int[] arraySorting(Sort i, int[] userArray) {
		int[] arrayCopy = Arrays.copyOf(userArray, userArray.length); // make copy
		i.sorting(arrayCopy); // sort of copy
		return arrayCopy;
	}
	
	// writing map of results to csv file and to console
	public static void writingMapToCSV(Map<Integer, Long> map1, Map<Integer, Long> map2, String outputFileName) {
		File outputFile = new File(outputFileName);
		try {
			PrintWriter pr = new PrintWriter(new FileWriter(outputFile));
			System.out.printf("\tBubble\tSelection\n");
			for (Map.Entry<Integer, Long> pair : map1.entrySet()) {
				pr.print(pair.getKey() + ";" + pair.getValue() + ";" + map2.get(pair.getKey()));
				System.out.printf(pair.getKey() + "\t" + pair.getValue() + "\t" + map2.get(pair.getKey()) + "\n");
				pr.println();
			}
			pr.close();
		} catch (IOException e) {
			System.out.println("Unable to write file.");
			return;
		}	
	}

	public static void main(String[] args) {
		
		// Мэп, который будет содержать размер массива и время сортировки методом пузырька
		SortedMap<Integer, Long> bubbleSortSpeedMap = new TreeMap<Integer, Long>();
		
		// Мэп, который будет содержать размер массива и время сортировки методом выбора
		SortedMap<Integer, Long> selectionSortSpeedMap = new TreeMap<Integer, Long>();
		
		// output filename
		String outputFileName = "D:/output.csv";
		
		for (int i = 0; i < NUMBER_OF_CICLES; i++) {
			int[] userArray = createRandomInput();  // создаем новый массив
			
			System.out.println(i + 1 + " Size: " + userArray.length);
			
			Sort bubble = new BubbleSort();  // создаем новый объект сортировки
			int[] bubbleArray = arraySorting(bubble, userArray); // получаем отсортированный масиив
			bubbleSortSpeedMap.put(bubbleArray.length, bubble.getTimeout()/1000000); // заносим данные в мэп
			System.out.println(bubble.getTimeout()/1000000 + " milliseconds");
	
			Sort selection = new SelectionSort();
			int[] selectionArray = arraySorting(selection, userArray);
			selectionSortSpeedMap.put(selectionArray.length, selection.getTimeout()/1000000);
			System.out.println(selection.getTimeout()/1000000 + " milliseconds");
		}
		
		writingMapToCSV(bubbleSortSpeedMap, selectionSortSpeedMap, outputFileName);	
	}
}
