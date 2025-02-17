package de.amehlen;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import de.amehlen.sortings.SortStrategy;
import de.amehlen.sortings.algorithms.SelectionSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SortAlgorithmTest {

  private final SortStrategy sortStrategy = new SelectionSort();

  @Nested
  @DisplayName("Positive test cases for the sorting algorithms")
  class PositiveTestCases {

    @Test
    @DisplayName("Sorting an unsorted list")
    void testUnsortedArray() {
      int[] input = {3, 1, 4, 1, 5};
      int[] expected = {1, 1, 3, 4, 5};
      assertArrayEquals(expected, sortStrategy.sort(input));
    }

    @Test
    @DisplayName("Sorting an sorted list")
    void testSortedArray() {
      int[] input = {1, 1, 3, 4, 5};
      int[] expected = {1, 1, 3, 4, 5};
      assertArrayEquals(expected, sortStrategy.sort(input));
    }

    @Test
    @DisplayName("Sorting an empty list")
    void testSortEmptyArray() {
      int[] input = {};
      int[] expected = {};
      assertArrayEquals(expected, sortStrategy.sort(input));
    }

    @Test
    @DisplayName("Sorting a list with a single element")
    void testSortSingleElementArray() {
      int[] input = {42};
      int[] expected = {42};
      assertArrayEquals(expected, sortStrategy.sort(input));
    }

    @Test
    @DisplayName("Sorting a list with duplicates")
    void testSortWithDuplicates() {
      int[] input = {5, 3, 3, 2, 5};
      int[] expected = {2, 3, 3, 5, 5};
      assertArrayEquals(expected, sortStrategy.sort(input));
    }

    @Test
    @DisplayName("Sorting a list with negative numbers")
    void testSortWithNegativeNumbers() {
      int[] input = {-3, -1, -4, -2};
      int[] expected = {-4, -3, -2, -1};
      assertArrayEquals(expected, sortStrategy.sort(input));
    }

  }

}