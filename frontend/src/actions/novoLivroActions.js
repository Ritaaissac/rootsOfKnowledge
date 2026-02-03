import axios from 'axios';

const api = axios.create({
    baseURL: import.meta.env?.VITE_API_BASE_URL || 'http://127.0.0.1:8080'
})

export const createNovoLivro = async (livroData) => {
    const response = await api.post('/novolivro', livroData);
    return response.data;
}