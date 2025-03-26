import axios from "axios";

const API_URL = "http://localhost:8080/api/productos";

export const getProductos = async () => {
    const response = await axios.get(API_URL);
    return response.data;
}

export const createProducto = async (producto) => {
    const response = await axios.post(API_URL, producto);
    return response.data;
}

export const updateProducto = async(producto) => {
    const response = await axios.put(`${API_URL}/${producto.id_producto}`, producto)
    return response.data;
}

export const deleteProducto = async(id) => {
    const response = await axios.delete(`${API_URL}/${id}`)
    return response.data;
}