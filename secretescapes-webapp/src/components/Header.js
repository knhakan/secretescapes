import React from 'react'
import { Link } from 'react-router-dom'
import './Header.css';

function Header() {
    return (
        <div className='navbar'>
            <Link to='/' className='link'>
                Home
            </Link>
            <Link to='/accounts' className='link'>
                Accounts
            </Link>
            <Link to='/transfer' className='link'>
                Make a payment
            </Link>
        </div>
    )
}

export default Header;
