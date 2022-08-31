import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import ILogin from '../../models/Login'
import Login from '../../services/LoginService'
import  './login.css'

const LoginForm = () => {
    const [loginForm, setLoginForm] = useState<ILogin>({name: '', password: ''})
    let navigate = useNavigate();
    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target
        setLoginForm({ ...loginForm, [name]: value })
    }
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        Login.login(loginForm)
        .then(response => {
            if(response!==null){
                if(response.status === 200){
                    const {token} = response.data
                    localStorage.setItem('token', token)
                    navigate('/reservacion')
                }
            }
        }).catch(error => {
            
        })
        
    }
  return (
    
        <form className='p-5 mt-5' onSubmit={handleSubmit}>
        <div className="form-group">
            <label htmlFor="nameuser">UserName</label>
            <input 
                type="text" 
                className="form-control" 
                id="nameuser"  
                placeholder="Enter NameUser"
                name="name"
                onChange={handleInputChange}
            />
        </div>
        <div className="form-group">
            <label htmlFor="password">Password</label>
            <input type="password"
                className="form-control"
                id="password"
                placeholder="Password"
                name="password"
                onChange={handleInputChange}
            />
        </div>
        <button 
            type="submit"
            className="btn btn-primary d-block m-auto mt-3"
        >Iniciar Sesion</button>
    </form>
  )
}

export default LoginForm