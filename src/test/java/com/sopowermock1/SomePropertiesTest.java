package com.sopowermock1;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sopowermock1.SomeProperties;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SomeProperties.class)

// This will prevent running static block completely:
// @SuppressStaticInitializationFor("com.sopowermock1.SomeProperties")
public class SomePropertiesTest {
	
    @Mock
    private static InputStream streamMock;
    
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(SomeProperties.class);
    	System.out.println("test setUp");
    }

	@Test(expected = RuntimeException.class)
	public void testStaticBlock() {
		
    	PowerMockito.mockStatic(SomeProperties.class); // this will mock all static methods (unwanted as we want to call getVersion)
    	
    	// This will cause static block to be called.
		PowerMockito.when(SomeProperties.class.getResourceAsStream("/some.properties")).thenReturn(streamMock);
    	SomeProperties.getVersion();
	}
}
