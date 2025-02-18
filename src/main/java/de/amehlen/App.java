package de.amehlen;

import de.amehlen.numbers.NumberGenerator;
import de.amehlen.numbers.NumberGeneratorFactory;
import de.amehlen.sortings.SortOrder;
import de.amehlen.sortings.SortingContext;
import de.amehlen.sortings.algorithms.BubbleSort;
import de.amehlen.sortings.algorithms.InsertionSort;
import de.amehlen.sortings.algorithms.SelectionSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

  private static final Logger LOGGER = LogManager.getLogger(App.class);

  public static void main(String[] args) {
    NumberGenerator numberGenerator = NumberGeneratorFactory.createNumberGenerator("random");

    LOGGER.info("Selection Sort - Ascending Order");

    int[] numbers = numberGenerator.generate(15, 10, 20);
    LOGGER.info("Unsorted numbers: {}", numbers);

    SortingContext sortingContext = new SortingContext(new InsertionSort());
    int[] sorted = sortingContext.performSort(numbers, SortOrder.ASC);

    LOGGER.info("Sorted numbers: {}", sorted);

    LOGGER.info("Selection Sort - Descending Order");

    numbers = numberGenerator.generate(15, 10, 20);
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext = new SortingContext(new InsertionSort());
    sorted = sortingContext.performSort(numbers, SortOrder.DESC);

    LOGGER.info("Sorted numbers: {}", sorted);

    LOGGER.info("Insertion Sort - Ascending Order");

    numbers = numberGenerator.generate(10, 0, 15);
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new SelectionSort());
    sorted = sortingContext.performSort(numbers, SortOrder.ASC);

    LOGGER.info("Sorted numbers: {}", sorted);

    LOGGER.info("Insertion Sort - Descending Order");

    numbers = numberGenerator.generate(10, 0, 15);
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new SelectionSort());
    sorted = sortingContext.performSort(numbers, SortOrder.DESC);

    LOGGER.info("Sorted numbers: {}", sorted);

    LOGGER.info("Bubble Sort - Ascending Order");

    numbers = numberGenerator.generate(20, 25, 50);
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new BubbleSort());
    sorted = sortingContext.performSort(numbers, SortOrder.ASC);

    LOGGER.info("Sorted numbers: {}", sorted);

    LOGGER.info("Bubble Sort - Descending Order");

    numbers = numberGenerator.generate(20, 25, 50);
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new BubbleSort());
    sorted = sortingContext.performSort(numbers, SortOrder.DESC);

    LOGGER.info("Sorted numbers: {}", sorted);
  }

}
