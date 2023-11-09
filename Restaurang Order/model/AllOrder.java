package model;

import java.util.ArrayList;

/**
 * På AllOrder klasser lagrar och hanterar vi alla
 * informationer från Order klassen.
 */
public class AllOrder {
    static int orderId = 0;
    ArrayList<Orders> orders;

    /**
     * Här vi skapar en ny array list för att få information
     * från kundernas val från Gui
     *
     */
    public AllOrder() {
        orders = new ArrayList<>();
    }

    public ArrayList<Orders> getMyOrders() {
        return this.orders;
    }

    /**
     * Här vi skapar en konstruktur med parameter orders
     * Detta konstruktur skapar orders och
     * ger ett number till objektet
     * 
     * @param order
     */
    public void addingOrder(Orders order) {
        int orderId = orders.size();
        order.setNbr(orderId);
        this.orders.add(order);
    }

    /**
     * Här skapar vi ett objekt som ger
     * ett nummer till varje beställning som
     * kunder gör
     * 
     * @return
     */
    public int getNewOrders() {
        return orders.size();
    }

    /**
     * Vi skapar en array orders vilket kommer
     * lagra information vi får från Orders klass
     * 
     * @return
     */
    public Orders[] getorders() {
        Orders[] retOrder = new Orders[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            retOrder[i] = orders.get(i);
        }
        return retOrder;
    }

}
