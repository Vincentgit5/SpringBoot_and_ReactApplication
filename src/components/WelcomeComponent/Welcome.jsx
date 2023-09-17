import React, { Component } from 'react';
import { Link } from "react-router-dom";

class Welcome extends Component {
  render() {
    return (
      <div>
        <h1>Welcome!</h1>
        <div className='container'>To access on Students page Click 
          {this.props.username} <Link to="/ListElements">here</Link>
        </div>
      </div>
    )}
}

export default Welcome;