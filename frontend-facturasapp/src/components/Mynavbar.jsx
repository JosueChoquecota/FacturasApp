import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from "react-router-dom";

export const Mynavbar = () => {
  return (
    <>
      <div className='container'>
        <header className='d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom'>
          <Link to="/" className='d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none'>
            <i className="bi bi-bootstrap fs-2 me-2">
              <img src="https://w7.pngwing.com/pngs/804/269/png-transparent-bootstrap-hd-logo-thumbnail.png"  alt="Logo" width="38" height="30" />
            </i>
            <span className='fs-4'>Simple header</span>
          </Link>
          <ul className='nav nav-pills'>
            <li className='nav-item'>
              <Link to="/" className='nav-link'>Inicio</Link>
            </li>
            <li className='nav-item'>
              <Link to="/contact" className='nav-link'>Contact</Link>
            </li>
            <li className='nav-item'>
              <Link to="/login" className='nav-link active'>Login</Link>
            </li>
          </ul>
        </header>
      </div>
    </>
  )
}
