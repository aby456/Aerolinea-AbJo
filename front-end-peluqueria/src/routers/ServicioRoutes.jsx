import React from 'react'
import { Routes, Route} from "react-router-dom";
import ServicioPage from '../pages/service/ServicioPage';
import {ServicioForm} from '../components/servicio/ServicioForm,';
import {ServicioCard} from '../components/servicio/ServicioCard';

const ServicioRoutes = () => {
  return (
    <div>
        <div className="container mt-3">
        <Routes>         
          <Route path="/" element={<ServicioPage />} />          
          <Route path="/create" element={<ServicioForm />} />    
          <Route path="/retrieve/:idServicio" element={<ServicioCard/>} />      
          <Route path="/update/:idServicio" element={<ServicioForm />} />    
        </Routes>
      </div>
    </div>
  )
}

export default ServicioRoutes