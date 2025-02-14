package de.amehlen;

import de.amehlen.sortings.SortingContext;
import de.amehlen.sortings.algorithms.BubbleSort;
import de.amehlen.sortings.algorithms.InsertionSort;
import de.amehlen.sortings.algorithms.SelectionSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

  private static final Logger LOGGER = LogManager.getLogger(App.class);

  public static void main(String[] args) {
    LOGGER.info("Selection Sort");

    int[] numbers = {5, 2, 9, 1, 5, 8, 3, 7, 4, 2, 6, 1, 3, 9, 5};
    LOGGER.info("Unsorted numbers: {}", numbers);

    SortingContext sortingContext = new SortingContext(new InsertionSort());
    sortingContext.performSort(numbers);

    LOGGER.info("Sorted numbers: {}", numbers);

    LOGGER.info("Insertion Sort");

    numbers = new int[]{5, 2, 9, 1, 5, 8, 3, 7, 4, 2, 6, 1, 3, 9, 5};
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new SelectionSort());
    sortingContext.performSort(numbers);

    LOGGER.info("Sorted numbers: {}", numbers);

    LOGGER.info("Bubble Sort");

    numbers = new int[]{5, 2, 9, 1, 5, 8, 3, 7, 4, 2, 6, 1, 3, 9, 5};
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new BubbleSort());
    sortingContext.performSort(numbers);

    LOGGER.info("Sorted numbers: {}", numbers);
  }

}
