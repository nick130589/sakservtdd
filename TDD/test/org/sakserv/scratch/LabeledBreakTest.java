package org.sakserv.scratch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LabeledBreakTest {

	@Test
	public void testLabeledBreak() {
		List<List<String>> table = new ArrayList<List<String>>();
		
		List<String> row1 = new ArrayList<String>();
		row1.add("5");
		row1.add("2");
		
		List<String> row2 = new ArrayList<String>();
		row2.add("3");
		row2.add("4");
		
		table.add(row1);
		table.add(row2);
		
		assertTrue(found(table, "3"));
		assertFalse(found(table, "8"));
	}
	
	private boolean found(List<List<String>> table, String target) {
		boolean found = false;
		search:
			for (List<String> row: table) {
				for (String value: row) {
					if (value.equals(target)) {
						found = true;
						break search;
					}
				}
			}
		return found;
	}
	

}
