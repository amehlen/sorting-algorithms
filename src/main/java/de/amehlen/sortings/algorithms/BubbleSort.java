package de.amehlen.sortings.algorithms;

import de.amehlen.sortings.SortStrategy;

public class BubbleSort implements SortStrategy {

  @Override
  public void sort(int[] numbers) {
    boolean hasSwapped = true;
    for (int i = 0; i < numbers.length && hasSwapped; i++) {
      hasSwapped = false;
      for (int j = 0; j < numbers.length - i - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          swap(numbers, j, j + 1);
          hasSwapped = true;
        }
      }
    }
  }

  private static void swap(int[] numbers, int index1, int index2) {
    int temp = numbers[index1];
    numbers[index1] = numbers[index2];
    numbers[index2] = temp;
  }

}
