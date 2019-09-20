/**
 * 
 */
package com.bbva.cmap.dto.destination.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cmap.dto.destination.DistanceMatrixDTO;
import com.bbva.cmap.dto.destination.RowsDTO;

import junit.framework.Assert;

/**
 * @author DiegoJavier
 *
 */
public class DistanceMatrixDTOTest {

	DistanceMatrixDTO distanceMatrixDTO;
	List<String> places;
	List<RowsDTO> rows;
	
	@Before
	public void setUp() {
		distanceMatrixDTO = new DistanceMatrixDTO();
		places = new ArrayList<>();
		places.add("Funza");
		rows = new ArrayList<>();
		rows.add(new RowsDTO());
		distanceMatrixDTO.setOrigin_addresses(places);
		distanceMatrixDTO.setDestination_addresses(places);
		distanceMatrixDTO.setRows(rows);
	}
	
	@Test 
	public void testToString() {
		Assert.assertNotSame(distanceMatrixDTO.getDestination_addresses().get(0)+ distanceMatrixDTO.getOrigin_addresses().get(0) + distanceMatrixDTO.getRows().get(0), distanceMatrixDTO.toString()); 
	}
	
	@Test 
	public void testHashCode() {
		Assert.assertNotSame(new DistanceMatrixDTO().hashCode(), distanceMatrixDTO.hashCode()); 
	}
	
	@Test 
	public void testEquals() {
		Assert.assertEquals(distanceMatrixDTO.equals(distanceMatrixDTO), true);
		Assert.assertEquals(distanceMatrixDTO.equals(null), false);
		Assert.assertEquals(distanceMatrixDTO.equals(123), false);
		DistanceMatrixDTO objectOther = new DistanceMatrixDTO();
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		Assert.assertEquals(distanceMatrixDTO.equals(objectOther), false);
		objectOther.setDestination_addresses(null);
		distanceMatrixDTO.setDestination_addresses(null);
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		Assert.assertEquals(distanceMatrixDTO.equals(objectOther), false);
		distanceMatrixDTO.setDestination_addresses(places);
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		objectOther.setDestination_addresses(places);
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		objectOther.setDestination_addresses(distanceMatrixDTO.getDestination_addresses());
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		objectOther.setOrigin_addresses(null);
		distanceMatrixDTO.setOrigin_addresses(null);
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		Assert.assertEquals(distanceMatrixDTO.equals(objectOther), false);
		distanceMatrixDTO.setOrigin_addresses(places);
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		objectOther.setOrigin_addresses(places);
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
		objectOther.setOrigin_addresses(distanceMatrixDTO.getOrigin_addresses());
		Assert.assertEquals(objectOther.equals(distanceMatrixDTO), false);
	}

}
