import IReservation from "./Reservacion";
export default interface IServicio {
    id: number | null,
    nombreService: string,
    precioService: number,
    tiempoEstimadoService: number,
    reservacion: IReservation | null,
}