import { Routes, Route, Link } from "react-router-dom";
import logo from '../src/logo.svg'
import "bootstrap/dist/css/bootstrap.min.css";
import { Home } from "./components/Home";
import { ReservacionList } from "./components/reservacion/ReservacionList";
import { ReservacionForm  } from "./components/reservacion/ReservacionForm";
import { ReservacionCard } from "./components/reservacion/ReservacionCard";
import { ClienteCard } from "./components/cliente/ClienteCard";
import { ClienteForm } from "./components/cliente/ClienteForm";
import { ClienteList } from "./components/cliente/ClienteList";


const title = "Peluqueria AbJo";
const description = "Aplicación web para la reservacion en una peluqueria";

const App: React.FC = () => {
  return (
    <div>
      <nav className="navbar navbar-expand navbar-dark bg-dark"> 
            
        <Link to={"/"}  className="navbar-brand">
          <img src= {logo} className="d-block mx-auto mb-4" height="50" alt="logo"/> 
        </Link>
        <div className="navbar-nav mr-auto ">
          <nav className="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
            <ol className="breadcrumb">
              <li className="breadcrumb-item active" aria-current="page" ><a href="/reservacion">Reservacion</a></li>
              <li className="breadcrumb-item"><a href="cliente">Cliente</a></li>
              <li className="breadcrumb-item"><a href="/servicio">Servicio</a></li>
            </ol>
          </nav>          
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

      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Home title={title} description={description} />} />          
          <Route path="/cliente" element={<ClienteList />} />          
          <Route path="/cliente/create" element={<ClienteForm />} />    
          <Route path="/cliente/retrieve/:id" element={<ClienteCard/>} />      
          <Route path="/cliente/update/:id" element={<ClienteForm />} />    
        </Routes>
      </div>

      
    </div>
  );
}
export default App;
