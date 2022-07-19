import { ChangeEvent, useEffect, useState } from "react";
import { FaArrowLeft, FaSave } from "react-icons/fa";
import { Link, useNavigate, useParams } from "react-router-dom";
import IClienteModel from "../../models/Cliente";
import ClienteService from "../../services/ClienteService";

export const ClienteForm = () => {
	
  const { id }= useParams();
  let navigate = useNavigate();

    //Model vacío
    const initialClienteModel : IClienteModel = {
        id: null,
        nombre: "",
        telefono: "",
        direccion: "",
        email: "",
        password: ""
    };

    //Hooks para gestionar el modelo
    const [cliente, setCliente] = useState<IClienteModel>(initialClienteModel);
    
    //Escucha los cambios en cada control Input y los asigna a los valores del Modelo
    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setCliente({ ...cliente, [name]: value });
    };

    const saveCliente = () => {        
      if(cliente.id !== null)
      {
        ClienteService.update(cliente)
        .then((response: any) => {
          navigate("/reservacion/id/cliente");
          console.log(response.data);
        })
        .catch((e: Error) => {
          console.log(e);
        });
      }
      else
      {
            ClienteService.create(cliente)
          .then((response: any) => {    
            navigate("/reservacion/id/cliente");
            console.log(response.data);
          })
          .catch((e: Error) => {
            console.log(e);
          });
      }
    };

    useEffect(() => {
      if (id)
      getReservacion(id);
    }, [id]);


    const getReservacion = (id: any) => {
       ClienteService.retrieve(id)
        .then((response: any) => {
          setCliente(response.data); //Víncula el resultado del servicio con la función del Hook useState
          console.log(response.data);
        })
        .catch((e: Error) => {
          console.log(e);
        });
   };


		return ( //JSX
			<div className="submit-form">				
					<div>
						{ cliente.id !== null ? (<h1>Actualizado reservacion {cliente.nombre}</h1>) : (<h1>Registro de un Cliente</h1>) }            
						<div className="form-group">
						<label htmlFor="hora">Nombre Cliente</label>
            <input
              type="text"
							placeholder="Ingrese el nombre del Cliente"
              className="form-control"
              id="nombre"
              required
              value={cliente.nombre!}
              onChange={handleInputChange}
              name="cliente"
            />
						<label htmlFor="telefono">telefono</label>
            <input						
              type="text"
              className="form-control"
							placeholder="Ingrese el telefono del cliente"
              id="telefono"
              required
              value={cliente.telefono!}
              onChange={handleInputChange}
              name="lugar"
            />
						<label htmlFor="direccion">direccion </label>
            <input						
              type="text"
              className="form-control"
              placeholder="Ingrese la direccion"
              id="direccion"
              required
              value={cliente.direccion!}
              onChange={handleInputChange}
              name="direccion"
            />
						<label htmlFor="Email">Email</label>
            <input						
              type="text"
              className="form-control"
              placeholder="Ingrese el email"
              id="email"
              required
              value={cliente.email}
              onChange={handleInputChange}
              name="email"
            />
            <label htmlFor="password">Password</label>
            <input						
              type="text"
              className="form-control"
              placeholder="Ingrese una contrasena"
              id="password"
              required
              value={cliente.password}
              onChange={handleInputChange}
              name="password"
            />
						<br />
							<div className="btn-group" role="group">								
                <Link to={"/reservacion/cliente"} className="btn btn-primary">
                    <FaArrowLeft /> Volver
                </Link>
								<button type="button" onClick={saveCliente} className="btn btn-success">
                  <FaSave />Guardar
                </button>
							</div>
						</div>
					</div>				
			</div>        
    );

}