package ejercicio_01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    
    // Happy Path: Add valid product
    // Unhappy Path: Add invalid price (<= 0)
    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        
        // Happy Path
        cart.addProduct(19.99);
        assertEquals(1, cart.getProductCount());
        
        // Unhappy Path
        assertThrows(IllegalArgumentException.class, () -> cart.addProduct(0.0));
    }

    // Happy Path: Remove existing product
    // Unhappy Path: Remove non-existent product
    @Test
    public void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(15.50);
        
        // Happy Path
        cart.removeProduct(15.50);
        assertEquals(0, cart.getProductCount());
        
        // Unhappy Path (should silently fail)
        cart.removeProduct(99.99); // No exception expected
        assertEquals(0, cart.getProductCount()); // State unchanged
    }

    // Happy Path: Get total with items
    // Unhappy Path: Get total when empty
    @Test
    public void testGetTotal() {
        ShoppingCart cart = new ShoppingCart();
        
        // Unhappy Path (edge case)
        assertEquals(0.0, cart.getTotal(), 0.001);
        
        // Happy Path
        cart.addProduct(12.50);
        cart.addProduct(7.30);
        assertEquals(19.80, cart.getTotal(), 0.001);
    }

    // Happy Path: Count with items
    // Unhappy Path: Count when empty
    @Test
    public void testGetProductCount() {
        ShoppingCart cart = new ShoppingCart();
        
        // Unhappy Path (edge case)
        assertEquals(0, cart.getProductCount());
        
        // Happy Path
        cart.addProduct(5.0);
        cart.addProduct(5.0);
        assertEquals(2, cart.getProductCount());
    }
}