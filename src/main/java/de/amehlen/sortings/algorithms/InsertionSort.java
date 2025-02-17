package de.amehlen.sortings.algorithms;

import de.amehlen.sortings.SortStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSort implements SortStrategy {

  private static final Logger LOGGER = LogManager.getLogger(InsertionSort.class);

  @Override
  public int[] sort(int[] numbers) {
    for (int i = 1; i < numbers.length; i++) {
      int key = numbers[i];
      int j = i - 1;

      while (j >= 0 && numbers[j] > key) {
        numbers[j + 1] = numbers[j];
        j = j - 1;
      }
      numbers[j + 1] = key;
      LOGGER.info("Iteration {}: {}", i, numbers);
    }
    return numbers;
  }
}
