import Swal from "sweetalert2";
import http from "../http-common";
import IReservacionData from "../models/Reservacion";

const create = async (data: IReservacionData) => {    
  try {
    const response = await http.post<IReservacionData>("/reservacion", data);
    if(response.status === 201){
      Swal.fire({
        icon: 'success',
        title: 'Correcto',
        text: 'La reservacion ha sido creado correctamente',
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
    return http.get<IReservacionData>(`/reservacion/${id}`);
};

const update = async (data: IReservacionData) => {
  try {    
    const response = await http.put<IReservacionData>(`/reservacion/${data.id}`, data);
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


const list = (page: number, size: number, sort? : String) => {
  const urlRequest : string = "/reservacion/" + page + "/" + size ;
  console.log(urlRequest);
  return http.get<Array<IReservacionData>>(urlRequest);
};

const count = async () =>  {  
  const response = await http.get<number>("/reservacion/count");
  return response.data;
};

const ReservacionService = {
  create,
  retrieve,
  update,
  remove,
  list,
  count

};
export default ReservacionService;