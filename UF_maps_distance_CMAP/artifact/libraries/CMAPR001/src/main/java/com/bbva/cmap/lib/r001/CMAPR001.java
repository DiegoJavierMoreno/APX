package com.bbva.cmap.lib.r001;

import com.bbva.cmap.dto.destination.OutDTO;
import com.bbva.cmap.dto.destination.PlacesDTO;

public interface CMAPR001 {

	OutDTO executeAPIMaps(PlacesDTO places);

}
