import React from 'react';
import CardListItem from "../CardListItem";
import "../../style/App.css";

const CardList = ({ alerts }) => {
    const cardItems = alerts.map((alert, index)=> (
      <CardListItem
        key={index}
        alert={alert}
      />
    ));

  return <div className={"container"}>
      <div className={"row"}>
      {cardItems}
      </div>
    </div>;
};

export default CardList;
