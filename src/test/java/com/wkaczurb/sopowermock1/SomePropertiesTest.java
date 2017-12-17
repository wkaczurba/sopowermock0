package com.wkaczurb.sopowermock1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class SomePropertiesTest {

	@Test
	public void testStaticBlock() {
		SomeProperties.getVersion();
	}
}
