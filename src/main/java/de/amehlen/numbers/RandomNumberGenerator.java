package de.amehlen.numbers;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

  private final Random random = new Random();

  @Override
  public int[] generate(int count, int min, int max) {
    int[] numbers = new int[count];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = random.nextInt(max - min + 1) + min;
    }

    return numbers;
  }
}
