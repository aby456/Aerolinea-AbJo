import Swal from "sweetalert2";
import http from "../http-common";
import IServices from "../models/Servicio";

const create = async (data: IServices) => {    
  try {
    const response = await http.post<IServices>("/servicio", data);
    if(response.status === 201){
      Swal.fire({
        icon: 'success',
        title: 'Correcto',
        text: 'El Servicio ha sido creado correctamente',
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
    return http.get<IServices>(`/servicio/${id}`);
};

const update = async (data: IServices) => {
  try {    
    const response = await http.put<IServices>(`/servicio/${data.id}`, data);
    if(response.status === 200){
      Swal.fire({
        icon: 'success',
        title: 'Correcto',
        text: 'El Servicio ha sido actualizado',
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

const remove = async (id: number|null) => {
    try {
      const response = await  http.delete<string>(`/servicio/${id}`);
      if(response.status === 200){
        Swal.fire({
          icon: 'success',
          title: 'Correcto',
          text: 'El Servicio ha sido eliminado',
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


const list = ()=> {
  const urlRequest : string = "/servicio";
  return http.get<Array<IServices>>(urlRequest);
};

const ServicioService = {
  create,
  retrieve,
  update,
  remove,
  list

};
export default ServicioService;