import React from 'react'
import { Routes, Route } from "react-router-dom";
import { Home } from '../pages/Home'
import LoginPage from '../pages/login/LoginPage';
import ClientRoutes from './ClientRoutes';
import ReservationRoutes from './ReservationRoutes';
import ServicioRoutes from './ServicioRoutes';


const AppRouter = () => {
  return (
    <div>
    <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/reservacion/*" element={<ReservationRoutes />} />
        <Route path="/servicio/*" element={<ServicioRoutes />} />
        <Route path="/client/*" element={<ClientRoutes />} />
        <Route path="/login" element={<LoginPage />} />

    </Routes>
    </div>
  )
}

export default AppRouter