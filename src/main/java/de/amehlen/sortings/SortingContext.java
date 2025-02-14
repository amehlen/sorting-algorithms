package de.amehlen.sortings;

public class SortingContext {

  private SortStrategy sortStrategy;

  public SortingContext(SortStrategy sortStrategy) {
    this.sortStrategy = sortStrategy;
  }

  public void setSortStrategy(SortStrategy sortStrategy) {
    this.sortStrategy = sortStrategy;
  }

  public void performSort(int[] numbers) {
    sortStrategy.sort(numbers);
  }
}
