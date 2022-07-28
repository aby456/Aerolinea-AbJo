import React from "react";
import { Routes, Route } from "react-router-dom";
import { ReservacionForm } from "../components/reservacion/ReservacionForm";
import { ReservacionCard } from "../components/reservacion/ReservacionCard";
import ReservationPage from "../pages/reservation/ReservationPage";
import { PaginationContextProvider } from "../contexts/PaginationContext";

const ReservationRoutes = () => {
  return (
    <div className="container mt-3">
      <PaginationContextProvider>
        <Routes>
          <Route path="/" element={<ReservationPage />} />
          <Route path="/create" element={<ReservacionForm />} />
          <Route path="/retrieve/:id" element={<ReservacionCard />} />
          <Route path="/update/:id" element={<ReservacionForm />} />
        </Routes>
      </PaginationContextProvider>
    </div>
  );
};

export default ReservationRoutes;
