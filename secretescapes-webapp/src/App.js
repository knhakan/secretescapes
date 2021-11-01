import React from "react";
import Accounts from "./components/Accounts";
import Transfer from "./components/Transfer";
import { Route, Switch } from "react-router";
import { BrowserRouter } from "react-router-dom";
import Transactions from "./components/Transactions";
import Homepage from "./components/Homepage";


function App() {
  return (
    <div>
      <BrowserRouter>
        <Switch>
          <Route exact path="/" >
            <Homepage />
          </Route>
          <Route exact path="/accounts" >
            <Accounts />
          </Route>
          <Route exact path="/transfer" >
            <Transfer />
          </Route>
          <Route path="/transactions/:accountId" >
            <Transactions />
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
