package de.amehlen.sortings.algorithms;

import static java.lang.Integer.compare;

import de.amehlen.sortings.SortOrder;
import de.amehlen.sortings.SortStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSort implements SortStrategy {

  private static final Logger LOGGER = LogManager.getLogger(InsertionSort.class);

  @Override
  public int[] sort(int[] numbers, SortOrder sortOrder) {
    if (numbers == null) {
      throw new IllegalArgumentException("The passed array must not be zero.");
    }

    int direction = (sortOrder == SortOrder.ASC) ? 1 : -1;

    for (int i = 1; i < numbers.length; i++) {
      int key = numbers[i];
      int j = i - 1;

      while (j >= 0 && compare(numbers[j], key) == direction) {
        numbers[j + 1] = numbers[j];
        j = j - 1;
      }
      numbers[j + 1] = key;
      LOGGER.info("Iteration {}: {}", i, numbers);
    }
    return numbers;
  }
}
