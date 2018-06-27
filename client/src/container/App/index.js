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
        console.log(data);
    });
}

const enhance = compose(
  withState("alerts", "setAlerts", []),
  withHandlers({ refreshAlerts }),
  lifecycle({
      componentWillMount(){
          const {alerts,setAlerts} = this.props;
            console.log("test");
            fetchAlerts().then(data => {
                setAlerts(data);
            });
          
      }
  })
);

export default enhance(App);