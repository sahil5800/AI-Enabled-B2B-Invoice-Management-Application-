import React from "react";
import "../App.css"

const Footer = () => {
    return(
        <div className = "main-footer">
            <div className = "footer_content">
               <h6 style={{textAlign: "center"}}><a href="https://www.highradius.com/privacy-policy/">Privacy Policy </a> | &copy;{new Date().getFullYear()} HighRadius Corporation. All Right Reserved.</h6>
            </div>
        </div>       
    )
}
export default Footer;