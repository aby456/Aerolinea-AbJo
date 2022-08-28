import { ChangeEvent, useEffect, useState } from "react";
import { FaArrowLeft, FaSave } from "react-icons/fa";
import { Link, useNavigate, useParams } from "react-router-dom";
import IReservacionModel from "../../models/Reservacion";
import ReservacionService from "../../services/ReservacionServices";

export const ReservacionForm = () => {
	
  const { id }= useParams();
  let navigate = useNavigate();

    //Model vacío
    const initialReservacionModel : IReservacionModel = {
        id: null,
        horario: "",
        lugar: "",
        fecha: "",
        cantidadPersona: 2
    };

    //Hooks para gestionar el modelo
    const [reservacion, setReservacion] = useState<IReservacionModel>(initialReservacionModel);
    
    //Escucha los cambios en cada control Input y los asigna a los valores del Modelo
    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setReservacion({ ...reservacion, [name]: value });
    };


    const saveReservacion = () => {        
      if(reservacion.id !== null)
      {
        ReservacionService.update(reservacion)
        .then((response: any) => {
          navigate("/reservacion");
          console.log(response.data);
        })
        .catch((e: Error) => {
          console.log(e);
        });
      }
      else
      {
            ReservacionService.create(reservacion)
          .then((response: any) => {    
            navigate("/reservacion");
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
       ReservacionService.retrieve(id)
        .then((response: any) => {
          setReservacion(response.data); //Víncula el resultado del servicio con la función del Hook useState
          console.log(response.data);
        })
        .catch((e: Error) => {
          console.log(e);
        });
   };


		return ( //JSX
			<div className="submit-form">				
					<div>
						{ reservacion.id !== null ? (<h1>Actualizado reservacion {reservacion.horario}</h1>) : (<h1>Registro de una reservacion</h1>) }            
						<div className="form-group">
						<label htmlFor="horario">Horario</label>
            <input
              type="text"
							placeholder="Ingrese el horario del la reservacion"
              className="form-control"
              id="hora"
              required
              value={reservacion.horario!}
              onChange={handleInputChange}
              name="hora"
            />
						<label htmlFor="lugar">Lugar</label>
            <input						
              type="text"
              className="form-control"
							placeholder="Ingrese el lugar del la reservacion"
              id="lugar"
              required
              value={reservacion.lugar!}
              onChange={handleInputChange}
              name="lugar"
            />
						<label htmlFor="fecha">Fecha </label>
            <input						
              type="text"
              className="form-control"
              placeholder="Ingrese la fecha del la reservacion"
              id="fecha"
              required
              value={reservacion.fecha!}
              onChange={handleInputChange}
              name="fecha"
            />
						<label htmlFor="cantidadPersona">Cantidad Persona</label>
            <input						
              type="number"
              className="form-control"
              id="cantidadPersona"
              required
              value={reservacion.cantidadPersona}
              onChange={handleInputChange}
              name="cantidadPersona"
            />
						<br />
							<div className="btn-group" role="group">								
                <Link to={"/reservacion"} className="btn btn-primary">
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