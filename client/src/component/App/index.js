import React from 'react';
import CardList from '../CardList';
import '../../style/App.css';
import "../../style/bootstrap.min.css";
import "../../style/bootstrap.css";

const App = ({alerts,refreshAlerts}) => {

  return <div className={"container"}>
      <div className={"row"}>
        <div className={"input-group"} style={{ marginTop: "10px", justifyContent: "center" }}>
          <select className={"dropdown-menu"}>
            <option value="tipo">Tipo</option>
            <option value="pontoVenda">Ponto de Venda</option>
          </select>
          <input className={"form-control"} type={"text"} />
          <button className={"btn btn-primary"} style={{ borderRadius: "0px" }} onClick={refreshAlerts}>
            Search
          </button>
          <button className={"btn btn-info"} style={{ borderRadius: "0px" }} onClick={refreshAlerts}>
            Refresh
          </button>
        </div>
      </div>
      <CardList alerts={alerts} />
    </div>;
}

export default App;
