import { FaPen, FaEye, FaTrash, FaPlus } from "react-icons/fa";
import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom';
import IClienteModel from '../../models/Cliente';
import ClienteService from '../../services/ClienteService';
import Swal from "sweetalert2";
import ReactPaginate from "react-paginate";

export const ClienteList = () => {

    //Hook: Define un atributo y la función que lo va a actualizar
    const [cliente, setCliente] = useState<Array<IClienteModel>>([]);
    const [itemsCount, setItemsCount] = useState<number>(0);
    const [pageCount, setPageCount] = useState(0);
    const [itemsPerPage, setItemsPerPage] = useState(5);
    
    //Hook para llamar a la Web API
    useEffect(() => {
      listCliente(0, itemsPerPage);           
      }, []);

    const handlePageClick = (event: any) => {        
      const numberPage = event.selected;                   
      listCliente(numberPage, itemsPerPage);
    };

    //Función que llama al Service para listar los datos desde la Web API
    const listCliente = (page: number, size: number) => {
        ClienteService.list(page, size)
         .then((response: any) => {
           setCliente(response.data); //Víncula el resultado del servicio con la función del Hook useState
           console.log(response.data);
         })
         .catch((e: Error) => {
           console.log(e);
         });
    };


    const removeCliente = (id: number) => {
        Swal.fire({
            title: '¿Desea eliminar la reservacion?',
            showDenyButton: true,
            confirmButtonText: 'Si',
            denyButtonText: 'No',
          }).then((result) => {            
            if (result.isConfirmed) {
                ClienteService.remove(id)
                .then((response: any) => {
                  listCliente(0,itemsPerPage);
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
            <h1>Hay {itemsCount} Cliente</h1>
            <div className='col-md-12'>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>direccion</th>
                            <th>email</th>
                            <th>Password</th>
                            <th>
                              <Link to={"/cliente/create"} className="btn btn-success">
                                  <FaPlus /> Agregar
                              </Link>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {cliente && cliente.map((Cliente, index) => (                          
                            <tr key={index}>
                                <td>{++index}</td>
                                <td>{Cliente.nombre}</td>
                                <td>{Cliente.telefono}</td>
                                <td>{Cliente.direccion}</td>
                                <td>{Cliente.email}</td>
                                <td>{Cliente.password}</td>
                                <td>
                        
                                <div className="btn-group" role="group">
                                <Link to={"/reservacion/retrieve/" + Cliente.id} className="btn btn-warning">
                                    <FaEye /> Ver
                                  </Link>                                  
                                  <Link to={"/reservacion/update/" + Cliente.id} className="btn btn-primary">
                                      <FaPen /> Editar
                                  </Link>

                                  <button className="btn btn-danger" onClick={() => removeCliente(Cliente.id!)}>
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