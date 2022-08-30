import {useEffect, useState } from "react";
import servicios from "../services/ServicioService";
import IService from "../models/Servicio";


export const useService = ((reservacionesBuscadas?:IService) => {
    const [services, setServices] = useState<Array<IService>>([]);
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        setLoading(true);
            servicios.list().then(response => {
                setServices(response.data);
                setLoading(false);
            }).catch(error => {
                setLoading(false);
                console.log(error);
            }
            );
    }, []);

    return {services, loading};
});