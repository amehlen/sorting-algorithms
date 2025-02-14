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

      swap(numbers, i, min);
    }
  }

  private static void swap(int[] numbers, int index1, int index2) {
    int temp = numbers[index1];
    numbers[index1] = numbers[index2];
    numbers[index2] = temp;
  }
}
