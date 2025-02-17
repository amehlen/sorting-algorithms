package de.amehlen;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @DisplayName("Sorting an unsorted list")
    @ParameterizedTest(name = "{index} => Algorithm: {1}")
    @ArgumentsSource(SortingAlgorithms.class)
    void testUnsortedArray(SortStrategy sortStrategy, String algorithmName) {
      // Given
      int[] input = {3, 1, 4, 1, 5};
      int[] expected = {1, 1, 3, 4, 5};

      // When
      int[] sorted = sortStrategy.sort(input);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting an sorted list")
    @ParameterizedTest(name = "{index} => Algorithm: {1}")
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortedArray(SortStrategy sortStrategy, String algorithmName) {
      // Given
      int[] input = {1, 1, 3, 4, 5};
      int[] expected = {1, 1, 3, 4, 5};

      // When
      int[] sorted = sortStrategy.sort(input);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting an empty list")
    @ParameterizedTest(name = "{index} => Algorithm: {1}")
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortEmptyArray(SortStrategy sortStrategy, String algorithmName) {
      // Given
      int[] input = {};
      int[] expected = {};

      // When
      int[] sorted = sortStrategy.sort(input);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with a single element")
    @ParameterizedTest(name = "{index} => Algorithm: {1}")
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortSingleElementArray(SortStrategy sortStrategy, String algorithmName) {
      // Given
      int[] input = {42};
      int[] expected = {42};

      // When
      int[] sorted = sortStrategy.sort(input);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with duplicates")
    @ParameterizedTest(name = "{index} => Algorithm: {1}")
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortWithDuplicates(SortStrategy sortStrategy, String algorithmName) {
      // Given
      int[] input = {5, 3, 3, 2, 5};
      int[] expected = {2, 3, 3, 5, 5};

      // When
      int[] sorted = sortStrategy.sort(input);

      // Then
      assertArrayEquals(expected, sorted);
    }

    @DisplayName("Sorting a list with negative numbers")
    @ParameterizedTest(name = "{index} => Algorithm: {1}")
    @ArgumentsSource(SortingAlgorithms.class)
    void testSortWithNegativeNumbers(SortStrategy sortStrategy, String algorithmName) {
      // Given
      int[] input = {-3, -1, -4, -2};
      int[] expected = {-4, -3, -2, -1};

      // When
      int[] sorted = sortStrategy.sort(input);

      // Then
      assertArrayEquals(expected, sorted);
    }

  }

}

class SortingAlgorithms implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
    return Stream.of(
        arguments(new BubbleSort(), "Bubble Sort"),
        arguments(new InsertionSort(), "Insertion Sort"),
        arguments(new SelectionSort(), "Selection Sort")
    );
  }

}