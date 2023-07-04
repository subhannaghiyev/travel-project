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
const Wishlist = () => {
  const navigate = useNavigate()
  const data = useSelector((state) => state.addToFav.value);
  const dispatch = useDispatch();
  let totalPrice = 0;
  data.forEach((d) => {
    totalPrice += d.price;
  });
  const handleAddToCart = (data) => {
    dispatch(addToCart(data));
    navigate('/payment')
    
  };
  return (
    <>
    <Helmet>
        <meta charSet="utf-8" />
        <title>WishList</title>
        <link rel="canonical" href="http://mysite.com/example" />
      </Helmet>
      <div>
        <div className="sect-offers-column">
          {data &&
            data.map((d) => (
              <div className="sect-offers" key={d.id}>
                <div className="images-offers">
                  <img className="img" src={d.img} alt="" />
                </div>
                <div className="offers-column">
                  <p className="dollar">From ${d.price}</p>
                  <p className="country">{d.country}</p>
                  <p className="count">{d.info}</p>
                  <div className="stars">
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                    <AiFillStar className="icon-star" />
                  </div>
                  <p className="offers-text">{d.description}</p>
                  <button onClick={()=>{
                                dispatch(removeFromFav(d.id))
                            }} className="btn-offers-wishlist">
                  <FaTrashAlt className="fa-icons"/>
                  </button>
                </div>
              </div>
            ))}
        </div>

        <div className="total-price">
            <h2 className="total">Total Price : {totalPrice}</h2>
            <Button type="primary" className="payment"  onClick={() => handleAddToCart(data)}>Payment  <FaCcAmazonPay className="payment-icon"/></Button>
        </div>
      </div>
    </>
  );
};

export default Wishlist;
