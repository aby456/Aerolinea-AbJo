import React from 'react'
import { Routes, Route} from "react-router-dom";
import { ReservacionList } from "../components/reservacion/ReservacionList";
import { ReservacionForm  } from "../components/reservacion/ReservacionForm";
import { ReservacionCard } from "../components/reservacion/ReservacionCard";

const ServicoRoutes = () => {
  return (
    <div>
        <div className="container mt-3">
        <Routes>         
          <Route path="/servicio" element={<ReservacionList />} />          
          <Route path="/servicio/create" element={<ReservacionForm />} />    
          <Route path="/servicio/retrieve/:id" element={<ReservacionCard/>} />      
          <Route path="/servicio/update/:id" element={<ReservacionForm />} />    
        </Routes>
      </div>
    </div>
  )
}

export default ServicoRoutes