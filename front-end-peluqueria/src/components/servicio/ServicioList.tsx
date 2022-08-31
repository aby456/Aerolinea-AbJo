import React, {useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';
import { useService } from '../../hooks/useServicio';
import ServiciosService from '../../services/ServicioService';
import IServicio from '../../models/Servicio';
import { Loading } from '../Loading';
import Swal from "sweetalert2";
import { FaEye, FaPen, FaTrash } from 'react-icons/fa';


const ServicioList = () => {
  const {id} = useParams();
  let idReservacion:number=0; 
  if(id){
    idReservacion = parseInt(id);
  }
  const { services, loading } = useService(idReservacion);
  const [serviceList, setServiceList] = useState<IServicio[]>([]);
  const [valorEncontrado, setValorEncontrado] = useState<boolean>(true);
  const navigate = useNavigate();
  let servicesFiltradas: IServicio[] = [];
    
  const listaCabecera = [
    "id",
    "Nombre",
    "Precio",
    "Tiempo Estimado",
    "Acciones",
  ];
  const handleChangeBuscar = (event: any) => {
    //Filtrar por el valor del input
    const buscar = event.target.value;
    console.log(services)
    if(buscar === ""){
        setServiceList(services);
        setValorEncontrado(true);
    }   
    else{
      servicesFiltradas = services.filter((servicio: IServicio) => {
            return servicio.nombreServicio?.includes(buscar);
          });
        setServiceList(servicesFiltradas);
        if(servicesFiltradas.length === 0){
            setValorEncontrado(false);
        }else{
            setValorEncontrado(true);
        }
    }
  };

  const removeServicio = (id: number|null) => {
    Swal.fire({
        title: '¿Desea eliminar la reservacion?',
        showDenyButton: true,
        confirmButtonText: 'Si',
        denyButtonText: 'No',
      }).then((result) => {            
        if (result.isConfirmed) {
            ServiciosService.remove(idReservacion,id)
            .then((response: any) => {
                navigate("/reservacion/retrieve/"+id+"/servicio");
            })
            .catch((e: Error) => {
              console.log(e);
            });      

        }
      });        
 };

  if (loading) {
    return <Loading />;
  }
  return (
    <div>
      <div className='d-flex justify-content-end'>
        <Link to={"/reservacion/retrieve/" + idReservacion+"/servicio/create"} className='btn btn-success'>Agregar</Link>
      </div>
      <div className="form-group m-3">
        <input
          type="text"
          className="form-control"
          placeholder="Filtrar..."
          onChange={handleChangeBuscar}
        />
      </div>

      <div className="list row">
        <div className="col-md-12">
          {
            valorEncontrado ? (
                <table className="table">
            <thead>
              <tr>
                {listaCabecera.map((cabecera, index) => (
                  <th key={index}>{cabecera}</th>
                ))}
              </tr>
            </thead>
            {
              <tbody>
                {(serviceList.length!==0?serviceList:services).map((service: IServicio, index: any) => (
                  <tr key={index}>
                    <td>{service.id}</td>
                    <td>{service.nombreServicio}</td>
                    <td>{service.precioServicio}</td>
                    <td>{service.tiempoEstimadoServicio}</td>
                    <td>
                      <div className="btn-group" role="group">
                        <Link
                          to={"/reservacion/retrieve/" + idReservacion+"/servicio/retrieve/"+service.id}
                          className="btn btn-warning"
                        >
                          <FaEye /> Ver
                        </Link>
                        <Link
                          to={"/reservacion/retrieve/" + idReservacion+"/servicio/update/" + service.id}
                          className="btn btn-primary"
                        >
                          <FaPen /> Editar
                        </Link>
                        <button
                          className="btn btn-danger"
                          onClick={() => removeServicio(service.id)}
                        >
                          <FaTrash /> Eliminar
                        </button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            }
          </table>
            ) : (
                <div className="alert alert-danger" role="alert">
                    No se encontraron resultados
                </div>
            )
          }
          <div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ServicioList