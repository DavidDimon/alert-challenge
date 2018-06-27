import React from "react";
import "../../style/App.css";
import "../../style/bootstrap.min.css";

const CardListItem = ({ alert }) => {
  return <div className={"col-md-4"}>
      <div className={"card"} style={{ marginTop: 10, marginBottom: 5 }}>
        <div className={"card-body"}>
            <div style={{ fontSize: "18px" }}>{alert.descricao}</div>
            {alert.margem ? <div style={{ fontSize: "18px" }}>
                {"Margem: " + alert.margem}
              </div> : <div />}
            <div style={{ fontSize: "15px" }}>{alert.pontoDeVenda}</div>
            <div style={{ fontSize: "12px" }}>{alert.produto}</div>
        </div>
      </div>
    </div>;
};

export default CardListItem;
