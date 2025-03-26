import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

export const Login = () => {
  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="p-4 border rounded shadow text-center" style={{ width: '380px' }}>
        <img 
          src="https://static.vecteezy.com/system/resources/previews/002/318/271/non_2x/user-profile-icon-free-vector.jpg" 
          className="rounded-circle img-fluid mb-3"
          width="200"
          height="200"
          alt="Usuario"
        />
        
        <form>
          <div className="mb-3 text-start">
            <label className="form-label ">Correo: </label>
            <input type="email" className="form-control" placeholder="Ingresa tu correo" />
          </div>

          <div className="mb-3 text-start">
            <label className="form-label">Contraseña: </label>
            <input type="password" className="form-control" placeholder="Ingresa tu contraseña" />
          </div>
          <button className="btn btn-primary w-100">Iniciar Sesión</button>
        </form>
      </div>
    </div>
  );
}
