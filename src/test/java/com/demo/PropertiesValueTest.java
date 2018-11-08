package com.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesValueTest {
	
	@Value("${logging.level.root}")
	private String loggingLevel;
	
	@Test
	public void getProperties() {
		assertThat( this.loggingLevel, is("WARN") );
	}
}
