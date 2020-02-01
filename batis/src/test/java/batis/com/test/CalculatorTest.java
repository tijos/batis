package batis.com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import batis.com.Calculator;

class CalculatorTest {
	private Calculator calculator;
	private static Instant statAt;
	
	@BeforeAll
	public static void initStatingTime() {
		
		statAt = Instant.now();
		System.out.println("Debut de tous les test à : "+statAt);
	}
	
	@AfterAll
	public static void testDuration() {
		System.out.println("Fin des test à : ");
		Instant after = Instant.now();
		long duration = Duration.between(statAt,after).toMillis();
		System.out.println(MessageFormat.format("Durée des test {0} ms", duration));
	}
	
	
	@BeforeEach
	public void initCalculator() {
		System.out.println("Before each ");
		calculator = new Calculator();
	}
	
	@ParameterizedTest(name = "{0} * 0 egal toujours 0")
	@ValueSource(ints = {1,45,78,1,0,8758})
	public void parameterizedTest(int arg) {
		int p = calculator.mutiply(arg, 0);
		assertEquals(0, p);
	}
	
	/**
	 * 
	 * @param arg1
	 * @param arg2
	 * @param somme
	 */
	@ParameterizedTest(name = "{0} + {1} egal {2}")
	@CsvSource(value = {"1,1,2","2,3,5","0,10,10"})
	public void parameterizedAddTest(int arg1, int arg2 , int somme) {
		int s = calculator.add(arg1, arg2);
		//assertEquals(somme, s);
		assertThat(somme).isEqualTo(s);
	}
	
	@Test
	void testAddTwoPositiveNumbers() {
		int a = 2, b = 3;
		int somme = calculator.add(a,b);
		assertThat(somme).isEqualTo(5);
	}

	@Test
	void testMultiplyNumbers () {
		
		int a = 2, b = 3;
		
		int produit = calculator.mutiply(a,b);

		assertThat(produit).isEqualTo(6);
	}
	
	@Test
	public void testAddDoubleNumbers() {
		double a = 2.5;
		double b =  2.5;
		
		double produit = calculator.add(a, b);
		
		assertThat(produit).isEqualTo(5);
	}
	
	@Test
	public void digitsSet_shouldReturnsTheSetOfDigits_ofPositiveInteger() {
		// GIVEN
		int number = 95897;

		// WHEN
		Set<Integer> actualDigits = calculator.digitsSet(number);

		// THEN
		Set<Integer> expectedDigits = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
		//assertEquals(expectedDigits, actualDigits);
		//TODO
		assertThat(expectedDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
	}
}
