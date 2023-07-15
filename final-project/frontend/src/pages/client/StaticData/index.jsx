import React from 'react'
import { useNavigate } from 'react-router-dom'
import "./index.scss"
const StaticData = () => {
    const navigate = useNavigate();
  return (
    <>
    <div className='background-img'>
    <div className="about-display">
        <div className="about-image">
          <img
            className="about-img-1"
            src="https://preview.colorlib.com/theme/destino/images/about.jpg"
            alt=""
          />
        </div>
        <div className="about-text">
          <p className="about-p">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce
            fringilla lectus nec diam auctor, ut fringilla diam sagittis.
            Quisque vel est id justo faucibus dapibus id a nibh. Aenean suscipit
            consequat lacus, sit amet mollis nulla. Morbi sagittis orci id lacus
            convallis tempus eget sit amet metus. Sed finibus, magna at euismod
            aliquet, enim justo vulputate lorem, sit amet elementum dolor eros
            sollicitudin dui. Sed ac magna mauris. Nullam lectus odio, viverra
            vel mi id, interdum imperdiet nulla.
          </p>
        </div>
        <div className="buttons-1">
            <button onClick={()=>navigate("/about")} className="about-btn-1">Go Back</button>
          </div>
      </div>
    </div>
    </>
  )
}

export default StaticData