import logo from '../../img/swaston.png';
import './App.css';
import authAPI from "../../scripts/auth";
import {useNavigate} from "react-router-dom";

function App() {

    const loginRequest = () => {
        let log = document.getElementById("login").value;
        let pass = document.getElementById("password").value;
        authAPI.login(log, pass).then(response => {
            console.log(response);
            if (response.data === "wrong password" || response.data === "user not found") {
                alert(response.data);
            } else {
                localStorage.setItem("token", response.data);
                myNavigate();
            }

        }).catch(error => {
            alert(error.response.data)
        });
    };

    const registerRequest = () => {
        let log = document.getElementById("login").value;
        let pass = document.getElementById("password").value;
        authAPI.register(log, pass).then(response => {
            if (response.data === "user already exists") {
                alert(response.data);
            } else {
                localStorage.setItem("token", response.data);
                myNavigate();
            }
        }).catch(error => {
            alert(`WTF ${error}`)
        });
    };

    const navigate = useNavigate();
    const myNavigate = () => {
        navigate("/mainpage");
    };

  return (
    <div className="App">
      <header className="App-header">
        <span id={"swaston"}><img src={logo} className="App-logo" alt="logo" /></span>
        <p>
            <div>username:  <input id={"login"} type={"text"}/></div>
            <div>password: <input id={"password"} type={"password"}/></div>
            <button onClick={loginRequest}>Sign in</button>    <button onClick={registerRequest}>Sign Up</button>
        </p>
      </header>
    </div>
  );
}



export default App;
