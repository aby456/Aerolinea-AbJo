import React from "react";
import { Routes, Route } from "react-router-dom";
import { ReservacionCard } from "../components/reservacion/ReservacionCard";
import { PaginationContextProvider } from "../contexts/PaginationContext";
import ServicioRoutes from "./ServicioRoutes";

const ReservationRetrieveRoute = () => {
  return (
    <div className="container mt-3">
      <PaginationContextProvider>
        <Routes>
          <Route path="/" element={<ReservacionCard />} />
          <Route path="/servicio/*" element={<ServicioRoutes />} />
        </Routes>
      </PaginationContextProvider>
    </div>
  );
};

export default ReservationRetrieveRoute;
