package fivium.openeyes.utils;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UtilsTest {

	@Test
	public void createJsonErrorResultTest() {
		String errorTest = Utils.createJsonErrorResult("Save the birds");
		String expectedResult = "{\"error\":\"Save the birds\"}";
		assertEquals(expectedResult, errorTest);
	}
	
}
