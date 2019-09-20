/**
 * 
 */
package com.bbva.cmap.dto.destination.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cmap.dto.destination.DescriptorDTO;
import com.bbva.cmap.dto.destination.DistanceMatrixDTO;
import com.bbva.cmap.dto.destination.ElementsDTO;
import com.bbva.cmap.dto.destination.RowsDTO;

import junit.framework.Assert;

/**
 * @author DiegoJavier
 *
 */
public class ElementsDTOTest {

	ElementsDTO elementsDTO;
	DescriptorDTO distance;
	DescriptorDTO duration;
	
	@Before
	public void setUp() {
		elementsDTO = new ElementsDTO();
		distance = new DescriptorDTO();
		duration = new DescriptorDTO();
		distance.setText("COP");
		distance.setValue((long)300);
		elementsDTO.setDistance(distance);
		duration.setText("1 hour");
		duration.setValue((long)3600);
		elementsDTO.setDuration(duration);
		elementsDTO.setStatus("OK");
	}
	
	@Test 
	public void testToString() {
		Assert.assertNotSame(elementsDTO.getStatus() + elementsDTO.getDistance() + elementsDTO.getDuration(), elementsDTO.toString()); 
	}
	
	@Test 
	public void testHashCode() {
		Assert.assertNotSame(new ElementsDTO().hashCode(), elementsDTO.hashCode()); 
	}
	
	@Test 
	public void testEquals() {
		Assert.assertEquals(elementsDTO.equals(elementsDTO), true);
		Assert.assertEquals(elementsDTO.equals(null), false);
		Assert.assertEquals(elementsDTO.equals(123), false);
		ElementsDTO objectOther = new ElementsDTO();
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		Assert.assertEquals(elementsDTO.equals(objectOther), false);
		objectOther.setDistance(null);
		elementsDTO.setDistance(null);
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		Assert.assertEquals(elementsDTO.equals(objectOther), false);
		distance.setValue((long)34);
		elementsDTO.setDistance(distance);
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		distance.setValue((long)45);
		objectOther.setDistance(distance);
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		objectOther.setDistance(elementsDTO.getDistance());
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		objectOther.setDuration(null);
		elementsDTO.setDuration(null);
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		Assert.assertEquals(elementsDTO.equals(objectOther), false);
		duration.setValue((long)8);
		elementsDTO.setDuration(duration);
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		duration.setValue((long)3);
		objectOther.setDuration(duration);
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		objectOther.setDuration(elementsDTO.getDuration());
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		objectOther.setStatus(null);
		elementsDTO.setStatus(null);
		Assert.assertEquals(objectOther.equals(elementsDTO), true);
		Assert.assertEquals(elementsDTO.equals(objectOther), true);
		elementsDTO.setStatus("FAILED");
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		objectOther.setStatus("BUSSY");
		Assert.assertEquals(objectOther.equals(elementsDTO), false);
		objectOther.setStatus(elementsDTO.getStatus());
		Assert.assertEquals(objectOther.equals(elementsDTO), true);		
	}

}
