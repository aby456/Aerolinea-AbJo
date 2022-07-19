import { useEffect, useState } from "react";
import { FaArrowLeft, FaTrash } from "react-icons/fa";
import { Link } from 'react-router-dom';
import { useParams } from "react-router-dom";
import IClienteModel from "../../models/Cliente";
import ClienteService from "../../services/ClienteService";

export const ClienteCard = () => {
  const { id }= useParams();

  const [cliente, setCliente] = useState<IClienteModel>();

  useEffect(() => {
    if (id)
      getCliente(id);
  }, [id]);


  const getCliente = (id: any) => {
    ClienteService.retrieve(id)
      .then((response: any) => {
        setCliente(response.data); //Víncula el resultado del servicio con la función del Hook useState
        console.log(response.data);
      })
      .catch((e: Error) => {
        console.log(e);
      });
 };

    return (
      <div>
      { 
        cliente ? (
          <div>          
          <ul>
            <li> <strong>nombre :</strong>  {cliente.nombre}</li>
            <li>Telefono : {cliente.telefono}</li>
            <li>direccion : {cliente.direccion}</li>
            <li>Email : {cliente.email}</li>
            <li>Password : {cliente.password}</li>
          </ul>
          <br />
							<div className="btn-group" role="group">								
                <Link to={"/reservacion"} className="btn btn-primary">
                    <FaArrowLeft /> Volver
                </Link>
								<button type="button" className="btn btn-danger">
                  <FaTrash />Eliminar
                </button>
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