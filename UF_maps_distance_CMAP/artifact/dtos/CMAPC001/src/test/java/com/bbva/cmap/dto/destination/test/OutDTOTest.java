/**
 * 
 */
package com.bbva.cmap.dto.destination.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cmap.dto.destination.DescriptorDTO;
import com.bbva.cmap.dto.destination.ElementsDTO;
import com.bbva.cmap.dto.destination.OutDTO;

import junit.framework.Assert;

/**
 * @author DiegoJavier
 *
 */
public class OutDTOTest {

	OutDTO outDTO;
	DescriptorDTO distance;
	DescriptorDTO duration;
	DescriptorDTO fare;
	
	@Before
	public void setUp() {
		outDTO = new OutDTO();
		distance = new DescriptorDTO();
		duration = new DescriptorDTO();
		fare = new DescriptorDTO();
		distance.setText("3 km");
		distance.setValue((long)300);
		outDTO.setDistance(distance);
		duration.setText("1 hour");
		duration.setValue((long)3600);
		outDTO.setDuration(duration);
		fare.setText("COP");
		fare.setValue((long)46000);
		outDTO.setFare(fare);
	}
	
	@Test 
	public void testToString() {
		Assert.assertNotSame(outDTO.getDistance().toString() + outDTO.getDuration() + outDTO.getFare(), outDTO.toString()); 
	}
	
	@Test 
	public void testHashCode() {
		Assert.assertNotSame(new OutDTO().hashCode(), outDTO.hashCode()); 
	}
	
	@Test 
	public void testEquals() {
		Assert.assertEquals(outDTO.equals(outDTO), true);
		Assert.assertEquals(outDTO.equals(null), false);
		Assert.assertEquals(outDTO.equals(123), false);
		OutDTO objectOther = new OutDTO();
		Assert.assertEquals(objectOther.equals(outDTO), false);
		Assert.assertEquals(outDTO.equals(objectOther), false);
		objectOther.setDistance(null);
		outDTO.setDistance(null);
		Assert.assertEquals(objectOther.equals(outDTO), false);
		Assert.assertEquals(outDTO.equals(objectOther), false);
		distance.setValue((long)34);
		outDTO.setDistance(distance);
		Assert.assertEquals(objectOther.equals(outDTO), false);
		distance.setValue((long)45);
		objectOther.setDistance(distance);
		Assert.assertEquals(objectOther.equals(outDTO), false);
		objectOther.setDistance(outDTO.getDistance());
		Assert.assertEquals(objectOther.equals(outDTO), false);
		objectOther.setDuration(null);
		outDTO.setDuration(null);
		Assert.assertEquals(objectOther.equals(outDTO), false);
		Assert.assertEquals(outDTO.equals(objectOther), false);
		duration.setValue((long)8);
		outDTO.setDuration(duration);
		Assert.assertEquals(objectOther.equals(outDTO), false);
		duration.setValue((long)3);
		objectOther.setDuration(duration);
		Assert.assertEquals(objectOther.equals(outDTO), false);
		objectOther.setDuration(outDTO.getDuration());
		Assert.assertEquals(objectOther.equals(outDTO), false);
		objectOther.setFare(null);
		outDTO.setFare(null);
		Assert.assertEquals(objectOther.equals(outDTO), true);
		Assert.assertEquals(outDTO.equals(objectOther), true);
		fare.setValue((long)45000);
		outDTO.setFare(fare);
		Assert.assertEquals(objectOther.equals(outDTO), false);
		objectOther.setFare(fare);
		Assert.assertEquals(objectOther.equals(outDTO), true);
		objectOther.setFare(outDTO.getFare());
		Assert.assertEquals(objectOther.equals(outDTO), true);		
	}

}
