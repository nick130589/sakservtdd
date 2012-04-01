package org.sakserv.scratch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BoxingUnboxingTest {
	
	List<Integer> box = new ArrayList<Integer>();
	
	@Before
	// Tests boxing
	public void setUp() {
		box.add(5);
	}
	
	@Test
	public void testUnboxing() {
		int x = box.get(0);
		assertEquals(5,x);
	}

}
