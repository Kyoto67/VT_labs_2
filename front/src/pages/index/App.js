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

    const oauthLoginRequest = () => {
        authAPI.oauthLogin().then( pohui => {
            console.log(pohui);
            // myNavigate();
        })
    }

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

    function redirect() {
        localStorage.setItem("token", "eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzI4ODY1MDcsImV4cCI6MTY3Mjk3MjkwNywic3ViIjoib2F1dGgifQ.9LXWvA1T-MIZoaSQyPIF6W1kVRRjYWLK0xegSx2kb9nC0zLJP08U0yVMdJAN4GNaosBJxGsT8GC9swZHY_h9bw");
        window.location.replace('http://localhost:8080/redirect');

    }

  return ( redirect()
    // // <div className="App">
    // {/*//   <header className="App-header">*/}
    // {/*//     <span id={"swaston"}><img src={logo} className="App-logo" alt="logo" /></span>*/}
    // {/*//     <p>*/}
    // {/*//         <div>username:  <input id={"login"} type={"text"}/></div>*/}
    // {/*//         <div>password: <input id={"password"} type={"password"}/></div>*/}
    // {/*//         <button onClick={loginRequest}>Sign in</button>    <button onClick={registerRequest}>Sign Up</button>*/}
    // {/*//         <button onClick={oauthLoginRequest}>OAuth</button>*/}
    // {/*//     </p>*/}
    // {/*//   </header>*/}
    // {/*</div>*/}
  );
}



export default App;
