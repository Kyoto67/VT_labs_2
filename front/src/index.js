import React from 'react';
import ReactDOM from 'react-dom/client';
import './pages/index/index.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from './pages/index/App';
import Main from './pages/main/main';
import './pages/main/main.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <Routes>
                <Route exact path="/" element={<App />} />
                <Route exact path="/mainpage" element={<Main />} />
            </Routes>
        </BrowserRouter>
    </React.StrictMode>
);