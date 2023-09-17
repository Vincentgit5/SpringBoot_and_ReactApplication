import React, { Component } from "react";
import { FaUserAlt, FaCartPlus, FaSearch } from "react-icons/fa";
import { AiOutlineHome } from "react-icons/ai";
import { BiLogInCircle } from "react-icons/bi";
import { BiLogOutCircle } from "react-icons/bi";
import AuthenticationService from "../LoginComponent/AuthenticationService.js";
import { BiCategory } from "react-icons/bi";
import { MdOutlineProductionQuantityLimits } from "react-icons/md";
import {IoNotificationsOutline} from "react-icons/io5"
import { Link } from "react-router-dom";
import './Header.css'

class Header extends Component {
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return (
            <div>
                <div className=" container">
                    <div className="header">
                        <h2>Spring Web Site</h2>
                        <a href="panier" className="icons"><FaCartPlus className="Icon" />shopping cart</a>
                        <form>
                            <input type="text" placeholder="Search.." name="search" />
                            <button type="submit"><FaSearch /></button>
                        </form>
                        <a href="profile" className="icons"><FaUserAlt className="Icon" /> Profile</a>
                    </div>
                </div>
                <nav className="navbar navbar-expand-md ">
                    <div>
                        <a className="navbar-brand">ReacSpringApp</a>
                    </div>
                    <ul className="navbar-nav">
                        {isUserLoggedIn && (
                            <li>
                                <Link className="nav-link" to="/Welcome/username">
                                    <AiOutlineHome className="nav-icons" />
                                    Home
                                </Link>
                            </li>
                        )}
                        {isUserLoggedIn && (
                            <li>
                                <Link className="nav-link" to="/ListElements">
                                    <MdOutlineProductionQuantityLimits className="nav-icons" />
                                    Products
                                </Link>
                            </li>
                        )}
                         {isUserLoggedIn && (
                            <li>
                                <Link className="nav-link" to="/Welcome/username">
                                    <BiCategory className="nav-icons" />
                                    Category
                                </Link>
                            </li>
                        )}
                        {isUserLoggedIn && (
                            <li>
                                <Link className="nav-link" to="/ListElements">
                                    <IoNotificationsOutline className="nav-icons" />
                                    About
                                </Link>
                            </li>
                        )}
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && (
                            <li>
                                <Link className="nav-link" to="/Login">
                                    <BiLogInCircle className="nav-icons" />
                                    Login
                                </Link>
                            </li>
                        )}
                        {isUserLoggedIn && (
                            <li>
                                <Link
                                    className="nav-link"
                                    to="/Logout"
                                    onClick={AuthenticationService.logout}
                                >
                                    <BiLogOutCircle className="nav-icons-red" />
                                    Logout
                                </Link>
                            </li>
                        )}
                    </ul>
                </nav>

            </div>

        )
    }
}

export default Header;