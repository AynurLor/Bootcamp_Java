package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
  private NumberWorker nm;
  @BeforeEach
  void createNumberWorker() {
    nm = new NumberWorker();
  }
  @ParameterizedTest(name = "{index} - {0} is a prime")
   @ValueSource(ints = {997, 757, 113, 11})
  void isPrimeForPrimes(int argument) {
//    isPrime(); для 3 простых числе
     Assertions.assertTrue(nm.isPrime(argument));
  }

  @ParameterizedTest(name = "{index} - {0} is not prime")
  @ValueSource(ints = {998, 758, 112, 12})
  void isPrimeForNotPrimes(int argument) {
    Assertions.assertFalse(nm.isPrime(argument));
//    isPrime() для 3 сост чисел
  }

  @ParameterizedTest(name = "{index} - {0} is not prime")
  @ValueSource(ints = {0, -1, 1, -21})
  void isPrimeForIncorrectNumbers(int argument) {
    Assertions.assertThrows(IllegalNumbersException.class, () -> nm.isPrime(argument));
//    isPrime() для 3 неправ чисел
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/data.csv", numLinesToSkip = 0)
  void isDigitSumForIncorrectNumbers(int number, int suma) {
    Assertions.assertEquals(nm.digitsSum(number), suma);
//    digitsum() с набором 10 значений
  }
}
