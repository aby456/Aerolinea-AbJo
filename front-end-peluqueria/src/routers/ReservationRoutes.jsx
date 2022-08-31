import React from "react";
import { Routes, Route } from "react-router-dom";
import { ReservacionForm } from "../components/reservacion/ReservacionForm";
import { ReservacionCard } from "../components/reservacion/ReservacionCard";
import ReservationPage from "../pages/reservation/ReservationPage";
import { PaginationContextProvider } from "../contexts/PaginationContext";
import ServicioRoutes from "./ServicioRoutes";
import ReservationRetrieveRoute from "./ReservationRetrieveRoute";

const ReservationRoutes = () => {
  return (
    <div className="container mt-3">
      <PaginationContextProvider>
        <Routes>
          <Route path="/" element={<ReservationPage />} />
          <Route path="/create" element={<ReservacionForm />} />
          <Route path="/retrieve/:id/*" element={<ReservationRetrieveRoute />} />
          <Route path="/update/:id" element={<ReservacionForm />} />
          <Route path="/servicio/*" element={<ServicioRoutes />} />
        </Routes>
      </PaginationContextProvider>
    </div>
  );
};

export default ReservationRoutes;
