import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { useState } from "react";
import Products from "./products";
import Kundvagn from "./kundvagn";
import NavBar from "./NavBar";
import boxning from "./images/boxning.jpg";
import handskar from "./images/handskar.webp";
import mössa from "./images/mössa.webp";
import skor from "./images/skor.jpeg";
import strumpor from "./images/strumpor.jpg";

export default function App() {
  //const [showProducts, setShowProducts] = useState(true);
  const [showKundvagn, setShowKundvagn] = useState(false);
  const [kundvagn, setKundvagn] = useState([]);
  const [numProducts, setNumProducts] = useState(0);

  // jag vet inte exakt hur du menade med att inte använda states men
  // jag behöver fortfarande använda det för min array med objekt

  const [products, setProducts] = useState([
    {
      name: "produkt 1",
      stock: 5,
      price: 50,
      imgSrc: boxning,
    },
    {
      name: "produkt 2",
      stock: 7,
      price: 70,
      imgSrc: handskar,
    },
    {
      name: "produkt 3",
      stock: 10,
      price: 90,
      imgSrc: mössa,
    },
    {
      name: "produkt 4",
      stock: 3,
      price: 100,
      imgSrc: skor,
    },
    {
      name: "produkt 5",
      stock: 4,
      price: 20,
      imgSrc: strumpor,
    },
  ]);

  function handleProductClick() {
    // setShowProducts(true);
    setShowKundvagn(false);
  }

  function handleKundvagnClick() {
    // setShowProducts(false);
    setShowKundvagn(true);
  }

  function buyProduct(product, index) {
    if (product.stock > 0) {
      setKundvagn((prevProducts) => [...prevProducts, product]);

      setNumProducts((prevNum) => prevNum + 1);
      setProducts((prevProducts) => {
        const updatedProducts = [...prevProducts];
        updatedProducts[index] = {
          ...updatedProducts[index],
          stock: updatedProducts[index].stock - 1,
        };
        return updatedProducts;
      });
    }
  }

  function emptyCart(kundvagn) {
    setProducts((prevProducts) => {
      const updatedProducts = [...prevProducts];
      kundvagn.map((product) => {
        const prevProduct = updatedProducts.findIndex(
          (p) => p.name === product.name
        );
        console.log("HELLO", updatedProducts.prevProduct);
        updatedProducts[prevProduct] = {
          ...updatedProducts[prevProduct],
          stock: updatedProducts[prevProduct].stock + 1,
        };
      });
      return updatedProducts;
    });
    setKundvagn([]);
    setNumProducts(0);
    //setShowProducts(true);

    // window.location.reload(); // lite fusk här hehe
  }

  function emptyCartWithPurchase(kundvagn) {
    setKundvagn([]);
    setNumProducts(0);
  }

  return (
    <div>
      <NavBar numProducts={numProducts} kundvagnClick={handleKundvagnClick} />

      <Routes>
        <Route
          path="/"
          element={
            <Products
              buyProduct={buyProduct}
              products={products} // Skickar lagernivåerna som props
            />
          }
        ></Route>

        <Route
          path="/kundvagn"
          element={
            <Kundvagn
              produkterClick={handleProductClick}
              kundvagn={kundvagn}
              numProducts={numProducts}
              productPrices={products.map((product) => product.price)}
              emptyCart={emptyCart}
              emptyCartWithPurchase={emptyCartWithPurchase}
              // setShowProducts={setShowProducts}
              // restoreStock={restoreStock}
            />
          }
        ></Route>
      </Routes>
    </div>
  );
}
