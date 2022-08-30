import { AxiosResponse } from "axios";
import Swal from "sweetalert2";
import http from "../http-common";
import ILogin from "../models/Login";

const login = async (data: ILogin):Promise<AxiosResponse|null > => {    

    try {
      const response = await http.post<ILogin>("/users/login", data);
      if(response.status === 200){
        Swal.fire({
          icon: 'success',
          title: 'Correcto',
          text: 'Inicio de sesion Correcto',
          confirmButtonText: 'Aceptar'    
        });
      }
      return response;
    } catch (err) {
      console.log(err);
      Swal.fire({
        icon: 'error',
        title: '¡Error!',
        text: 'Network Error',
        confirmButtonText: 'Aceptar'    
    
      });
      return null;
    }
  };

  const Login ={
    login
  }

export default Login;