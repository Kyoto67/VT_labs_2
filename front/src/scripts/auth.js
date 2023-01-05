import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080/auth/'
});

const authAPI = {
    async login(username, password) {
        return axiosInstance.post('login', { username, password });
    },

    async register(username, password) {
        return axiosInstance.post('register', { username, password });
    },

    async oauthLogin() {
        return axios.create( {baseURL: 'http://localhost:8080/'} ).get("login/oauth2/code/github");
    }
}



export default authAPI;