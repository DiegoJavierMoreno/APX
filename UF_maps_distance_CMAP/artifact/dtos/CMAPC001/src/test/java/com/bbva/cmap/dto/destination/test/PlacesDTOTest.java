/**
 * 
 */
package com.bbva.cmap.dto.destination.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cmap.dto.destination.DescriptorDTO;
import com.bbva.cmap.dto.destination.OutDTO;
import com.bbva.cmap.dto.destination.PlacesDTO;

import junit.framework.Assert;

/**
 * @author DiegoJavier
 *
 */
public class PlacesDTOTest {

	PlacesDTO placesDTO;
	
	@Before
	public void setUp() {
		placesDTO = new PlacesDTO();
		placesDTO.setOrigins("Neiva");
		placesDTO.setDestinations("Tunja");
	}
	
	@Test 
	public void testToString() {
		Assert.assertNotSame(placesDTO.getOrigins() + placesDTO.getDestinations(), placesDTO.toString()); 
	}
	
	@Test 
	public void testHashCode() {
		Assert.assertNotSame(new PlacesDTO().hashCode(), placesDTO.hashCode()); 
	}
	
	@Test 
	public void testEquals() {
		Assert.assertEquals(placesDTO.equals(placesDTO), true);
		Assert.assertEquals(placesDTO.equals(null), false);
		Assert.assertEquals(placesDTO.equals(123), false);
		PlacesDTO objectOther = new PlacesDTO();
		Assert.assertEquals(objectOther.equals(placesDTO), false);
		Assert.assertEquals(placesDTO.equals(objectOther), false);
		objectOther.setDestinations(null);
		placesDTO.setDestinations(null);
		Assert.assertEquals(objectOther.equals(placesDTO), false);
		Assert.assertEquals(placesDTO.equals(objectOther), false);
		placesDTO.setDestinations("Laguna de Tota");
		Assert.assertEquals(objectOther.equals(placesDTO), false);
		objectOther.setDestinations("Raquira");
		Assert.assertEquals(objectOther.equals(placesDTO), false);
		objectOther.setDestinations(placesDTO.getDestinations());
		Assert.assertEquals(objectOther.equals(placesDTO), false);
		objectOther.setOrigins(null);
		placesDTO.setOrigins(null);
		Assert.assertEquals(objectOther.equals(placesDTO), true);
		Assert.assertEquals(placesDTO.equals(objectOther), true);
		placesDTO.setOrigins("Tolemaida");
		Assert.assertEquals(objectOther.equals(placesDTO), false);
		objectOther.setOrigins("Nobsa");
		Assert.assertEquals(objectOther.equals(placesDTO), false);
		objectOther.setOrigins(placesDTO.getOrigins());
		Assert.assertEquals(objectOther.equals(placesDTO), true);		
	}
}
