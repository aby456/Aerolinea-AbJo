import React from 'react'
import { Link } from 'react-router-dom'
import ServicioList from '../../components/servicio/ServicioList'

const ServicioPage = () => {
  return (
    <div>
        <div className='form-group m-3'>
      <input type='text' className='form-control' placeholder='Filtrar...' />
    </div>
      <h1 className='text-center'>Lista de Reservaciones</h1>
      <div className='d-flex justify-content-end'>
        <Link to='/reservacion/create' className='btn btn-success'>Agregar</Link>
      </div>
      <ServicioList/>
    </div>
  )
}

export default ServicioPage