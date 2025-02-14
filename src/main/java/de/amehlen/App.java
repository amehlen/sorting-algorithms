package de.amehlen;

import de.amehlen.numbers.NumberGenerator;
import de.amehlen.numbers.NumberGeneratorFactory;
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

    LOGGER.info("Selection Sort");

    int[] numbers = numberGenerator.generate(15, 10, 20);
    LOGGER.info("Unsorted numbers: {}", numbers);

    SortingContext sortingContext = new SortingContext(new InsertionSort());
    sortingContext.performSort(numbers);

    LOGGER.info("Sorted numbers: {}", numbers);

    LOGGER.info("Insertion Sort");

    numbers = numberGenerator.generate(10, 0, 15);
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new SelectionSort());
    sortingContext.performSort(numbers);

    LOGGER.info("Sorted numbers: {}", numbers);

    LOGGER.info("Bubble Sort");

    numbers = numberGenerator.generate(20, 25, 50);
    LOGGER.info("Unsorted numbers: {}", numbers);

    sortingContext.setSortStrategy(new BubbleSort());
    sortingContext.performSort(numbers);

    LOGGER.info("Sorted numbers: {}", numbers);
  }

}
