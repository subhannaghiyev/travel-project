import React, { useRef } from "react";
import emailjs from "emailjs-com";
import "./index.scss";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const AdminMessage = () => {
  const navigate = useNavigate();
  const form = useRef(null);

  const sendEmail = (e) => {
    e.preventDefault();

    const { user_name, user_email, message } = form.current.elements;

    emailjs.sendForm(
      "service_9eq9lpj",
      "template_ilmt003",
      form.current,
      "7axxSR5_Ims8FgA4O"
    );
    toast
      .success("Message sent Successfully!", {
        autoClose: 1000,
      })
      .then(
        (result) => {
          console.log(result.text);
          console.log("message sent");
          toast.success("Message sent Successfully!", {
            autoClose: 1000,
          });
        },
        (error) => {
          console.log(error.text);
          console.log("Email js not connected");
          toast.success("Message sent Successfully!", {
            autoClose: 1000,
          });
        }
      );
    toast.success("Message sent Successfully!", {
      autoClose: 1000,
    });
  };
  const handleSubmit = () => {
    navigate("/");
    // Swal.fire({
    //   icon: "success",
    //   title: "Message sent Successfully!",
    // });
    toast.success("Message sent Successfully!",{
      autoClose : 1000
    });
  };

  return (
    <div className="background-admin">
      <div className="message-admin">
        <form className="form-msg" onSubmit={sendEmail} ref={form}>
          <div className="label-start">
            <label className="label" htmlFor="user_name">
              Name
            </label>
            <input
              className="message-inp"
              type="text"
              name="user_name"
              id="user_name"
              placeholder="Enter Your Name"
            />
          </div>
          <div className="label-start">
            <label className="label" htmlFor="user_email">
              Email
            </label>
            <input
              className="message-inp"
              type="email"
              name="user_email"
              id="user_email"
              placeholder="Enter Email Address"
            />
          </div>
          <div className="label-start">
            <label className="label" htmlFor="message">
              Message
            </label>
            <input
              className="message-inp-m"
              type="text"
              name="message"
              id="message"
              placeholder="Message"
            />
            <div className="buttons-msg">
              <button onClick={handleSubmit} type="submit" className="btn-msg">
                Send
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AdminMessage;
