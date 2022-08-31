import { useEffect, useState } from "react";
import { FaArrowLeft} from "react-icons/fa";
import { Link } from 'react-router-dom';
import { useParams } from "react-router-dom";
import IServicio from "../../models/Servicio";
import ServicioService from "../../services/ServicioService";

export const ServicioCard = () => {
  const { id,idServicio }= useParams();
  const [servicio, setServicio] = useState<IServicio>();
  useEffect(() => {
    if (idServicio)
      getReservacion(id,idServicio);
  }, [id, idServicio]);


  const getReservacion = (id: any, idServicio:any) => {
    ServicioService.retrieve(id, idServicio)
      .then((response: any) => {
        setServicio(response.data); //Víncula el resultado del servicio con la función del Hook 
      })
      .catch((e: Error) => {
        console.log(e);
      });
 };

    return (
      <div>
      { 
        servicio ? (
          <div>          
          <ul>
            <li> <strong>Nombre :</strong>{servicio.nombreServicio}</li>
            <li>Precio : {servicio.precioServicio}</li>
            <li>Tiempo Estimado : {servicio.tiempoEstimadoServicio}</li>
          </ul>
          <br />
							<div className="btn-group" role="group">								
                <Link to={"/reservacion/retrieve/"+id+"/servicio"} className="btn btn-primary">
                    <FaArrowLeft /> Volver
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