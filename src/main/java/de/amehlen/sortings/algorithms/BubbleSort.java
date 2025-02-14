package de.amehlen.sortings.algorithms;

import de.amehlen.sortings.SortStrategy;

public class BubbleSort implements SortStrategy {

  @Override
  public void sort(int[] numbers) {
    boolean changesDone = true;
    for (int i = 0; i < numbers.length && changesDone; i++) {
      changesDone = false;
      for (int j = 0; j < numbers.length - i - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          int temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
          changesDone = true;
        }
      }
    }
  }

}
