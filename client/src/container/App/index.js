import {compose, withState, withHandlers } from 'recompose';

import App from '../../component/App';

const refreshAlerts = ({setAlerts}) => () => {
    fetch("http://localhost:8080/alertas")
      .then(response => response.json())
      .then(data => setAlerts(data));
}

const enhance = compose(
    withState("alerts", "setAlerts",[]),
    withHandlers({refreshAlerts})
);

export default enhance(App);