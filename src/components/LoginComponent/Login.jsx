import React, { Component } from 'react';
import { useNavigate } from 'react-router-dom';
import AuthenticationService from './AuthenticationService.js';
import './Login.css'

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: 'vincent',
      password: '',
      hasLoginField: false,
      hasLoginSuccess: false,
    };
    this.handleChange = this.handleChange.bind(this);
    this.LoginClick = this.LoginClick.bind(this);
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  LoginClick() {
    if (this.state.username === 'vincent' && this.state.password === 'joel') {
      AuthenticationService.registerSuccessfulLogin(this.state.username, this.state.password);
      const navigate = this.props.navigate;
      navigate(`/Welcome/${this.state.username}`);
      console.log(this.state);
      this.setState({ hasLoginSuccess: true });
      this.setState({ hasLoginField: false });
    } else {
      this.setState({ hasLoginSuccess: false });
      this.setState({ hasLoginField: true });
    }
  }

  render() {
    return (
      <div className="login">
        <h1>Login</h1>
        <div className='containers'>
          {
            this.state.hasLoginField &&
            <div className='alert alert-warning'>
              User name or password is incorrect
            </div>
          }
          {
            this.state.hasLoginSuccess
            && <div>Login Successful
            </div>
          }
          <label for="username">User Name: </label>
          <input
            type="text" name="username"
            value={this.state.username}
            onChange={this.handleChange}
          />
          <label for="password">Password:</label>
          <input
            type="password"
            name="password"
            value={this.state.password}
            onChange={this.handleChange}
          />
          <button className='botton'
            onClick={this.LoginClick}>
            Login
          </button>
          <div className="container">
            <span className="password">
              Forgot
              <a href="#">password?</a>
            </span>
          </div>
        </div>
      </div>
    );
  }
}

const LoginWrapper = () => {
  const navigate = useNavigate();
  return <Login navigate={navigate} />;
};

export default LoginWrapper;