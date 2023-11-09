package controller;

//only imports what is strictly necessary from view-package
/**
 * Här importerar jag bara den som är nödvändig från model och view-package
 */
import model.*;
import view.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Syftet med Controller klassen är att skapa olika beställningar via input,
 * men också att visa de produkter som kan väljas till menyn.
 * Controller tillhandahåller också kopplingen mellan entity och
 * boundaryklasser.
 */

public class Controller {
    private MainFrame view;
    private Orders newOrder;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;

    private ArrayList<Pizza> pizzas;
    private ArrayList<Drinks> drinks1;
    Pizza pizza;
    Drinks drinks;
    AllOrder allOrder;

    public Controller() {
        allOrder = new AllOrder();
        newOrder = new Orders(0);
        view = new MainFrame(1000, 500, this);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
        orderPizza();
        orderDrinks();
    }

    public void orderPizza() {
        pizzas = new ArrayList<>();
        pizza = new Pizza("Ömers Special Pizza", 115, new ToppingsPizza[] { ToppingsPizza.Tomato_sauce,
                ToppingsPizza.Pizza_cheese, ToppingsPizza.Gyros, ToppingsPizza.Olives, ToppingsPizza.Mushrooms });
        pizzas.add(pizza);
        pizza = new Pizza("Ibrahims Special Pizza", 115,
                new ToppingsPizza[] { ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Kebab });
        pizzas.add(pizza);
        pizza = new Pizza("Margerita", 85,
                new ToppingsPizza[] { ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese });
        pizzas.add(pizza);
        pizza = new Pizza("Vesuvio", 93,
                new ToppingsPizza[] { ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Ham });
        pizzas.add(pizza);
        pizza = new Pizza("Hawai", 93, new ToppingsPizza[] { ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese,
                ToppingsPizza.Ham, ToppingsPizza.Pineapple });
        pizzas.add(pizza);
        pizza = new Pizza("Romeo & Julia", 93, new ToppingsPizza[] { ToppingsPizza.Tomato_sauce,
                ToppingsPizza.Pizza_cheese, ToppingsPizza.Ham, ToppingsPizza.Pepperoni, ToppingsPizza.Mushrooms });
        pizzas.add(pizza);
        pizza = new Pizza("Pepperoni", 93, new ToppingsPizza[] { ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese,
                ToppingsPizza.Pepperoni, ToppingsPizza.Onion });
        pizzas.add(pizza);
        pizza = new Pizza("Capricciosa", 93, new ToppingsPizza[] { ToppingsPizza.Tomato_sauce,
                ToppingsPizza.Pizza_cheese, ToppingsPizza.Ham, ToppingsPizza.Mushrooms });
        pizzas.add(pizza);
        pizza = new Pizza("Pesto", 99,
                new ToppingsPizza[] { ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Pesto,
                        ToppingsPizza.Mushrooms, ToppingsPizza.Asparagus, ToppingsPizza.Sun_dried_tomatoes });
        pizzas.add(pizza);
        pizza = new Pizza("Vegetariana", 99,
                new ToppingsPizza[] { ToppingsPizza.Tomato_sauce, ToppingsPizza.Pizza_cheese, ToppingsPizza.Mushrooms,
                        ToppingsPizza.Onion, ToppingsPizza.Olives, ToppingsPizza.Artichoke });
        pizzas.add(pizza);
    }

    public void orderDrinks() {
        drinks1 = new ArrayList<>();
        drinks1.add(new Drinks("Water", 10));
        drinks1.add(new Drinks("Orange/Apple Juice", 25));
        drinks1.add(new Drinks("Milk", 25));
        drinks1.add(new Drinks("Coffee/Tea", 25));
        drinks1.add(new Drinks("Espresso/Cappucino/Caffe Latte", 35));
        drinks1.add(new AlcoholicBeverages("Staropramen 50cl (Czech beer)", 69, 5.2));
        drinks1.add(new AlcoholicBeverages("Eriksberg 50cl (Swedish beer)", 65, 5.2));
        drinks1.add(new AlcoholicBeverages("Falcon 50cl (Swedish beer)", 65, 5));
        drinks1.add(new AlcoholicBeverages("Apple Cider 33cl", 55, 5));
        drinks1.add(new AlcoholicBeverages("A glass of House Wine", 69, 20));

    }

    private String[] getPizzasStrings() {
        String[] strings = new String[pizzas.size()];
        for (int j = 0; j < strings.length; j++) {
            strings[j] = pizzas.get(j).toString();
        }
        return strings;
    }

    private String[] getDrinksString() {
        String[] strings = new String[drinks1.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = drinks1.get(i).toString();
        }
        return strings;
    }

    private String[] allOrderstring() {
        Orders[] orders = allOrder.getorders();
        System.out.println(orders.length);
        String[] strings = new String[orders.length];
        for (int i = 0; i < orders.length; i++) {
            System.out.println("heloo");
            System.out.println(orders[i].toString());
            strings[i] = orders[i].toString();
        }
        return strings;
    }

    public void buttonPressed(ButtonType button) {

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Food:
                setToFoodMenu();
                break;

            case Drinks:
                setToDrinkMenu();
                break;

            case Delete:
                deleteOrders();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                placeOrder(view.getSelectionLeftPanel());
                break;

            case ViewOrder:
                viewSelectedOrder();
                break;
        }
    }

    public void addItemToOrder(int selectionIndex) {
        if (selectionIndex != -1) { // if something is selected in the left menu list
            switch (currentLeftMenu) { // This might need to change depending on architecture
                case Food:
                    newOrder.addProduct(pizzas.get(selectionIndex));
                    break;
                case Drinks:
                    if (drinks1.get(selectionIndex) instanceof AlcoholicBeverages) {
                        String message = JOptionPane.showInputDialog("Please add your age!");
                        if (Integer.parseInt(message) >= 18) {
                            newOrder.addProduct(drinks1.get(selectionIndex));
                        } else if (Integer.parseInt(message) < 18) {
                            JOptionPane.showMessageDialog(null,
                                    "You should be 18 or older to buy a alhocolic bevarages!");
                        }

                    } else {
                        newOrder.addProduct(drinks1.get(selectionIndex));
                        break;
                    }
            }
            view.populateRightPanel(newOrder.getInfoAboutOrder()); // update left panel with new item - this takes a
                                                                   // shortcut in updating the entire information in the
                                                                   // panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + newOrder.getPrice()); // set the text to show cost
                                                                                            // of current order
        }

    }

    public void viewSelectedOrder() {
        int selectionIndex = view.getSelectionLeftPanel();
        view.setTextCostLabelRightPanel("Total cost of order: No order chosen");
        if ((selectionIndex != -1) && currentLeftMenu == ButtonType.OrderHistory) {
            Orders orders = allOrder.getorders()[selectionIndex];
            view.populateRightPanel(orders.getInfoAboutOrder());

            view.setTextCostLabelRightPanel("Total cost of order: " + orders.getPrice()); // set the text to show cost
                                                                                          // of current order
        }
    }

    public void setToFoodMenu() {
        currentLeftMenu = ButtonType.Food;
        view.populateLeftPanel(getPizzasStrings());
        view.populateRightPanel(newOrder.getInfoAboutOrder()); // update left panel with new item - this takes a
                                                               // shortcut in updating the entire information in the
                                                               // panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + newOrder.getPrice()); // set the text to show cost of
                                                                                        // current order
        view.enableAllButtons();
        view.disableFoodMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToDrinkMenu() {
        currentLeftMenu = ButtonType.Drinks;
        view.populateLeftPanel(getDrinksString());
        view.populateRightPanel(newOrder.getInfoAboutOrder()); // update left panel with new item - this takes a
                                                               // shortcut in updating the entire information in the
                                                               // panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + newOrder.toString()); // set the text to show cost of
                                                                                        // current order
        view.enableAllButtons();
        view.disableDrinksMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();
        System.out.println(Arrays.toString(allOrderstring()));
        view.populateLeftPanel(allOrderstring());
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    public void deleteOrders() {
        newOrder = new Orders(0);
        view.clearRightPanel();
        view.enableAllButtons();
    }

    public void placeOrder(int selectionLeftPanel) {
        if (newOrder.isOk()) {
            view.populateRightPanel(newOrder.getInfoAboutOrder());
            view.setTextCostLabelRightPanel("TOTAL COST: " + newOrder.getPrice());
            allOrder.addingOrder(newOrder);
            System.out.println("order toString: " + allOrder.getMyOrders());

            deleteOrders();
            view.enableAllButtons();
            view.disableAddMenuButton();
            view.disableViewSelectedOrderButton();
        } else {
            JOptionPane.showMessageDialog(null, "You have to buy minimum one pizza!");
        }
    }
}
