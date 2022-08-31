import IReservation from "./Reservacion";
export default interface IServicio {
    id: number | null,
    nombreServicio: string,
    precioServicio: number,
    tiempoEstimadoServicio: number,
    reservacion: IReservation | null,
}