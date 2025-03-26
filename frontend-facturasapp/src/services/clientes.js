import axios from "axios";

const API_URL = "http://localhost:8080/api/clientes";


export const getClientes =  async () => {
    const response = await axios.get(API_URL);
    return response.data;
}

export const createCliente= async (cliente) => {
    const response = await axios.post(API_URL, cliente);
    return response.data;
}

export const updateCliente = async(cliente) => {
    const response = await axios.put(`${API_URL}/${cliente.idCliente}`, cliente)
    return response.data;
}

export const deleteCliente = async(id) => {
    const response = await axios.delete(`${API_URL}/${id}`)
    return response.data;
}

