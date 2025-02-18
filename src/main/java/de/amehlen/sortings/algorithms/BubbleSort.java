package de.amehlen.sortings.algorithms;

import de.amehlen.sortings.SortOrder;
import de.amehlen.sortings.SortStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSort implements SortStrategy {

  private static final Logger LOGGER = LogManager.getLogger(BubbleSort.class);

  @Override
  public int[] sort(int[] numbers, SortOrder sortOrder) {
    if (numbers == null) {
      throw new IllegalArgumentException("The passed array must not be zero.");
    }

    int direction = (sortOrder == SortOrder.ASC) ? 1 : -1;

    boolean hasSwapped = true;
    for (int i = 0; i < numbers.length && hasSwapped; i++) {
      hasSwapped = false;
      for (int j = 0; j < numbers.length - i - 1; j++) {
        if (direction * numbers[j] > direction * numbers[j + 1]) {
          swap(numbers, j, j + 1);
          hasSwapped = true;
        }
      }
      LOGGER.info("Iteration {}: {}", i, numbers);
    }
    return numbers;
  }

  private static void swap(int[] numbers, int index1, int index2) {
    int temp = numbers[index1];
    numbers[index1] = numbers[index2];
    numbers[index2] = temp;
  }

}
