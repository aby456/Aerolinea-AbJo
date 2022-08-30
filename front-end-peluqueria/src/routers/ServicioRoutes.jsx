import React from 'react'
import { Routes, Route} from "react-router-dom";
import { ReservacionList } from "../components/reservacion/ReservacionList";
import { ReservacionForm  } from "../components/reservacion/ReservacionForm";
import { ReservacionCard } from "../components/reservacion/ReservacionCard";

const ServicioRoutes = () => {
  return (
    <div>
        <div className="container mt-3">
        <Routes>         
          <Route path="/" element={<ReservacionList />} />          
          <Route path="/create" element={<ReservacionForm />} />    
          <Route path="/retrieve/:id" element={<ReservacionCard/>} />      
          <Route path="/update/:id" element={<ReservacionForm />} />    
        </Routes>
      </div>
    </div>
  )
}

export default ServicioRoutes