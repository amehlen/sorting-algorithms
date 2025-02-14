package de.amehlen.sortings.algorithms;

import de.amehlen.sortings.SortStrategy;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectionSort implements SortStrategy {

  private static final Logger LOGGER = LogManager.getLogger(SelectionSort.class);

  @Override
  public void sort(int[] numbers) {
    int length = numbers.length;
    for (int i = 0; i < length - 1; i++) {
      int min = i;

      for (int j = i + 1; j < length; j++) {
        if (numbers[j] < numbers[min]) {
          min = j;
        }
      }

      swap(numbers, i, min);
      LOGGER.info("Iteration {}: {}", i, Arrays.toString(numbers));
    }
  }

  private static void swap(int[] numbers, int index1, int index2) {
    int temp = numbers[index1];
    numbers[index1] = numbers[index2];
    numbers[index2] = temp;
  }
}
