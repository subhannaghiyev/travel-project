import React, { useState } from "react";
import "./index.scss";
import { AiOutlineGooglePlus, AiOutlineTwitter } from "react-icons/ai";
import { FaPinterest } from "react-icons/fa";
import { BsMedium } from "react-icons/bs";
import { FiFacebook } from "react-icons/fi";
import axios from "axios";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Helmet } from "react-helmet";
import { Link } from "react-router-dom";
const Contact = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [subject, setSubject] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:4040/admin", {
        name,
        email,
        subject,
        message,
      });
      toast.success("Message Sent Successfully!");
    } catch (error) {
      console.error(error);
    }
  };
  return (
    <>
      <Helmet>
        <meta charSet="utf-8" />
        <title>Contact</title>
        <link rel="canonical" href="http://mysite.com/example" />
      </Helmet>
      <div className="background-image-2-contact">
        <div className="text-about">
          <p className="p-about">Contact</p>
          <p className="p-about-1">Home / Contact</p>
        </div>
        <div className="sect-2">
          <div className="text-h3">
            <h3 className="h3">Find the Adventure of a lifetime</h3>
          </div>
          <div className="input">
            <div
              style={{ display: "flex", flexDirection: "column", gap: "10px" }}
            >
              <label
                style={{ textAlign: "start", fontFamily: "chillax-regular" }}
              >
                Destination:
              </label>
              <input className="inp" type="text" placeholder="Keyword here" />
            </div>
            <div
              style={{ display: "flex", flexDirection: "column", gap: "10px" }}
            >
              <label
                style={{ textAlign: "start", fontFamily: "chillax-regular" }}
              >
                Adventure type:
              </label>
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
              <label
                style={{ textAlign: "start", fontFamily: "chillax-regular" }}
              >
                Min price
              </label>
              <select className="inp-price">
                <option value=""></option>
                <option value="option1">price</option>
                <option value="option2">price</option>
              </select>
            </div>
            <div
              style={{ display: "flex", flexDirection: "column", gap: "10px" }}
            >
              <label
                style={{ textAlign: "start", fontFamily: "chillax-regular" }}
              >
                Max price
              </label>
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

      <div className="sect-3-contact">
        <h4 className="h4">Get in touch</h4>
        <p className="p-sect-3">SAY HELLO</p>
      </div>

      <div className="sect-4-contact-display">
        <div className="sect-4-contact-column">
          <p className="contact-p">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce
            fringilla lectus nec diam auctor, ut fringilla diam sagittis.
            Quisque vel est id justo faucibus dapibus id a nibh. Aenean suscipit
            consequat lacus, sit amet mollis nulla. Morbi sagittis orci id lacus
            convallis tempus eget sit amet metus.
          </p>
          <div className="sect-4-contact-2">
            <div className="i-contact">i</div>
            <div className="p-text">
              <p className="p-word">
                Address: 1481 Creekside Lane Avila Beach, CA 93424
              </p>
              <p className="p-word">Phone: +53 345 7953 32453</p>
              <p className="p-word">Email: miloThemes@gmail.com</p>
              <div className="contact-icons">
                <Link to="https://www.gmail.com/">
                  <AiOutlineGooglePlus
                    className="icons-1"
                    style={{ padding: "10", fontSize: "20px" }}
                  />
                </Link>
                <Link to="https://tr.pinterest.com/">
                  <FaPinterest
                    className="icons-2"
                    style={{ padding: "10", fontSize: "20px" }}
                  />
                </Link>
                <Link to="https://www.facebook.com/">
                  <FiFacebook
                    className="icons-3"
                    style={{ padding: "10", fontSize: "20px" }}
                  />
                </Link>
                <Link to="https://medium.com/@naghiyevsubhan2003">
                  <BsMedium
                    className="icons-4"
                    style={{ padding: "10", fontSize: "20px" }}
                  />
                </Link>
              </div>
            </div>
          </div>
        </div>
        <div className="contact-input">
          <div>
            <input
              className="contact-inp"
              type="text"
              name="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="Name"
            />
            <input
              className="contact-inp"
              type="email"
              name="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="E-mail"
            />
            <input
              className="contact-inp"
              type="text"
              name="subject"
              value={subject}
              onChange={(e) => setSubject(e.target.value)}
              placeholder="Subject"
            />
            <input
              className="contact-inp-2"
              type="text"
              name="message"
              value={message}
              onChange={(e) => setMessage(e.target.value)}
              placeholder="Message"
            />
          </div>
          <div className="div-button">
            <button className="btn-contact" onClick={handleSubmit}>
              Send
            </button>
          </div>
        </div>
      </div>

      <iframe
        className="map"
        src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d24308.210650026278!2d49.800623349999995!3d40.3971895!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2saz!4v1687555835781!5m2!1sen!2saz"
        title="Google Maps"
        width="600"
        height="450"
        style={{ border: "0" }}
        allowFullScreen=""
        loading="lazy"
        referrerPolicy="no-referrer-when-downgrade"
      ></iframe>

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
      <ToastContainer />
    </>
  );
};

export default Contact;
