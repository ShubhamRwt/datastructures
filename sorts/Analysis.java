/* Generate random numbers and do a quick sort analysis
 * over them.
 */
package sorts;
import java.util.Scanner;
import java.util.Random;
import sorts.QuickSort;

public class Analysis {
	// Do a quick sort using the QuickSort file
	public static void startSort(int[] array) {
		QuickSort.doQuickSort(array);
	}

	// Generates a random number between [0, arraySize)
	public static int generateRandomNumber(int arraySize) {
		Random rm = new Random();
		int random = rm.nextInt(arraySize);
		return random;
	}

	// Returns time in milliseconds since Jan, 1970
	// Used here to get the relative difference between
	// executions
	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	public static void generateRandomArray(int[] array, int arraySize) {
		for (int idx = 0; idx < arraySize; idx++) {
			array[idx] = generateRandomNumber(arraySize);
		}
	}

	public static void writeToFile(int arraySize, long time) {

	}

	public static void printArray(int[] array) {
		System.out.println();
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx] + " ");
		}
		System.out.println();
	}

	public static void analysisMachine(int arraySize, int maxLimit) {
		int[] array = new int[arraySize];
		double sum = 0;
		double average = 0;
		int max = maxLimit;
		while (maxLimit > 0) {
			//System.out.println("maxLimit: " + maxLimit);
			generateRandomArray(array, arraySize);
			//printArray(array);
			long startTimeInMSeconds = getCurrentTime();
			startSort(array);
			long endTimeInMSeconds = getCurrentTime();
			//printArray(array);
			//writeToFile(arraySize, endTimeInSeconds - startTimeInSeconds);
			sum +=  (endTimeInMSeconds - startTimeInMSeconds);
			maxLimit -= 1;

		}
		average = sum / max;
		System.out.println(arraySize + "," + average);
	}

	public static void main(String[] args) throws InterruptedException {
		int[] lengthArray = {100, 500, 1000, 5000, 10000, 50000, 100000,
						200000, 500000, 1000000, 2000000, 3000000, 4000000, 5000000,
						6000000, 7000000, 8000000, 9000000, 10000000, 20000000, 30000000, 
						40000000, 50000000, 60000000, 70000000, 80000000, 90000000, 100000000, 
						200000000, 300000000, 400000000, 500000000, 600000000, 700000000, 
						800000000, 900000000 
						};
		int idx = 0, maxLimit = 10000;
		System.out.println("===================Analysis Start===================");
		System.out.println("ArraySize,Time");
		while (idx < lengthArray.length) {
			idx += 1;
			//Thread.sleep(5000);
			int len = lengthArray[idx];
			analysisMachine(len, maxLimit);
		}
		System.out.println("===================Analysis Complete================");
	}
}