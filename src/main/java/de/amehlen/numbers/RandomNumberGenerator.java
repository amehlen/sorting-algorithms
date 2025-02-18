package de.amehlen.numbers;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {

  private final Random random = new Random();

  @Override
  public int[] generate(int count, int min, int max) {
    return IntStream.generate(() -> random.nextInt((max - min + 1) + min))
        .limit(count)
        .toArray();
  }
}
