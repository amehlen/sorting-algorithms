package de.amehlen.numbers;

public class NumberGeneratorFactory {

  public static NumberGenerator createNumberGenerator(String type) {
    return switch (type) {
      case "random" -> new RandomNumberGenerator();
      default -> null;
    };
  }

}
