import React from 'react'
import { Link } from 'react-router-dom'
import { ReservacionList } from '../../components/reservacion/ReservacionList'

const ReservationPage = () => {
  return (
    <div>
      <h1 className='text-center'>Lista de Reservaciones</h1>
      <div className='d-flex justify-content-end'>
        <Link to='/reservacion/create' className='btn btn-success'>Agregar</Link>
      </div>
      <ReservacionList/>
    </div>
  )
}

export default ReservationPage