import React from "react";
import "./style.css";

export default function Products({ buyProduct, products }) {
  function handleClick(product, index) {
    if (product.stock > 0) {
      buyProduct(product, index);
    }
  }

  return (
    <div className="mainDiv">
      {/* <div className="navBar">
        <button>Produkter</button>
        <button onClick={kundvagnClick}>
          Kundvagn <p className="kundvagnP">{numProducts}</p>
        </button>
      </div> */}

      <div className="liDiv">
        {products.map((product, index) => {
          return (
            <div className="top">
              <img
                src={product.imgSrc}
                alt=""
                style={{ width: "110px", height: "120px" }}
              />
              <ul className="productInfo">
                <li>{product.name}</li>
                <li className>Lager {product.stock}</li>
                <li className="price">Pris: {product.price} kr</li>
                <button
                  onClick={() => handleClick(product, index)}
                  className={`buyButton ${
                    product.stock === 0 ? "redButton" : ""
                  }`}
                >
                  Buy
                </button>
              </ul>
            </div>
          );
        })}
      </div>
    </div>
  );
}
