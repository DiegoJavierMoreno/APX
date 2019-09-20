package com.bbva.cmap.lib.r002;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/CMAPR002-app.xml",
		"classpath:/META-INF/spring/CMAPR002-app-test.xml",
		"classpath:/META-INF/spring/CMAPR002-arc.xml",
		"classpath:/META-INF/spring/CMAPR002-arc-test.xml" })
public class CMAPR002Test {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CMAPR002.class);
	
	@Resource(name = "cmapR002")
	private CMAPR002 cmapR002;
	
	@Before
	public void setUp() throws Exception {		
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.cmapR002;
		if(this.cmapR002 instanceof Advised){
			Advised advised = (Advised) this.cmapR002;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		LOGGER.info("Executing the test...");
		Assert.assertNotNull(cmapR002.executeMatrixMapAPI("Washington,DC", "New York City,NY"));
		Assert.assertNull(cmapR002.executeMatrixMapAPI("", "New York City,NY"));
		Assert.assertNull(cmapR002.executeMatrixMapAPI(null, "New York City,NY"));
		Assert.assertNull(cmapR002.executeMatrixMapAPI("Washington,DC", ""));
		Assert.assertNull(cmapR002.executeMatrixMapAPI("Washington,DC", null));
		Assert.assertNotNull(cmapR002.executeMatrixMapAPI("test", "111"));
	}
	
}
