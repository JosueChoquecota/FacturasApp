import axios from "axios";

const API_URL = "http://localhost:8080/api/detalles";

export const getDetalles = async () => {
    const response = await axios.get(API_URL);
    return response.data;
}

export const createDetalle = async (detalle) => {
    const response = await axios.post(API_URL, detalle);
    return response.data;
}

export const updateDetalle = async(detalle) => {
    const response = await axios.put(`${API_URL}/${detalle.id_detalle}`, detalle)
    return response.data;
}

export const deleteDetalle = async(id) => {
    const response = await axios.delete(`${API_URL}/${id}`)
    return response.data;
}