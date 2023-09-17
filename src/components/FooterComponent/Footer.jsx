import React, {Component} from "react";
import {
    AiFillGithub,
    AiOutlineFacebook,
    AiOutlineLinkedin,
    AiOutlineSkype,
    AiOutlineMail
} from "react-icons/ai";
import { BsTelephoneOutbound } from "react-icons/bs";
import './footer.css'

class Footer extends Component {
    render(){
        return(
            <div className="Footer">
                <div className="icons">
                  <a className="icons-style" href="#"><AiFillGithub /></a>
                  <a className="icons-style" href="#"><AiOutlineFacebook /></a>
                  <a className="icons-style" href="#"><AiOutlineLinkedin /></a>
                  <a className="icons-style" href="#"><AiOutlineSkype /></a>
                </div>
                <div className="email-address">
                  <p><AiOutlineMail />vincentjoeld@gmail.com</p>
                  <p><BsTelephoneOutbound /> +237 69167866</p>
                </div>
            </div>
        )
    }
}

export default Footer;