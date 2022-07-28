import React, { useState } from "react";
import IReservation from "../models/Reservacion";

const Context = React.createContext({});

export const ReservacionesContext = ({children}) => {
    const [reservaciones, setReservacion] = useState<Array<IReservation>>([]);
    
    return (
        <Context.Provider value={{ reservaciones,setReservacion }}>
            {children}
        </Context.Provider>
    );
};

export default Context;