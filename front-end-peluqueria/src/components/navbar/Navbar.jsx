import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../../../src/logo.svg'

const Navbar = () => {

  return (
    <nav className="navbar navbar-expand navbar-dark bg-dark"> 
            
        <Link to={"/"} className="navbar-brand">
          <img src= {logo} className="d-block mx-auto mb-4" height="50" alt="logo"/> 
        </Link>
        <div className="navbar-nav mr-auto ">
          <nav className="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
            <ol className="breadcrumb">
              <li className="breadcrumb-item active" aria-current="page" ><Link to="/reservacion">
                Reservacion
              </Link></li>
              <li className="breadcrumb-item"><Link to="/cliente">Cliente</Link></li>
              <li className="breadcrumb-item"><Link to="/servicio">Servicio</Link></li>
            </ol>
          </nav>          
        </div>
      </nav>
  )
}

export default Navbar