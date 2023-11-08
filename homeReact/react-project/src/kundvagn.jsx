
import "./style.css";


export default function Kundvagn({produkterClick, products, numProducts, productPrices, emptyCart, setShowProducts, restoreStock}) {
    
    const productCounts = products.reduce((count, product)=>{
        count[product] = (count[product] || 0) + 1;
        return count;
    }, {});
    
    const totalPris = Object.keys(productCounts).reduce((total, product)=> {
        return total + (productCounts[product] * productPrices[product]);
    }, 0);
   
    // function handleTöm() {
    //     restoreStock(products);
    //     emptyCart();
    //     setShowProducts(false);
    // }

    function handleBetala() {
       alert("Köpet har genomförts")
        emptyCart();
        setShowProducts(false);
    }
   
    return(
    
        <div className="mainDiv" style={{background: "violet"}}>
        

        <div className="navBar">
            <button onClick={produkterClick}>Produkter</button>
            <button >Kundvagn<p className="kundvagnP"> {numProducts}</p></button>
                {/* här skriver vi in mängden produkterna där product är själva produkten och count är mängden. med hjälp av den productCounts funktionen sååå ökar vi antalet med 1 
                för varje gång vi klickar på en produkt */}
        <div className="productStorage">
                {Object.entries(productCounts).map(([product, count])=>(
                    <p key={product}>{`${product} (${count} st)`}</p>
                ))}
                

        </div>  
        <p className="totalPris">Total Pris: {totalPris} kr</p>
        </div>

        <button class="betalaOchTöm" onClick={handleBetala}>Betala</button>
        <button class="betalaOchTöm" onClick={()=> {emptyCart(); produkterClick();}} >TÖM</button> 
        

        </div>
    )
}