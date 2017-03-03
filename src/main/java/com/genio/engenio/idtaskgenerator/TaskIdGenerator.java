package com.genio.engenio.idtaskgenerator;

import java.util.Random;

/**
 * The Interface TaskIdGenerator.
 */
@Deprecated
public interface TaskIdGenerator {
	
	/** The maximum. */
	double maximum = 1000;
	
	/** The minimum. */
	int minimum = 0;

	/**
	 * Generate.
	 *
	 * @return the long
	 */
	public default Long generate(){
		Random rand = new Random();
		Long randomNum = rand.nextLong();
		return randomNum;
	}

}
