package org.sakserv.scratch;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatricesTest {

	@Test
	/*    0  1  2  3
	 *    ----------
	 * 0 |X  X  X  X
	 * 1 |X  X  X  X
	 * 2 |X  X  X  X
	 * 
	 * 
	 *    0  1  2  3
	 *    ----------
	 * 0 |0  1  2  3
	 * 1 |4  5  6  7
	 * 2 |8  9  10 11
	 * 
	 */
	public void testTwoDimensionalArrays(){
		final int rows = 3;
		final int cols = 4;
		int count = 0;
		
		int[][] matrix = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				matrix[row][col] = count++;
			}
		}
		
		assertEquals(11, matrix[2][3]);
		assertEquals(6, matrix[1][2]);
	}
}
