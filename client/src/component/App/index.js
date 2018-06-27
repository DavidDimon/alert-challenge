import React from 'react';
import CardList from '../CardList';
import '../../style/App.css';
import "../../style/bootstrap.min.css";
import "../../style/bootstrap.css";

const App = ({
  alerts,
  refreshAlerts,
  searchAlerts
}) => {
  return <div className={"container"}>
      <div className={"row"}>
        <div className={"input-group"} style={{ marginTop: "10px", justifyContent: "center" }}>
          <select className={"form-control col-md-2"} onChange={e => searchAlerts(e.target.value)}>
            <option value="">Tipo</option>
            <option value={1}>Ruptura</option>
            <option value={2}>Acima</option>
            <option value={3}>Abaixo</option>
          </select>
          <input className={"form-control"} type={"text"} onChange={e => searchAlerts(e.target.value)} />
          <button className={"btn btn-info"} style={{ borderRadius: "0px" }} onClick={refreshAlerts}>
            Atualizar
          </button>
        </div>
      </div>
      <CardList alerts={alerts} />
    </div>;
};

export default App;
