import React from 'react'
import { Routes, Route } from "react-router-dom";
import { Home } from '../pages/Home'
import ClientRoutes from './ClientRoutes';
import ReservationRoutes from './ReservationRoutes';


const AppRouter = () => {
  return (
    <div>
    <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/reservacion/*" element={<ReservationRoutes />} />
        <Route path="/client/*" element={<ClientRoutes />} />
    </Routes>
    </div>
  )
}

export default AppRouter