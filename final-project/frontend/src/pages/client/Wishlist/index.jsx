import "./index.scss";
import { AiFillStar } from "react-icons/ai";
import { FaCcAmazonPay } from "react-icons/fa";
import { removeFromFav } from "../../../redux/slice/FavSlice";
import { useDispatch, useSelector } from "react-redux";
import { FaTrashAlt } from "react-icons/fa";
import { Button } from "antd";
import { addToCart } from "../../../redux/slice/cartSlice";
import { Helmet } from "react-helmet";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useEffect, useState } from "react";
import { toast, ToastContainer } from "react-toastify";
const Wishlist = () => {
  const navigate = useNavigate();
  const data = useSelector((state) => state.addToFav.value);
  const dispatch = useDispatch();
  let totalPrice = 0;
  data.forEach((d) => {
    totalPrice += d.price;
  });
  const handleAddToCart = (data) => {
    dispatch(addToCart(data));
    navigate("/payment");
  };

  const [data2, setData2] = useState([]);

  const getData = async () => {
    try {
      const res = await axios.get("http://localhost:4040/payments");
      setData2(res.data);
      console.log(res.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  useEffect(() => {
    getData();
  }, []);

  const handleSubmit = () => {
    if (data2.length === 0) {
      handleAddToCart(data);
    } else {
      const matchingItem = data2.find((item) =>
        data.some((d) => d.img === item.img)
      );
      if (matchingItem) {
        toast.error("You have already received" , {
          autoClose : 1000
        });
      } else {
        handleAddToCart(data);
      }
    }
  };
  const handleNavigate = () => {
    navigate("/offers");
  };

  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>WishList</title>
        <link rel="canonical" href="http://mysite.com/example" />
      </Helmet>
      <div>
        {data.length > 0 ? (
          <div className="sect-offers-column">
            {data.map((d) => (
              <div className="sect-offers" key={d.id}>
                <div className="images-offers">
                  <img className="img" src={d.img} alt="" />
                </div>
                <div className="offers-column">
                  <p className="dollar">From ${d.price}</p>
                  <div style={{ display: "flex", gap: 7 }}>
                    <p className="country">{d.country},</p>
                    <p className="country">{d.capital}</p>
                  </div>
                  <p className="count">{d.info}</p>
                  <div className="stars">
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                  </div>
                  <p className="offers-text">{d.description}</p>
                  <button
                    onClick={() => dispatch(removeFromFav(d.id))}
                    className="btn-offers-wishlist"
                  >
                    <FaTrashAlt className="fa-icons" />
                  </button>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <div className="no-data-container">
            <h1 className="no-data-title">
              You haven't added anything to your wishlist yet.
            </h1>
            <Button
              className="no-data-btn"
              type="primary"
              onClick={handleNavigate}
            >
              Let's start shopping
            </Button>
          </div>
        )}
        {data.length > 0 && (
          <div className="total-price">
            <h2 className="total">Total Price : {totalPrice}</h2>
            <Button type="primary" className="payment" onClick={handleSubmit}>
              Payment <FaCcAmazonPay className="payment-icon" />
            </Button>
          </div>
        )}
      </div>
      <ToastContainer/>
    </>
  );
};

export default Wishlist;
