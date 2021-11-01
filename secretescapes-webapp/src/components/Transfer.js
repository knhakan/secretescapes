import React, { useState } from "react";
import axios from 'axios';
import Header from "./Header";
import './Transfer.css';


function Transfer() {
  const [fromAccount, setFromAccount] = useState('');
  const [toAccount, setToAccount] = useState('');
  const [amount, setAmount] = useState('');
  const [status, setStatus] = useState(undefined);


  const handleSubmit = event => {

    event.preventDefault();
    const transfer = {
      toAccount: toAccount,
      fromAccount: fromAccount,
      amount: amount
    };
    axios.post(`api/pay`, { toAccount: transfer.toAccount, fromAccount: transfer.fromAccount, amount: transfer.amount })
      .then(res => {
        console.log(res);
        setStatus({ type: 'success' });
      })
      .catch(error => {
        console.log(error.response.data.error);
        setStatus({ type: 'error', error });
      })
  }
  return (
    <div>
      <Header />
      <h1 className="transfer-title">Make a Payment</h1>
      <div className="transfer-container">
        <form onSubmit={handleSubmit} className='payment-form'>
          <label className='transfer-label'>
            From:
            <input className='transfer-input' onChange={event => setFromAccount(event.target.value)} type="text" name="fromAccount" />
          </label>
          <label className='transfer-label'>
            To:
            <input className='transfer-input' onChange={event => setToAccount(event.target.value)} type="text" name="toAccount" />
          </label>
          <label className='transfer-label'>
            Amount:
            <input className='transfer-input' onChange={event => setAmount(event.target.value)} type="text" name="amount" />
          </label>
          <input className='transfer-button' type="submit" value="Send" />
        </form>
      </div>
      <div className='transfer-message'>
        {status?.type === 'success' && <p>Success! Payment has been done</p>}
        {status?.type === 'error' && (
          <p>Oups! Payment failed. Please insert a valid amount</p>
        )}
      </div>
    </div>
  );
}

export default Transfer;
