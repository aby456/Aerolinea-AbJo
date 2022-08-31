import { useEffect, useState } from "react";
import { FaArrowLeft, FaArrowRight, FaTrash } from "react-icons/fa";
import { Link } from 'react-router-dom';
import { useParams } from "react-router-dom";
import IReservacionModel from "../../models/Reservacion";
import ReservacionService from "../../services/ReservacionServices";

export const ReservacionCard = () => {
  const { id }= useParams();

  const [reservacion, setReservacion] = useState<IReservacionModel>();
  useEffect(() => {
    if (id)
      getReservacion(id);
  }, [id]);


  const getReservacion = (id: any) => {
    ReservacionService.retrieve(id)
      .then((response: any) => {
        setReservacion(response.data); //Víncula el resultado del servicio con la función del Hook 
        console.log(response.data);
      })
      .catch((e: Error) => {
        console.log(e);
      });
 };

    return (
      <div>
      { 
        reservacion ? (
          <div>          
          <ul>
            <li> <strong>Hora :</strong>{reservacion.horario}</li>
            <li>Lugar : {reservacion.lugar}</li>
            <li>Fecha : {reservacion.fecha}</li>
            <li>Disponibilidad : {reservacion.cantidadPersona}</li>
          </ul>
          <br />
							<div className="btn-group" role="group">								
                <Link to={"/reservacion"} className="btn btn-primary">
                    <FaArrowLeft /> Volver
                </Link>
                <Link to={"/reservacion/retrieve/"+reservacion.id+"/servicio"} className="btn btn-primary">
                    Agregar Servicio <FaArrowRight />
                </Link>
							</div>
          </div>

        ) : 
        ( 
          <h1>No hay una reservacion activa</h1>
        )
      }
      </div>
    );
}