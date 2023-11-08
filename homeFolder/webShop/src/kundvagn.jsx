import "./style.css";
import { NavLink } from "react-router-dom";
export default function Kundvagn({
  produkterClick,
  kundvagn,
  emptyCart,
  // setShowProducts,
  emptyCartWithPurchase,
}) {
  const productCounts = kundvagn.reduce((count, product) => {
    count[product.name] = (count[product.name] || 0) + 1;
    return count;
  }, {});

  const totalPris = kundvagn.reduce((count, product) => {
    return count + product.price;
  }, 0);

  function handleBetala() {
    alert("Köpet har genomförts");
    emptyCartWithPurchase();
    //setShowProducts(false);
  }

  return (
    <div className="mainDiv" style={{ background: "violet" }}>
      <div className="finalProducts">
        <div className="productStorage">
          {Object.entries(productCounts).map(([product, count]) => (
            <p key={product}>{`${product} (${count} st)`}</p>
          ))}
        </div>
        <p className="totalPris">Total Pris: {totalPris} kr</p>
      </div>

      <button class="betalaOchTöm" onClick={handleBetala}>
        Betala
      </button>
      <NavLink
        to="/"
        onClick={() => {
          emptyCart(kundvagn);
          produkterClick();
        }}
      >
        {" "}
        <button className="töm">TÖM</button>
      </NavLink>
    </div>
  );
}
