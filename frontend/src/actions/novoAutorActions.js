import axios from 'axios';

const api = axios.create({
    baseURL: import.meta.env?.VITE_API_BASE_URL || ''
})

export const createNovoAutor = async (autorData) => {
    const params = new URLSearchParams();
    params.append('nome', autorData.nome);
    params.append('portfolioAutor', autorData.portfolioAutor);
    const response = await api.post('/novoautor', params);
    return response.data;
}