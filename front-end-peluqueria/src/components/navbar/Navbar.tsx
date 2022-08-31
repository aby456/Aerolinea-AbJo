import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../../../src/logo.svg'
import getInfoUser from '../../helpers/GetUser';
import IUser from '../../models/User';
import './navbar.css'

const Navbar = () => {
  let user: any 
  if(getInfoUser() !== null){
    user = getInfoUser();
  }

  return (
    <nav className="navbar navbar-expand navbar-dark bg-dark gap-5"> 
            
        <Link to={"/"} className="navbar-brand">
          <img src= {logo} className="d-block mx-auto mb-4" height="50" alt="logo"/> 
        </Link>
        <div className="navbar-nav mr-auto ">
          <nav className="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
            <ol className="breadcrumb">
              <li className="breadcrumb-item active" aria-current="page" ><Link to="/reservacion">
                Reservacion
              </Link></li>
            </ol>
          </nav>          
        </div>
        {
          user!==null && user !== undefined ?  (
            <h3 className='titulo'>{user.user}</h3>
          ) : (
            <></>
          )
        }

      </nav>
  )
}

export default Navbar