import { ChangeEvent, useEffect, useState } from "react";
import { FaArrowLeft, FaSave } from "react-icons/fa";
import { Link, useNavigate, useParams } from "react-router-dom";
import IServicio from "../../models/Servicio";
import ServicioService from "../../services/ServicioService";

export const ServicioForm = () => {
  const { id, idServicio }= useParams();
  let idService:number = 0;
  if(idServicio)
  {
    idService = parseInt(idServicio);

  }
  let navigate = useNavigate();

    //Model vacío
    const initialServicioModel : IServicio = {
        id: null,
        nombreServicio: "12344",
        precioServicio: 1,
        tiempoEstimadoServicio: 1,
        reservacion: null
    };

    //Hooks para gestionar el modelo
    const [servicio, setServicio] = useState<IServicio>(initialServicioModel);
    
    //Escucha los cambios en cada control Input y los asigna a los valores del Modelo
    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setServicio({ ...servicio, [name]: value });
    };

    const saveReservacion = () => {        
      if(servicio.id !== null)
      {
        ServicioService.update(servicio, id)
        .then((response: any) => {
          navigate("/reservacion/retrieve/"+id+"/servicio");
          console.log(response.data);
        })
        .catch((e: Error) => {
          console.log(e);
        });
      }
      else
      {
          ServicioService.create(servicio, id)
          .then((response: any) => {    
            navigate("/reservacion/retrieve/"+id+"/servicio");
            console.log(response.data);
          })
          .catch((e: Error) => {
            console.log(e);
          });
      }
    };

    useEffect(() => {
      if (idService)
        getReservacion(id, idService);
    }, [id,idServicio, idService]);


    const getReservacion = (id: any, idService:any) => {
       ServicioService.retrieve(id, idService)
        .then((response: any) => {
          setServicio(response.data); //Víncula el resultado del servicio con la función del Hook useState
          console.log(response.data);
        })
        .catch((e: Error) => {
          console.log(e);
        });
   };

		return ( //JSX
			<div className="submit-form">				
					<div>
						{ servicio.id !== null ? (<h1>Actualizado Servicio</h1>) : (<h1>Registro de un Servicio</h1>) }            
						<div className="form-group">
						<label htmlFor="horario">Nombre de Servicio</label>
            <input
              type="text"
							placeholder="Ingrese el Nombre del Servicio"
              className="form-control"
              id="nombreServicio"
              required
              value={servicio.nombreServicio!}
              onChange={handleInputChange}
              name="nombreServicio"
            />
						<label htmlFor="lugar">Precio del Servicio</label>
            <input						
              type="text"
              className="form-control"
							placeholder="Ingrese el precio del Servicio"
              id="precioServicio"
              required
              value={servicio.precioServicio!}
              onChange={handleInputChange}
              name="precioServicio"
            />
						<label htmlFor="fecha">Tiempo Estimado </label>
            <input						
              type="text"
              className="form-control"
              placeholder="Ingrese el Tiempo estimado del Servicio"
              id="fecha"
              required
              value={servicio.tiempoEstimadoServicio!}
              onChange={handleInputChange}
              name="tiempoEstimadoServicio"
            />
						<br />
							<div className="btn-group" role="group">								
                <Link to={"/reservacion/retrieve/"+id+"/servicio"} className="btn btn-primary">
                    <FaArrowLeft /> Volver
                </Link>
								<button type="button" onClick={saveReservacion} className="btn btn-success">
                  <FaSave />Guardar
                </button>
							</div>
						</div>
					</div>				
			</div>        
    );

}