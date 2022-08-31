import React, { useEffect } from "react";
import { Routes, Route,useNavigate } from "react-router-dom";
import { ReservacionForm } from "../components/reservacion/ReservacionForm";
import ReservationPage from "../pages/reservation/ReservationPage";
import { PaginationContextProvider } from "../contexts/PaginationContext";
import ReservationRetrieveRoute from "./ReservationRetrieveRoute";

const ReservationRoutes = () => {
  const navigate = useNavigate();
  useEffect(() => {
    if(!localStorage.getItem("token")){
      navigate("/login");
    }
  }, [navigate])
  return (
    <div className="container mt-3">
      <PaginationContextProvider>
        <Routes>
          <Route path="/" element={<ReservationPage />} />
          <Route path="/create" element={<ReservacionForm />} />
          <Route path="/retrieve/:id/*" element={<ReservationRetrieveRoute />} />
          <Route path="/update/:id" element={<ReservacionForm />} />
        </Routes>
      </PaginationContextProvider>
    </div>
  );
};

export default ReservationRoutes;
