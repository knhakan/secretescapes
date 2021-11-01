import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router';
import Header from './Header';
import './Transactions.css';

function Transactions() {
  const { accountId } = useParams();
  const [fromAccount, setFromAccount] = useState([]);
  const [toAccount, setToAccount] = useState([]);
  const [amount, setAmount] = useState([]);

  useEffect(() => {
    axios.get(`api/transactions/` + accountId)
      .then(res => {
        for (let index = 0; index < res.data.length; index++) {
          setAmount(oldArray => [...oldArray, res.data[index].amount]);
          setFromAccount(oldArray => [...oldArray, res.data[index].fromAccount]);
          setToAccount(oldArray => [...oldArray, res.data[index].toAccount]);
        }
      })
      // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])

  return (
    <div>
      <Header />
      <h2 className="transactions-title"> Transactions </h2>
      <table className='transactions-table'>
        <thead >
          <tr>
            <th > From </th>
            <th> To </th>
            <th> Amount </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th className='transactions-row'>{fromAccount.map((from) => <div key={from}> {from} </div>)} </th>
            <th className='transactions-row'>{toAccount.map((to) => <div key={to}> {to} </div>)}</th>
            <th className='transactions-row'> {amount.map((am) => <div key={am}> {am} </div>)}  </th>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default Transactions;
