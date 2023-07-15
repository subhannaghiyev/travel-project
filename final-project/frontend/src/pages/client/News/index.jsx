import axios from "axios";
import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";
import { Link, useNavigate } from "react-router-dom";
import "./index.scss";
const News = () => {
  const [value, setValue] = useState("");
  const handleChange = (e) => {
    setValue(e.target.value);
  };
  const [data , setData] = useState([])
  const navigate = useNavigate();
  const getData = async () =>{
    const res = await axios.get("http://localhost:4040/news")
    setData(res.data);
  }
  useEffect(()=>{
    getData()
  },[])
  return (
    <>
    <Helmet>
        <meta charSet="utf-8" />
        <title>News</title>
        <link rel="canonical" href="http://mysite.com/example" />
      </Helmet>
      <div className="background-image-2-news">
        <div className="text-about">
          <p className="p-about">News</p>
          <p className="p-about-1">Home / News</p>
        </div>
        <div className="sect-2">
          <div className="text-h3">
            <h3 className="h3">Find the Adventure of a lifetime</h3>
          </div>
          <div className="input">
            <div
              style={{ display: "flex", flexDirection: "column", gap: "10px" }}
            >
              <label style={{textAlign:"start",fontFamily:"chillax-regular"}}>Destination:</label>
              <input className="inp" type="text" placeholder="Keyword here"/>
            </div>
            <div
              style={{ display: "flex", flexDirection: "column", gap: "10px" }}
            >
              <label style={{textAlign:"start",fontFamily:"chillax-regular"}}>Adventure type:</label>
              <select className="inp-select">
                <option className="inp-color" value="Categores">
                  Categories
                </option>
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
              </select>
            </div>
            <div
              style={{ display: "flex", flexDirection: "column", gap: "10px" }}
            >
              <label style={{textAlign:"start",fontFamily:"chillax-regular"}}>Min price</label>
              <select className="inp-price">
                <option value=""></option>
                <option value="option1">price</option>
                <option value="option2">price</option>
              </select>
            </div>
            <div
              style={{ display: "flex", flexDirection: "column", gap: "10px" }}
            >
              <label style={{textAlign:"start",fontFamily:"chillax-regular"}}>Max price</label>
              <select className="inp-price">
                <option value=""></option>
                <option value="option1">price</option>
                <option value="option2">price</option>
              </select>
            </div>
            <button className="btn">Find</button>
          </div>
        </div>
      </div>

      <div className="sect-2-news">
        <div className="text-news">
          <h4 className="h4">Top destinations in Europe</h4>
          <p className="p-news">BY ADMIN | JANUARY 31 | 2018 3 COMMENTS</p>
        </div>
        <div className="input-news">
          <input
            className="inp-news"
            type="text"
            name=""
            id=""
            placeholder="Search"
            onChange={handleChange}
          />
        </div>
      </div>

      <div className="flex-news">
        {data && data
        .filter(
          (item) =>
            item.description.toLowerCase().includes(value.toLowerCase())
        )
        .map((d)=>(
          <div className="images-news" key={d.id}>
          <div className="news-images">
            <img
            onClick={()=> navigate(`${d.id}`)}
              className="img-news"
              src={d.img}
              alt=""
            />
            <p className="news-p">
              {d.description}
            </p>
          </div>
          </div>
        ))}
      </div>

      <div className="about-background">
        <div className="last-section-column">
          <div className="last-section-p">
            <p className="p-last">Subscribe to our Newsletter</p>
          </div>
          <div className="last-section-input">
            <p className="last-section-inp">Send to Email Admin</p>
            <Link to="/adminMessage">
            <button className="last-btn">Send</button>
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default News;
