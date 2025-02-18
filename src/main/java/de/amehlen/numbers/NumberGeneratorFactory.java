package de.amehlen.numbers;

public class NumberGeneratorFactory {

  private NumberGeneratorFactory() {
  }

  public static NumberGenerator createNumberGenerator(String type) {
    return switch (type) {
      case "random" -> new RandomNumberGenerator();
      case "sorted" -> new AscendingSortedNumbersGenerator();
      default -> null;
    };
  }

}
