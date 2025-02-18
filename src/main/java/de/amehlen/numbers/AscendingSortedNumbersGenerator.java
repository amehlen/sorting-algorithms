package de.amehlen.numbers;

import java.util.stream.IntStream;

public class AscendingSortedNumbersGenerator implements NumberGenerator {

  @Override
  public int[] generate(int count, int min, int max) {
    return IntStream.range(0, count)
        .map(i -> min + (i * (max - min)) / (count - 1))
        .toArray();
  }

}
