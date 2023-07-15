import { Button } from "antd";
import axios from "axios";
import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { toast, ToastContainer } from "react-toastify";
import Swal from "sweetalert2";
import "./index.scss";
import { Card } from "antd";
import { Helmet } from "react-helmet";
import { AiFillStar } from "react-icons/ai";
import { FaPlaneDeparture } from "react-icons/fa";
const Payment = () => {
  const { Meta } = Card;
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [cardNumber, setCardNumber] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [price, setPrice] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);
  const [userId, setUserId] = useState(null);
  const [date, setDate] = useState("");
  const [datecvv, setDateCvv] = useState("");
  useEffect(() => {
    const token = localStorage.getItem("token");
    const tokenParse = JSON.parse(token);
    setUserId(tokenParse.id);
  }, []);

  useEffect(() => {
    const dataPrice = localStorage.getItem("cartItem");
    const dataPriceJson = JSON.parse(dataPrice);

    setPrice(dataPriceJson);

    let calculatedTotalPrice = 0;
    if (Array.isArray(dataPriceJson)) {
      calculatedTotalPrice = dataPriceJson.reduce(
        (acc, item) => acc + item.price, // Sum up the price property of each item
        0
      );
    }

    setTotalPrice(calculatedTotalPrice);
  }, []);

  console.log("qiymet", price);

  const handleFormSubmitPost = async (e) => {
    e.preventDefault();

    const dataPrice = localStorage.getItem("cartItem");
    const dataPriceJson = JSON.parse(dataPrice);

    const payments = dataPriceJson.map((item) => ({
      price: item.price,
      img: item.img,
      description: item.description,
      country: item.country,
      capital: item.capital,
      stars: item.count,
      userId,
    }));

    try {
      const response = await axios.post(
        "http://localhost:4040/savePayment",
        payments
      );
      toast.success("Payment successfully!",{
        autoClose : 1000
      })
      localStorage.removeItem("cartItem");

      setTimeout(() => {
        navigate("/");
        window.location.reload();
      }, 2000);
    } catch (error) {
      // Handle the error
    }
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:4040/users/checkCard",
        {
          email,
          cardNumber,
        }
      );

      toast.success("Payment Successful");
      localStorage.removeItem("cartItem");

      setTimeout(() => {
        navigate("/");
      }, 2000);

      const token = response.data;

      if (email === token.email) {
        toast.success("Payment Successfully!");
      } else {
        setErrorMessage("Invalid Kenan");
        navigate("/login");
        toast.error("Invalid Kenan");
      }
    } catch (error) {
      if (error.response && error.response.status === 401) {
        setErrorMessage("Invalid password");
        toast.error("Invalid password");
        Swal.fire("Payment Failed!");
      } else {
        // navigate("/wishlist");
      }
    }
  };
  // const formatCardNumber = (input) => {
  //   const cardNumberWithoutSpaces = input.replace(/\s/g, "");

  //   const formattedCardNumber = cardNumberWithoutSpaces.replace(/(.{4})/g, "$1 ");

  //   setCardNumber(formattedCardNumber);
  // };

  // const handleCardNumberChange = (e) => {
  //   formatCardNumber(e.target.value);
  // };

  const formatCardNumber = (input) => {
    // Girilen değerden boşlukları kaldırarak formatı oluştur
    const cardNumberWithoutSpaces = input.replace(/\s/g, "");

    // Dört haneli gruplara bölen bir regex kullanarak formatı oluştur
    const formattedCardNumber = cardNumberWithoutSpaces.replace(
      /(.{4})/g,
      "$1 "
    );

    // Formatlanmış kart numarasını setCardNumber ile state'e kaydet
    setCardNumber(formattedCardNumber);
  };

  const handleCardNumberChange = (e) => {
    // Girilen değeri formatlamak için her karakter değişikliğinde formatCardNumber fonksiyonunu çağır
    formatCardNumber(e.target.value);
  };
  const handleDateInput = (e) => {
    const inputDate = e.target.value.replace(/\s/g, "");

    if (inputDate.length > 5) {
      // En fazla 4 karakter alıyoruz (MM/YY)
      setDate(inputDate.slice(0, 5));
    } else {
      setDate(inputDate);
    }
  };
  const handleDateInputCvv = (e) => {
    const inputDate = e.target.value.replace(/\s/g, "");

    if (inputDate.length > 3) {
      // En fazla 4 karakter alıyoruz (MM/YY)
      setDateCvv(inputDate.slice(0, 3));
    } else {
      setDateCvv(inputDate);
    }
  };
  const handleSubmit = () => {};

  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>Payment</title>
        <link rel="canonical" href="http://mysite.com/example" />
      </Helmet>
      <div className="pay-main">
        <div className="pay-1">
          <FaPlaneDeparture style={{ color: "cyan", fontSize: 50 }} />
          <div className="p-text-pay">
            <p className="total-pay" style={{ color: "gray" }}>
              Total Payment :
            </p>
            <h1>
              <i className="fa-solid fa-euro-sign"></i>
              {totalPrice}
            </h1>
            {/* ------------------------------- CARDDDD */}
            <div className="card-container">
              {price.map((d) => (
                <Card className="card-payment" hoverable key={d.id}>
                  <div className="card-content">
                    <div className="image-container">
                      <img alt="example" src={d.img} className="card-image" />
                    </div>
                    <div className="text-container">
                      <Meta
                        title={d.title}
                        description={
                          <div>
                            <p
                              style={{
                                color: "black",
                                fontSize: 10,
                                fontFamily: "chillax-regular",
                              }}
                            >
                              Description: {d.description}
                            </p>
                            <p
                              style={{
                                color: "red",
                                fontSize: 14,
                                fontFamily: "chillax-regular",
                              }}
                            >
                              Country: {d.country}
                            </p>
                            <p
                              style={{
                                color: "green",
                                fontSize: 14,
                                fontFamily: "chillax-regular",
                              }}
                            >
                              Capital: {d.capital}
                            </p>
                            <div
                              style={{
                                display: "flex",
                                alignItems: "center",
                                gap: 1,
                                color: "orange",
                                fontSize: 14,
                                fontFamily: "chillax-regular",
                              }}
                            >
                              Stars:{" "}
                              {Array.from({ length: d.count }).map(
                                (_, index) => (
                                  <AiFillStar
                                    key={index}
                                    className="icon-star"
                                  />
                                )
                              )}
                            </div>
                          </div>
                        }
                        className="card-text"
                      />
                    </div>
                  </div>
                </Card>
              ))}
            </div>
          </div>
        </div>
        <div className="pay-2">
          <h3 className="email-pay">Pay with card</h3>
          <div className="email-div">
            <label className="email">Email</label>
          </div>
          <div className="email-div">
            <input
              style={{ fontFamily: "chillax-regular" }}
              className="email-inp"
              placeholder="Email"
              type="text"
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className="card-div">
            <label className="cardinfo">Card Information</label>
          </div>
          <div className="card-div">
            <input
              style={{ fontFamily: "chillax-regular" }}
              className="card-inp"
              placeholder="Card Number"
              type="text"
              // onChange={(e) => setCardNumber(e.target.value)}
              onChange={handleCardNumberChange}
              value={cardNumber}
            />
          </div>
          <div className="card-cvv" style={{ display: "flex" }}>
            <input
              style={{ fontFamily: "chillax-regular" }}
              className="cvv"
              type="text"
              placeholder="Date"
              onInput={handleDateInput}
              value={date}
              pattern="^(0[1-9]|1[0-2])\/\d{2}$"
            />
            <input
              style={{ fontFamily: "chillax-regular" }}
              className="cvv"
              type="text"
              placeholder="cvv"
              value={datecvv}
              onInput={handleDateInputCvv}
              pattern="^(0[1-9]|1[0-2])\/\d{2}$"
            />
          </div>
          <div className="name-card-div">
            <label className="name-card">Name on Card</label>
          </div>
          <div className="name-card-div">
            <input
              style={{ fontFamily: "chillax-regular" }}
              className="name-inp"
              type="text"
              placeholder="Name on Card"
            />
          </div>
          <div>
            <label className="country-pay">Address</label>
          </div>
          <div className="select-opt">
            <input
              style={{ fontFamily: "chillax-regular" }}
              className="address-inp"
              type="text"
              name=""
              id=""
              placeholder="Address"
            />
          </div>
          <button
            onClick={handleFormSubmitPost}
            className="btn-pay"
            type="primary"
          >
            Pay
          </button>
        </div>
      </div>
      <ToastContainer />
    </>
  );
};

export default Payment;
