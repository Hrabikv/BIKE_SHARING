// src/components/MapPage.tsx
import React from 'react';
import { MapContainer, TileLayer, Marker, Popup,Polyline } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import L, { LatLngTuple } from 'leaflet';
import 'leaflet/dist/images/marker-icon.png';

export interface Location {
  longitude: number;
  latitude: number;
}

export interface MapObject {
  id: number;
  location: Location;
}
const bikeIcon = new L.Icon({
  iconUrl: 'https://cdn-icons-png.flaticon.com/512/3198/3198344.png ',
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  shadowSize: [41, 41],
  });


  const standIcon = new L.Icon({
    iconUrl: 'https://cdn5.vectorstock.com/i/1000x1000/87/99/bike-rent-stand-icon-outline-style-vector-27768799.jpg',
    iconSize: [25, 41],
    iconAnchor: [12, 41],
    popupAnchor: [1, -34],
    shadowSize: [41, 41],
  });



const MapPage: React.FC<{ bikeData: MapObject[], standData: MapObject[], paths?: LatLngTuple[] }> = ({ bikeData,standData,paths }) => {

  return (
    <MapContainer center={[51.505, -0.09]} zoom={13} scrollWheelZoom={false}>
  <TileLayer
    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
  />
   {bikeData.map((object) => (
        <Marker
          key={object.id}
          position={[object.location.latitude, object.location.longitude]}
          icon={bikeIcon}
        >
          <Popup>{`Bike id: ${object.id}. Location: ${object.location.longitude}, ${object.location.latitude}`}</Popup>
        </Marker>
      ))}

{standData.map((object) => (
        <Marker
          key={object.id}
          position={[object.location.latitude, object.location.longitude]}
          icon={standIcon}
        >
          <Popup>{`Stand id: ${object.id}. Location: ${object.location.longitude}, ${object.location.latitude}`}</Popup>
        </Marker>
      ))}{
        paths&&<Polyline pathOptions={{ color: 'blue' }} positions={paths} />
      }
      
</MapContainer>
  );
};

export default MapPage;