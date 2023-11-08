import React from "react";
import "./style.css";
import { NavLink } from "react-router-dom";

const NavBar = (numProducts, kundvagnClick) => {
  return (
    <div className="navBar ">
      <NavLink to="/" className="navBarLink">
        Produkter
      </NavLink>
      <NavLink to="/kundvagn" className="navBarLink">
        Kundvagn <p className="kundvagnP">{numProducts.numProducts}</p>
      </NavLink>
    </div>
  );
};

export default NavBar;
