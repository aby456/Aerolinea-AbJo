import { useReservation } from "../../hooks/useReservation";
import { Link, useNavigate } from "react-router-dom";
import { FaEye, FaPen, FaTrash } from "react-icons/fa";
import { memo, useContext, useState } from "react";
import Pagination from "../Pagination";
import ItemContext from "../../contexts/PaginationContext";
import { Loading } from "../Loading";
import IReservation from "../../models/Reservacion";
import Swal from "sweetalert2";
import ReservacionService from "../../services/ClienteService";

export const ReservacionList = memo(() => {
  const { page }: any = useContext(ItemContext);
  const { item }: any = useContext(ItemContext);
  const { reservations, loading } = useReservation(page, item);
  const [reservationsList, setReservationsList] = useState<IReservation[]>([]);
  const [valorEncontrado, setValorEncontrado] = useState<boolean>(true);
  const navigate = useNavigate();
  let reservacionesFiltradas: IReservation[] = [];
    
  const listaCabecera = [
    "id",
    "Hora",
    "Lugar",
    "Fecha",
    "Disponibilidad",
    "Acciones",
  ];
  const handleChangeBuscar = (event: any) => {
    //Filtrar por el valor del input
    const buscar = event.target.value;
    if(buscar === ""){
        setReservationsList(reservations);
        setValorEncontrado(true);
    }   
    else{
        reservacionesFiltradas = reservations.filter((reservacion: IReservation) => {
            return reservacion.hora?.includes(buscar);
          });
        setReservationsList(reservacionesFiltradas);
        if(reservacionesFiltradas.length === 0){
            setValorEncontrado(false);
        }else{
            setValorEncontrado(true);
        }
    }
  };

  const removeReservacion = (id: number) => {
    Swal.fire({
        title: '¿Desea eliminar la reservacion?',
        showDenyButton: true,
        confirmButtonText: 'Si',
        denyButtonText: 'No',
      }).then((result) => {            
        if (result.isConfirmed) {
            ReservacionService.remove(id)
            .then((response: any) => {
                navigate("/");
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
                {(reservationsList.length!==0?reservationsList:reservations).map((reservacion: any, index: any) => (
                  <tr key={index}>
                    <td>{reservacion.id}</td>
                    <td>{reservacion.hora}</td>
                    <td>{reservacion.lugar}</td>
                    <td>{reservacion.fecha}</td>
                    <td>{reservacion.disponibilidad}</td>
                    <td>
                      <div className="btn-group" role="group">
                        <Link
                          to={"/reservacion/retrieve/" + reservacion.id}
                          className="btn btn-warning"
                        >
                          <FaEye /> Ver
                        </Link>
                        <Link
                          to={"/reservacion/update/" + reservacion.id}
                          className="btn btn-primary"
                        >
                          <FaPen /> Editar
                        </Link>
                        <button
                          className="btn btn-danger"
                          onClick={() => removeReservacion(reservacion.id)}
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
            <Pagination />
          </div>
        </div>
      </div>
    </div>
  );
});
