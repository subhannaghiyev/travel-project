import React, { useEffect, useState } from "react";
import "./index.scss";
import { AiOutlineGooglePlus } from "react-icons/ai";
import { Link, useNavigate } from "react-router-dom";
import { FiFacebook } from "react-icons/fi";
import { FaLinkedinIn } from "react-icons/fa";
import axios from "axios";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Helmet } from "react-helmet";

const Login = () => {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  let count = 0;
  const handleFormSubmit = async (e) => {
    e.preventDefault();
  
    try {
      const response = await axios.post("http://localhost:4040/users/login", {
        username,
        password,
      });
      const token = response.data;
      console.log(response.data);
      console.log("token", token);
      localStorage.setItem("userFirstName", token.firstName);
      localStorage.setItem("userLastName", token.lastName);
      localStorage.setItem("userPassword", token.password);
      localStorage.setItem("userAge", token.age);
      localStorage.setItem("userUsername", token.username);
      localStorage.setItem("userEmail", token.email);
      localStorage.setItem("userIsAdmin", token.isAdmin);
      const tokenString = JSON.stringify(token);
      localStorage.setItem("token", tokenString);
  
      if (username == token.username && token.isAdmin === false) {
        navigate("/");
        toast.success("User Login Successfully!", {
          autoClose : 1000
        });
      } else if (token.isAdmin === true) {
        navigate("/");
        toast.success("Admin Login Successfully!",{
          autoClose : 1000
        });
       } else if (token.statusCode === 404) {
        navigate("/login");
        toast.error("Invalid Username!", {
          autoClose: 1000,
        });
      } else if (token.statusCode === 406) {
        navigate("/login");
        toast.error("Invalid Password!", {
          autoClose: 1000,
        });
      }
    } catch (error) {
      if (error.response && error.response.status === 401) {
        setErrorMessage("Invalid password");
        toast.error("Invalid password");
        navigate("/login");
      } else {
        navigate("/login");
        setErrorMessage("User not found");
        toast.error("User not found");
      }
    }
  };  

  const hasTokenExpired = (token) => {
    const key = "TOKEN:" + token;

    // const expirationTime = redisTemplate.getExpire(key);

    // return expirationTime !== null && expirationTime <= 0;
  };

  const isTokenExpired = () => {
    const token = localStorage.getItem("token");

    if (!token) {
      return true;
    }

    return hasTokenExpired(token);
  };

  useEffect(() => {
    if (isTokenExpired()) {
      localStorage.removeItem("token");
      navigate("/login");
    }
  }, []);

  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>Login</title>
        <link rel="canonical" href="http://mysite.com/example" />
      </Helmet>
      <div className="login-background">
        <div className="login-display">
          <div className="images-login">
            {/* Add your image */}
            <img
              className="img-login"
              src="https://media.istockphoto.com/id/1285301614/photo/young-man-arms-outstretched-by-the-sea-at-sunrise-enjoying-freedom-and-life-people-travel.jpg?s=612x612&w=0&k=20&c=0QW6GnkuFNYcPZhy26XVHuTc2avJTK8u6l_1iT0SlZk="
              alt=""
            />
          </div>
          <div className="login-1">
            <h3 className="destino-login">Destino</h3>
            <div className="icon-login">
              {/* Add your icons */}
              <FiFacebook
                style={{
                  fontSize: 18,
                  color: "white",
                  borderRadius: "50%",
                  border: "1px solid white",
                  padding: "5px",
                }}
              />
              <AiOutlineGooglePlus
                style={{
                  fontSize: 18,
                  color: "white",
                  borderRadius: "50%",
                  border: "1px solid white",
                  padding: "5px",
                }}
              />
              <FaLinkedinIn
                style={{
                  fontSize: 18,
                  color: "white",
                  borderRadius: "50%",
                  border: "1px solid white",
                  padding: "5px",
                }}
              />
            </div>
            <p>or use your username account</p>
            <form className="form" onSubmit={handleFormSubmit}>
              <input
                className="login-text"
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
              <input
                className="login-text"
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              <div style={{ display: "flex" }}>
                <p>
                  Don't have an account ?{" "}
                  <Link to="/register">
                    <li className="li-register">Register</li>
                  </Link>
                </p>
              </div>
              <div style={{ cursor: "pointer" }}>
                <button type="submit" className="btn-login">
                  Sign In
                </button>
              </div>
            </form>
            {errorMessage && <p className="error-message">{errorMessage}</p>}
          </div>
        </div>
      </div>
      <ToastContainer />
    </>
  );
};

export default Login;
