package de.amehlen.sortings.algorithms;

import de.amehlen.sortings.SortStrategy;

public class SelectionSort implements SortStrategy {

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

      int temp = numbers[i];
      numbers[i] = numbers[min];
      numbers[min] = temp;
    }
  }
}
