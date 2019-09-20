/**
 * 
 */
package com.bbva.cmap.dto.destination.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cmap.dto.destination.DescriptorDTO;

import junit.framework.Assert;

/**
 * @author DiegoJavier
 *
 */
public class DescriptorDTOTest {

	DescriptorDTO descriptorDTO;
	
	@Before
	public void setUp() {
		descriptorDTO = new DescriptorDTO();
		descriptorDTO.setValue((long)1000);
		descriptorDTO.setText("COP");
	}
	
	@Test 
	public void testToString() {
		Assert.assertNotSame(descriptorDTO.getText() + descriptorDTO.getValue(), descriptorDTO.toString()); 
	}
	
	@Test 
	public void testHashCode() {
		Assert.assertNotSame(new DescriptorDTO().hashCode(), descriptorDTO.hashCode()); 
	}
	
	@Test 
	public void testEquals() {
		Assert.assertEquals(descriptorDTO.equals(descriptorDTO), true);
		Assert.assertEquals(descriptorDTO.equals(null), false);
		Assert.assertEquals(descriptorDTO.equals(123), false);
		DescriptorDTO objectOther = new DescriptorDTO();
		Assert.assertEquals(objectOther.equals(descriptorDTO), false);
		Assert.assertEquals(descriptorDTO.equals(objectOther), false);
		objectOther.setText(null);
		descriptorDTO.setText(null);
		Assert.assertEquals(objectOther.equals(descriptorDTO), false);
		Assert.assertEquals(descriptorDTO.equals(objectOther), false);
		descriptorDTO.setText("US");
		Assert.assertEquals(objectOther.equals(descriptorDTO), false);
		objectOther.setText("EUR");
		Assert.assertEquals(objectOther.equals(descriptorDTO), false);
		objectOther.setText(descriptorDTO.getText());
		Assert.assertEquals(objectOther.equals(descriptorDTO), false);
		objectOther.setValue(null);
		descriptorDTO.setValue(null);
		Assert.assertEquals(objectOther.equals(descriptorDTO), true);
		Assert.assertEquals(descriptorDTO.equals(objectOther), true);
		descriptorDTO.setValue((long)300);
		Assert.assertEquals(objectOther.equals(descriptorDTO), false);
		objectOther.setValue((long)400);
		Assert.assertEquals(objectOther.equals(descriptorDTO), false);
		objectOther.setValue(descriptorDTO.getValue());
		Assert.assertEquals(objectOther.equals(descriptorDTO), true);
	}

}
