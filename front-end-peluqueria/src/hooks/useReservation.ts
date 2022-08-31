import {useContext, useEffect, useState } from "react";
import servicios from "../services/ReservacionServices";
import IReservation from "../models/Reservacion";
import PaginationContext from "../contexts/PaginationContext";


export const useReservation = ((page:number, limit:number, reservacionesBuscadas?:IReservation) => {
    const [reservations, setReservations] = useState<Array<IReservation>>([]);
    const [loading, setLoading] = useState(false);
    const {setTotal}:any =  useContext(PaginationContext);

    useEffect(() => {
        setLoading(true);
            servicios.list(page, limit).then(response => {
                setReservations(response.data);
                setLoading(false);
                servicios.count().then(response => {
                    setTotal(Math.ceil(response / limit)-1);
                });
            }).catch(error => {
                setLoading(false);
                console.log(error);
            }
            );
    }, [page, limit, setTotal]);
    console.log(reservations);
    return {reservations, loading};
});