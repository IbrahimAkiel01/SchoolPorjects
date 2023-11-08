import React from "react";
import "./style.css";

export default function Products({buyProduct, kundvagnClick, numProducts, productCounts, productPrices}) {

    function handleClick(productName) {  
        if(productCounts[productName] > 0) {
            buyProduct(productName);
        }
    }

    return (
        <div className="mainDiv">
            <div className="navBar">
                <button>Produkter</button>
                <button onClick={kundvagnClick}>Kundvagn <p className="kundvagnP">{numProducts}</p></button>
            </div>
                
            <div className="liDiv">
                <li className="top">
                    <p>Produkt 1</p>
                    <p className="lager">Lager {productCounts["Produkt 1"]}</p>
                    <p className="price">Pris: {productPrices["Produkt 1"]} kr</p>
                    <button onClick={()=> handleClick("Produkt 1")} className={`buyButton ${productCounts["Produkt 1"] === 0 ? 'redButton' : ''}`}>Buy</button>
                </li>
                <li className="top">
                    <p>Produkt 2</p>
                    <p className="lager">Lager {productCounts["Produkt 2"]}</p>
                    <p className="price">Pris: {productPrices["Produkt 2"]} kr</p>

                    <button onClick={()=> handleClick("Produkt 2")} className={`buyButton ${productCounts["Produkt 2"] === 0 ? 'redButton' : ''}`}>Buy</button>
                </li>
                <li className="top">
                    <p>Produkt 3</p>
                    <p className="lager">Lager {productCounts["Produkt 3"]}</p>
                    <p className="price">Pris: {productPrices["Produkt 3"]} kr</p>

                    <button onClick={()=> handleClick("Produkt 3")} className={`buyButton ${productCounts["Produkt 3"] === 0 ? 'redButton' : ''}`}>Buy</button>
                </li>
                <li className="bottom">
                    <p>Produkt 4</p>
                    <p className="lager">Lager {productCounts["Produkt 4"]}</p>
                    <p className="price">Pris: {productPrices["Produkt 4"]} kr</p>

                    <button onClick={()=> handleClick("Produkt 4")} className={`buyButton ${productCounts["Produkt 4"] === 0 ? 'redButton' : ''}`}>Buy</button>
                </li>
                <li className="bottom">
                    <p>Produkt 5</p>
                    <p className="lager">Lager {productCounts["Produkt 5"]}</p>
                    <p className="price">Pris: {productPrices["Produkt 5"]} kr</p>

                    <button onClick={()=> handleClick("Produkt 5")} className={`buyButton ${productCounts["Produkt 5"] === 0 ? 'redButton' : ''}`}>Buy</button>
                </li>
            </div>
        </div>
    );
}
