import React, { useState, useEffect } from "react";
import axios from 'axios';
import Header from "./Header";
import { Link } from "react-router-dom";
import './Accounts.css';

function Accounts() {
  const [accounts, setAccounts] = useState([]);

  useEffect(() => {
    axios.get(`api/account`)
      .then(res => {
        setAccounts(res.data);
      })
  }, [])

  return (
    <div>
      <Header />
      <h2 className="accounts-title">Accounts </h2>
      <div>
        <table className='accounts-table'>
          <thead className="accounts-table-title">
            <tr >
              <th> Name </th>
              <th>Balance</th>
              <th> Email address</th>
            </tr>
          </thead>
          {accounts.map((account, index) =>
            <tbody>
              <tr className='accounts-row'>
                <th><Link to={`/transactions/${index + 1}`} className='accounts-link'>  {account.name} </Link></th>
                <th><Link to={`/transactions/${index + 1}`} className='accounts-link'> {account.balance}  </Link></th>
                <th><Link to={`/transactions/${index + 1}`} className='accounts-link'> {account.emailaddress}</Link></th>
              </tr>
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
}
export default Accounts;
