package de.amehlen;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import de.amehlen.sortings.SortOrder;
import de.amehlen.sortings.SortStrategy;
import de.amehlen.sortings.algorithms.BubbleSort;
import de.amehlen.sortings.algorithms.InsertionSort;
import de.amehlen.sortings.algorithms.SelectionSort;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class SortAlgorithmTest {

  @Nested
  @DisplayName("Positive test cases for the sorting algorithms")
  class PositiveTestCases {

    @DisplayName("Sorting an unsorted list in ascending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testUnsortedArrayInAscendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {3, 1, 4, 1, 5};
      int[] expected = {1, 1, 3, 4, 5};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.ASC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting an unsorted list in descending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testUnsortedArrayInDescendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {3, 1, 4, 1, 5};
      int[] expected = {5, 4, 3, 1, 1};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.DESC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting an sorted list in ascending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortedArrayInAscendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {1, 1, 3, 4, 5};
      int[] expected = {1, 1, 3, 4, 5};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.ASC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting an sorted list in descending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortedArrayInDescendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {5, 4, 3, 1, 1};
      int[] expected = {5, 4, 3, 1, 1};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.DESC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting an empty list in ascending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortEmptyArrayInAscendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {};
      int[] expected = {};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.ASC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting an empty list in descending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortEmptyArrayInDescendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {};
      int[] expected = {};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.DESC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with a single element in ascending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortSingleElementArrayInAscendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {42};
      int[] expected = {42};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.ASC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with a single element in descending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortSingleElementArrayInDescendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {42};
      int[] expected = {42};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.DESC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with duplicates in ascending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortWithDuplicatesInAscendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {5, 3, 3, 2, 5};
      int[] expected = {2, 3, 3, 5, 5};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.ASC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with duplicates in descending order")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortWithDuplicatesInDescendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {5, 3, 3, 2, 5};
      int[] expected = {5, 5, 3, 3, 2};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.DESC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with negative numbers in ascending oder")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortWithNegativeNumbersInAscendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {-3, -1, -4, -2};
      int[] expected = {-4, -3, -2, -1};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.ASC);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with negative numbers in descending oder")
    @ParameterizedTest()
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortWithNegativeNumbersInDescendingOrder(SortStrategy sortStrategy) {
      // Given
      int[] input = {-3, -1, -4, -2};
      int[] expected = {-1, -2, -3, -4};

      // When
      int[] sorted = sortStrategy.sort(input, SortOrder.DESC);

      // Then
      assertArrayEquals(expected, sorted);
    }

  }

  @Nested
  @DisplayName("Negative test cases for the sorting algorithms")
  class NegativeTestCases {

    @DisplayName("Null value as input")
    @ParameterizedTest
    @ArgumentsSource(SortingAlgorithms.class)
    void testNullInput(SortStrategy sortStrategy) {
      assertThrows(IllegalArgumentException.class, () -> sortStrategy.sort(null, SortOrder.ASC));
    }

  }

}

class SortingAlgorithms implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
    return Stream.of(
        arguments(named("Bubble Sort", new BubbleSort())),
        arguments(named("Insertion Sort", new InsertionSort())),
        arguments(named("Selection Sort", new SelectionSort()))
    );
  }

}