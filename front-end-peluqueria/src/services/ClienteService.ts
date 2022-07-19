import Swal from "sweetalert2";
import http from "../http-common";
import IClienteData from "../models/Cliente";

const create = async (data: IClienteData) => {    
  try {
    const response = await http.post<IClienteData>("/reservacion/id/cliente", data);
    if(response.status === 201){
      Swal.fire({
        icon: 'success',
        title: 'Correcto',
        text: 'Cliente ha sido creado correctamente',
        confirmButtonText: 'Aceptar'    

      });
    }
    console.log(response);
  } catch (err) {
    console.log(err);
    Swal.fire({
      icon: 'error',
      title: '¡Error!',
      text: 'Network Error',
      confirmButtonText: 'Aceptar'    
    });
  }
};

const retrieve = async (id: number) => {
    return http.get<IClienteData>(`/reservacion/${id}`);
};

const update = async (data: IClienteData) => {
  try {    
    const response = await http.put<IClienteData>(`/reservacion/${data.id}`, data);
    if(response.status === 200){
      Swal.fire({
        icon: 'success',
        title: 'Correcto',
        text: 'La reservacion ha sido actualizado',
        confirmButtonText: 'Aceptar'    
      });
    }

  } catch (error) {
    Swal.fire({
      icon: 'error',
      title: '¡Error!',
      text: 'Network Error',
      confirmButtonText: 'Aceptar'    
    });
  }
    
};

const remove = async (id: number) => {
    try {
      const response = await  http.delete<string>(`/reservacion/${id}`);
      if(response.status === 200){
        Swal.fire({
          icon: 'success',
          title: 'Correcto',
          text: 'La reservacion ha sido eliminado',
          confirmButtonText: 'Aceptar'    
        });
      }
    } catch (error) {
      Swal.fire({
      icon: 'error',
      title: '¡Error!',
      text: 'Network Error',
      confirmButtonText: 'Aceptar'    
    });
    }

};


const list = (page: number, size: number) => {
  const urlRequest : string = "/reservacion/" + page + "/" + size ;
  console.log(urlRequest);
  return http.get<Array<IClienteData>>(urlRequest);
};


const ReservacionService = {
  create,
  retrieve,
  update,
  remove,
  list

};
export default ReservacionService;