import axios from "axios";

const API_URL = "http://localhost:8080/api/facturas";

export const getFacturas= async () => {
    const response = await axios.get(API_URL);
    return response.data;
}

export const createFactura = async (factura) => {
    const response = await axios.post(API_URL, factura);
    return response.data;
}

export const updateFactura = async(factura) => {
    const response = await axios.put(`${API_URL}/${factura.id_factura}`, factura)
    return response.data;
}

export const deleteFactura = async(id) => {
    const response = await axios.delete(`${API_URL}/${id}`)
    return response.data;
}