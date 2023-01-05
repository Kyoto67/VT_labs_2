import axios from 'axios';

const token = 'eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzI4ODY1MDcsImV4cCI6MTY3Mjk3MjkwNywic3ViIjoib2F1dGgifQ.9LXWvA1T-MIZoaSQyPIF6W1kVRRjYWLK0xegSx2kb9nC0zLJP08U0yVMdJAN4GNaosBJxGsT8GC9swZHY_h9bw';

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080/api/'
});

const mainAPI = {
    async hit(x, y, r) {
        return axiosInstance.post('hit', { x, y, r }, {
            headers: {
            }
    });
    },

    async getData() {
        return axiosInstance.get('mydata', {
            headers: {
            }
        });
    },
}



export default mainAPI;