package com.bbva.cmap;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bbva.cmap.dto.destination.PlacesDTO;
import com.bbva.cmap.lib.r001.CMAPR001;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ParameterTable;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.test.osgi.DummyBundleContext;


/**
 * Test for transaction CMAPT00101COTransaction
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/elara-test.xml",
		"classpath:/META-INF/spring/CMAPT00101COTest.xml" })
public class CMAPT00101COTransactionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CMAPT00101COTransactionTest.class);
	
	@Autowired
	private CMAPT00101COTransaction transaction;
	
	@Resource(name="dummyBundleContext")
	private DummyBundleContext bundleContext;
	
	private TransactionRequest transactionRequest;
	
	@Mock
	private CMAPR001 campr001;

	@Spy
	private Context context;	
	
	@Before
	public void initializeClass() throws Exception {		
		this.transaction.start(bundleContext);
		
		// Initializing transaction to test
		this.transaction.setContext(new Context());
		this.transaction.getContext().setLanguageCode("ES");
		
		transactionRequest = Mockito.mock(TransactionRequest.class);
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<TransactionParameter>());
		transactionRequest.setBody(commonRequestBody);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn(null);
		this.transaction.getContext().setTransactionRequest(transactionRequest);
				
	}
	
	@Test
	public void testNotNull(){
		Assert.assertNotNull(this.transaction);
		this.addParameter("dataIn", request());
		this.transaction.execute();
	}

	private void addTable(final String key, final List<Map<String, Object>> table) {	
		ParameterTable parameterTable = new ParameterTable();		
		parameterTable.setParameterTableList(table);
		this.addParameter(key, parameterTable);		
	}
	
	private void addParameter(final String parameter, final Object value) {
		final TransactionParameter tParameter = new TransactionParameter(
				parameter, value);
		transaction.getContext().getParameterList().put(parameter, tParameter);
	}

	private Object getParameter(final String parameter) {
		final TransactionParameter param = transaction.getContext()
				.getParameterList().get(parameter);
		return param.getValue();
	}
	
	private Object getTableParameter(final int rowNumber, final String table, final String key)
	{
		ParameterTable param = (ParameterTable)getParameter(table);
		Map<String,Object> row = param.get(rowNumber);
		return row.get(key);
	}
	
	private PlacesDTO request() {
		PlacesDTO request = new PlacesDTO();
		request.setOrigins("Funza");
		request.setDestinations("Mosquera");
		return request;

	}	
}
