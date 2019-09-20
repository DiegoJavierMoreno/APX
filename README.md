# APX
Backend Extended Platform

## 1. UF_maps_distance_CMAP
Project for connection with Google API about reference maps employing APX.
In APX Online, a transaction was created that receives 2 points on the map (Eg Origin: "Bogota DC", Destination: "Funza") and through a call to the Google Maps API, returns the distance and time it takes each route, you must also return a value that represents the cost per kilometer traveled, in this way you must calculate the rate and add it to the output fields.

### URL:

``` json
http://127.0.0.1:8101/APX_Runtime_Online/PGRestService/CMAPT001/01/CO
```

### Request:

``` json
{
	"places": {
		"origins": "Mosquera",
		"destinations": "Villavicencio"
	}
}
```

### Response:

``` json
{
    "data": {
        "trip": {
            "duration": {
                "text": "8 hours 44 mins",
                "value": 31463
            },
            "fare": {
                "text": "COP",
                "value": 119332
            },
            "distance": {
                "text": "314 km",
                "value": 314032
            }
        }
    }
}
```
