import { useState } from "react";
import Products from "./products";
import Kundvagn from "./kundvagn";

export default function App() {
  const [showProducts, setShowProducts] = useState(true);
  const [showKundvagn, setShowKundvagn] = useState(false);
  const [insertProduct, setInsertProduct] = useState([]);
  const [numProducts, setNumProducts] = useState(0);

  const [productCounts, setProductCounts] = useState({
    "Produkt 1": 5,
    "Produkt 2": 7,
    "Produkt 3": 3,
    "Produkt 4": 10,
    "Produkt 5": 4
  });

  const [productPrices] = useState({
    "Produkt 1": 50,
    "Produkt 2": 70,
    "Produkt 3": 30,
    "Produkt 4": 80,
    "Produkt 5": 40
  });

  function handleProductClick() {
    setShowProducts(true);
    setShowKundvagn(false);
  }

  function handleKundvagnClick() {
    setShowProducts(false);
    setShowKundvagn(true);
  }

  function buyProduct(productName) {
   
    if(productCounts[productName] > 0) {
   
    setInsertProduct(prevProducts => [...prevProducts, productName]);
   
    setNumProducts(prevNum => prevNum + 1);

    // Här uppdateras lagernivån
    setProductCounts(prevCounts => ({
      ...prevCounts,
      [productName]: prevCounts[productName] - 1
    }));
  }
}

  function emptyCart() {
    setInsertProduct([]);
    setNumProducts(0);
    setShowProducts(true);
    // window.location.reload(); // lite fusk här hehe
  }

//   function restoreStock(products) {
//     setProductCounts(prevCounts => {
//         const updatedCounts = { ...prevCounts };
//         products.forEach(product => {
//             updatedCounts[product] += 1;
//         });

//         return updatedCounts;
//     });
// }

  return (
    <div>
      {showProducts && (
        <Products
          buyProduct={buyProduct}
          kundvagnClick={handleKundvagnClick}
          numProducts={numProducts}
          productCounts={productCounts} // Skickar lagernivåerna som props 
          productPrices={productPrices}
          
        />
      )}
      {showKundvagn && (
        <Kundvagn
          produkterClick={handleProductClick}
          products={insertProduct}
          numProducts={numProducts}
          productPrices={productPrices}
          emptyCart={emptyCart}
          setShowProducts={setShowProducts}
          // restoreStock={restoreStock}
        />
      )}
    </div>
  );
}
