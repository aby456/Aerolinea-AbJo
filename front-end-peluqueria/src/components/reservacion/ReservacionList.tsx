import { FaPen, FaEye, FaTrash, FaPlus } from "react-icons/fa";
import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom';
import IReservacionModel from '../../models/Reservacion';
import ReservacionService from '../../services/ReservacionServices';
import Swal from "sweetalert2";
import ReactPaginate from "react-paginate";

export const ReservacionList = () => {

    //Hook: Define un atributo y la función que lo va a actualizar
    const [reservacion, setReservacion] = useState<Array<IReservacionModel>>([]);
    const [itemsCount, setItemsCount] = useState<number>(0);
    const [pageCount, setPageCount] = useState(0);
    const [itemsPerPage, setItemsPerPage] = useState(5);
    
    //Hook para llamar a la Web API
    useEffect(() => {
      getItems();  
      listReservacion(0, itemsPerPage);           
      }, []);

    const handlePageClick = (event: any) => {        
      const numberPage = event.selected;                   
      listReservacion(numberPage, itemsPerPage);
    };

    //Función que llama al Service para listar los datos desde la Web API
    const listReservacion = (page: number, size: number) => {
        ReservacionService.list(page, size)
         .then((response: any) => {
           setReservacion(response.data); //Víncula el resultado del servicio con la función del Hook useState
           console.log(response.data);
         })
         .catch((e: Error) => {
           console.log(e);
         });
    };

    const getItems = () => {
      ReservacionService.count().then((response: any) =>{
        var itemsCount = response;
        setItemsCount(itemsCount);
        setPageCount(Math.ceil(itemsCount/ itemsPerPage));           
        setItemsPerPage(5)
        console.log(response);
      }).catch((e : Error)=> {
        console.log(e);
      });
    }

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
                  listReservacion(0,itemsPerPage);
                  console.log(response.data);
                })
                .catch((e: Error) => {
                  console.log(e);
                });      

            }
          });        
     };
   
    return ( 
        <div className='list row'>
            <h1>Hay {itemsCount} Reservaciones</h1>
            <div className='col-md-12'>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>hora</th>
                            <th>lugar</th>
                            <th>fecha</th>
                            <th>disponibilidad</th>
                            <th>
                              <Link to={"/reservacion/create"} className="btn btn-success">
                                  <FaPlus /> Agregar
                              </Link>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {reservacion && reservacion.map((Reservacion, index) => (                          
                            <tr key={index}>
                                <td>{++index}</td>
                                <td>{Reservacion.hora}</td>
                                <td>{Reservacion.lugar}</td>
                                <td>{Reservacion.fecha}</td>
                                <td>{Reservacion.disponibilidad}</td>
                                <td>
                        
                                <div className="btn-group" role="group">
                                <Link to={"/reservacion/retrieve/" + Reservacion.id} className="btn btn-warning">
                                    <FaEye /> Ver
                                  </Link>                                  
                                  <Link to={"/reservacion/update/" + Reservacion.id} className="btn btn-primary">
                                      <FaPen /> Editar
                                  </Link>

                                  <button className="btn btn-danger" onClick={() => removeReservacion(Reservacion.id!)}>
                                    <FaTrash /> Eliminar
                                  </button>

                                  
                                </div>
                                    
                                </td>
                            </tr>                        
                        ))}
                    </tbody>
                </table>

                <ReactPaginate
                  className="pagination"
                  breakLabel="..."
                  nextLabel=">"
                  onPageChange={handlePageClick}
                  pageRangeDisplayed={5}
                  pageCount={pageCount}
                  previousLabel="<"/>

            </div>            
        </div>
     );
}