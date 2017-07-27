import * as React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
// import RaisedButton from 'material-ui/RaisedButton';
import MyComponent from './MyComponent' 


class App extends React.Component<any, any> {
  render() {
    return (
      <MuiThemeProvider>
        <MyComponent />
      </MuiThemeProvider>
    )
  }
}
 
export default App;