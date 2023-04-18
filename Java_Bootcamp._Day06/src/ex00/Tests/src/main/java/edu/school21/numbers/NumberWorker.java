package edu.school21.numbers;

import static java.lang.Math.sqrt;

public class NumberWorker {

  public boolean isPrime(int number) {
    int summand = number;
    if (summand == 0 || summand <= -1 || summand == 1) {
      throw new IllegalNumbersException("Numbers is not correct");
    }
    double s = sqrt(summand);
    for (int i = 2; i <= s; i++) {
      if (summand % i == 0) {
        return false;
      }
    }
    return true;
  }

  public int digitsSum(int number) {
    int summand = number;
    int sum = 0;
    while (summand >= 1) {
      sum += summand % 10;
      summand /= 10;
    }
    return sum;

  }

}

class IllegalNumbersException extends RuntimeException {
  public IllegalNumbersException(String message) {
    super(message);
  }
}
