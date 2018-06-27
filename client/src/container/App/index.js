import {compose, withState, withHandlers,lifecycle } from 'recompose';
import App from '../../component/App';

const fetchAlerts = () => {
    return fetch("http://localhost:8080/alertas").then(response =>
      response.json()
    ).then(data => {return data});
}

const refreshAlerts = ({setAlerts}) => () => {
    fetchAlerts().then(data => {
        setAlerts(data);
    });
}

const searchAlerts = ({setAlerts,alerts,oldAlerts}) => (event) => {
    let result = oldAlerts;
    let searchParam = event;
    if (event && !isNaN(event)){
        result = result.filter(data => data.flTipo == event);
        searchParam = '';
    }
    if (searchParam) {
      result = result.filter(data => data.pontoDeVenda
          .toLowerCase()
          .normalize("NFD")
          .replace(/[\u0300-\u036f]/g, "")
          .includes(searchParam
              .toLowerCase()
              .normalize("NFD")
              .replace(/[\u0300-\u036f]/g, "")));
    }
    setAlerts(result);
    if (!event) {
        setAlerts(oldAlerts);
    }
}

const enhance = compose(
  withState("alerts", "setAlerts", []),
  withState("oldAlerts", "setOldAlerts", []),
  withHandlers({ refreshAlerts,searchAlerts }),
  lifecycle({
      componentWillMount(){
          const {alerts,setAlerts,setOldAlerts} = this.props;
            fetchAlerts().then(data => {
                setAlerts(data);
                setOldAlerts(data);
        });
      }
  })
);

export default enhance(App);