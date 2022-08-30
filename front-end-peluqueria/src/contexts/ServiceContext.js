import React, { useState } from "react";
import IService from "../models/Reservacion";

const Context = React.createContext({});

export const ServiceContext = ({children}) => {
    const [services, setService] = useState<Array<IService>>([]);
    
    return (
        <Context.Provider value={{ services,setService }}>
            {children}
        </Context.Provider>
    );
};

export default Context;