package org.sakserv.scratch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CollectionsSortTest {

	@Test
	public void testSortStringsInPlace() {
		List<String> list = new ArrayList<String>();
		list.add("Heller");
		list.add("Kafka");
		list.add("Camus");
		list.add("Boyle");
		
		java.util.Collections.sort(list);
		
		assertEquals("Boyle", list.get(0));
		assertEquals("Camus", list.get(1));
		assertEquals("Heller", list.get(2));
		assertEquals("Kafka", list.get(3));
	}

}
