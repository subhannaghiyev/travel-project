import { Button } from "antd";
import axios from "axios";
import React, { useState, useEffect } from "react";
import { AiFillStar } from "react-icons/ai";
import { FaTrashAlt } from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import "./index.scss";

const Bought = () => {
  const token = localStorage.getItem("token");
  const tokenString = JSON.parse(token);
  console.log(tokenString.id);
  const [data, setData] = useState([]);
  const navigate = useNavigate()

  const getData = async () => {
    try {
      const res = await axios.get("http://localhost:4040/payments");
      setData(res.data);
      console.log(res.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  useEffect(() => {
    getData();
  }, []);

  let hasBought = false;
  if (data.length > 0) {
    for (let i = 0; i < data.length; i++) {
      if (token && tokenString.id === data[i].userId) {
        hasBought = true;
        break;
      }
    }
  }
  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:4040/deletePayment/${id}`);
      setData((prevData) => prevData.filter((item) => item.id !== id));
    } catch (error) {
      console.error(error);
    }
  };

  const showDeleteConfirm = (record) => {
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!",
    }).then((result) => {
      if (result.isConfirmed) {
        handleDelete(record.id);
        Swal.fire("Deleted!", "Your file has been deleted.", "success");
      }
    });
  };

  const handleNavigate = () =>{
    navigate("/")
  }

  return (
    <>
      {data.map((d) =>
        token && tokenString.id === d.userId ? (
          <div className="sect-offers" key={d.id}>
            <div className="images-offers">
              <img className="img" src={d.img} alt="" />
            </div>
            <div className="offers-column">
              <p className="dollar">From ${d.price}</p>
              <div style={{ display: "flex", gap: 10 }}>
                <p className="country">{d.country},</p>
                <p className="country">{d.capital}</p>
              </div>
              <p className="offers-text">{d.description}</p>
            </div>
            <div className="icons-stars">
              {Array.from({ length: d.stars }).map((_, index) => (
                <AiFillStar key={index} className="icon-star" />
              ))}
            </div>
            <p className="received">Received</p>
            <button
            className="btn-offers-wishlist"
              onClick={() => showDeleteConfirm(d)}
            >
              Delete
            </button>
          </div>
        ) : null
      )}
      {!hasBought && (
        <div className="div-bought">
          <h1 className="h1-bought">You haven't bought anything yet</h1>
          <button onClick={handleNavigate} className="btn-bought">Go To Home Page</button>
        </div>
      )}
    </>
  );
};

export default Bought;
