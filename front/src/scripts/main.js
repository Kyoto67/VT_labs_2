import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080/api/'
});

const mainAPI = {
    async hit(x, y, r, token) {
        return axiosInstance.post('hit', { x, y, r }, {
            headers: {
                Authorization: 'Bearer ' + token
            }
    });
    },

    async getData(token) {
        return axiosInstance.get('mydata', {
            headers: {
                Authorization: 'Bearer ' + token
            }
        });
    },
}



export default mainAPI;