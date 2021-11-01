import React from 'react'
import Header from './Header'
import './Homepage.css';

function Homepage() {
    return (
        <div>
            <Header />
            <div >
                <div>
                    <img className="homepage-image" src="/background.jpg" alt="homepage background" />
                    <h1 className="homepage-message">
                        Welcome to Secret Escapes Payment application
                    </h1>
                </div>
            </div>
        </div>
    )}

export default Homepage;

