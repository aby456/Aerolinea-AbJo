import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import { Home } from "./components/Home";
import { ReservacionList } from "./components/reservacion/ReservacionList";
import { ReservacionForm  } from "./components/reservacion/ReservacionForm";
import { ReservacionCard } from "./components/reservacion/ReservacionCard";

const title = "Peluqueria AbJo";
const description = "Aplicación web para la reservacion de una peluqueria";

const App: React.FC = () => {
  return (
    <div>
      <nav className="navbar navbar-expand navbar-dark bg-dark">        
        <Link to={"/"}  className="navbar-brand">
          NRC 6515
        </Link>
        <div className="navbar-nav mr-auto">
          <li className="nav-item">
            <Link to={"/reservacion"} className="nav-link">
              Reservacion
            </Link>
          </li>          
        </div>
      </nav>
      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Home title={title} description={description} />} />          
          <Route path="/reservacion" element={<ReservacionList />} />          
          <Route path="/reservacion/create" element={<ReservacionForm />} />    
          <Route path="/reservacion/retrieve/:id" element={<ReservacionCard/>} />      
          <Route path="/reservacion/update/:id" element={<ReservacionForm />} />    
        </Routes>
      </div>
    </div>
  );
}
export default App;
