import React from 'react';
import Carousel from 'react-bootstrap/Carousel';

export const CarruselLogin = () => {
  return (
    <Carousel>
    <Carousel.Item>
      {/* Ajustando el tamaño de la imagen con estilos en línea */}
      <img
        className="d-block w-100 img-fluid"
        src="https://images.pexels.com/photos/31198323/pexels-photo-31198323/free-photo-of-paseo-panoramico-a-caballo-por-el-norte-de-mindanao.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        alt="First slide"
        style={{ height: '500px', objectFit: 'cover' }}
      />
      <Carousel.Caption>
        <h3>Gestión de Facturas Simplificada</h3>
        <p>Genera, envía y organiza tus facturas de manera rápida y eficiente.</p>
      </Carousel.Caption>
    </Carousel.Item>

    <Carousel.Item>
      <img
        className="d-block w-100 img-fluid"
        src="https://images.pexels.com/photos/3483233/pexels-photo-3483233.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        alt="Second slide"
        style={{ height: '500px', objectFit: 'cover' }}
      />
      <Carousel.Caption>
        <h3>Reportes Financieros Detallados</h3>
        <p>Obtén informes claros sobre ingresos, gastos y balances financieros.</p>
      </Carousel.Caption>
    </Carousel.Item>

    <Carousel.Item>
      <img
        className="d-block w-100 img-fluid"
        src="https://images.pexels.com/photos/7330250/pexels-photo-7330250.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        alt="Third slide"
        style={{ height: '500px', objectFit: 'cover' }}
      />
      <Carousel.Caption>
        <h3>Third slide label</h3>
        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
      </Carousel.Caption>
    </Carousel.Item>
  </Carousel>
  );
};
