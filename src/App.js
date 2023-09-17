import React, { Component } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/LoginComponent/Login';
import Welcome from './components/WelcomeComponent/Welcome';
import Error from './components/ErrorComponent/Error';
import ListElements from './components/ListElementsComponent/ListElements';
import Header from './components/HeaderComponent/Header';
import Footer from './components/FooterComponent/Footer';
import Logout from './components/LogoutComponent/logout';
import './bootstrap.css'
import './App.css'

class App extends Component {
  render() {
    return (
      <div className='App'>
      <Router>
      <Header/>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/Login" element={<Login />} />
          <Route path="/Logout" element={<Logout />} />
          <Route path="/Welcome/:username" element={<Welcome />} />
          <Route path="/ListElements" element={<ListElements />} />
          <Route path="*" element={<Error />} />
        </Routes>
        <Footer/>
      </Router>
      </div>
    );
  }
}

export default App;