import React from 'react'
import { Routes,Route } from 'react-router-dom'
import { ClienteCard } from '../components/cliente/ClienteCard'
import { ClienteForm } from '../components/cliente/ClienteForm'
import { ClienteList } from '../components/cliente/ClienteList'


const ClientRoutes = () => {
  return (
    <div className="container mt-3">
        <Routes>         
          <Route path="/client" element={<ClienteList />} />          
          <Route path="/client/create" element={<ClienteForm />} />    
          <Route path="/client/retrieve/:id" element={<ClienteCard/>} />      
          <Route path="/client/update/:id" element={<ClienteForm />} />    
        </Routes>
    </div>
  )
}

export default ClientRoutes