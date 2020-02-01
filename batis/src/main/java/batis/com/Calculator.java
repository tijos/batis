package batis.com;

import java.util.Set;

/**
 * 
 * @author tijos
 *
 */
public class Calculator {


	/**
	 * 
	 * @param fistersNumber
	 * @param secondeNumber
	 * @return
	 */
	public int add(final int fistersNumber,final int secondeNumber) {
		return fistersNumber + secondeNumber;
	}

	/**
	 * 
	 * @param fistersNumber
	 * @param secondeNumber
	 * @return
	 */
	public int mutiply(final int fistersNumber,final int secondeNumber) {

		return fistersNumber * secondeNumber;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public Set<Integer> digitsSet(final int number) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param fistersNumber
	 * @param secondeNumber
	 * @return
	 */
	public double add(final double fistersNumber,final double secondeNumber) {
		return fistersNumber + secondeNumber;
	}

	/**
	 * 
	 * @param fistersNumber
	 * @param secondeNumber
	 * @return
	 */
	public double division(final int fistersNumber,final int secondeNumber) {
		return fistersNumber / secondeNumber;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double multiply(final double fistersNumber,final double secondeNumber) {
		return fistersNumber * secondeNumber;
	}
}
