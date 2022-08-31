import React from "react";
import { Routes, Route } from "react-router-dom";
import { Home } from "../pages/Home";
import LoginPage from "../pages/login/LoginPage";
import ReservationRoutes from "./ReservationRoutes";

const AppRouter = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Home />} />,
        <Route path="/login" element={<LoginPage />} />,
        <Route path="/reservacion/*" element={<ReservationRoutes />} />,
      </Routes>
    </div>
  );
};

export default AppRouter;
