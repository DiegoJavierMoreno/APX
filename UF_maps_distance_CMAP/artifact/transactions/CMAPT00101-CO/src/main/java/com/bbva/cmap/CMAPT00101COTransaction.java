package com.bbva.cmap;
import com.bbva.cmap.dto.destination.DistanceMatrixDTO;
import com.bbva.cmap.dto.destination.OutDTO;
import com.bbva.cmap.dto.destination.PlacesDTO;
import com.bbva.cmap.lib.r001.CMAPR001;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;

/**
 * Tx execute Distance Matrix API Google
 * Implementacion de logica de negocio.
 * @author DiegoJavier
 *
 */
public class CMAPT00101COTransaction extends AbstractCMAPT00101COTransaction {

	@Override
	public void execute() {
		CMAPR001 cmapR001 = (CMAPR001)getServiceLibrary(CMAPR001.class);
		OutDTO responseBusiness;
		PlacesDTO requestBusiness;
		
		requestBusiness = this.getPlaces();
		responseBusiness = cmapR001.executeAPIMaps(requestBusiness);
		
		this.setContentLocation(getURIPath());
		this.setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
		this.setTrip(responseBusiness);
	}

}
