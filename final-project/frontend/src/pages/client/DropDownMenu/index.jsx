import React from 'react'
import { Link } from 'react-router-dom'
import "./index.scss"
const DropDownMenu = () => {
  return (
    <>
    <ul className='ul-drop'>
    <li className='li-drop'><Link to="/admin/loginAdmin">Admin Login</Link></li>
    <li  className='li-drop'><Link to="/login">Login</Link></li>
    </ul>
    </>
  )
}

export default DropDownMenu