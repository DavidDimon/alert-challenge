import React from 'react';
import '../../style/App.css';

const App = ({alerts,refreshAlerts}) => {
  return <div>
      test
      <button onClick={refreshAlerts}>Refresh</button>
    </div>;
}

export default App;
