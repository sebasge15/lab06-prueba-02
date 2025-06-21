package ejercicio_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    //Happy Path: Añadir producto válido
    @Test
    public void testAddValidProduct() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(19.99);
        assertEquals(1, cart.getProductCount());
        assertEquals(19.99, cart.getTotal(), 0.001);
    }

    //Unhappy Path: Añadir producto con precio inválido (esperando excepción)
    @Test
    public void testAddInvalidProductThrowsException() {
        ShoppingCart cart = new ShoppingCart();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(0.0);
        });
        assertEquals("Price must be positive", exception.getMessage());
    }
}
