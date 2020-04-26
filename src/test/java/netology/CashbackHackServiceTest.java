package netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CashbackHackServiceTest {

    private CashbackHackService cashbackHackService;

    @BeforeEach
    void setUp() {
        cashbackHackService = new CashbackHackService();
    }

    @Test
    @DisplayName("Ammount in the cart is 999")
    void shouldReturn1For999() {
        int actual = cashbackHackService.remain(999);
        assertEquals(actual, 1);
    }

    @Test
    @DisplayName("Ammount in the cart is 1001")
    void shouldReturn999For1001() {
        int actual = cashbackHackService.remain(1001);
        assertEquals(actual, 999);
    }

    @Test
    @DisplayName("Ammount in the cart is 1000")
    void shouldReturn0For1000() {
        int actual = cashbackHackService.remain(1000);
        assertEquals(actual, 0);
    }

    @Test
    @DisplayName("Ammount in the cart is 0")
    void shouldReturnErrorMessageFor0() {
            Exception exception = assertThrows(IllegalArgumentException.class, () ->
                    cashbackHackService.remain(0));
            assertEquals("amount must be greater than zero", exception.getMessage());
    }

    @Test
    @DisplayName("Ammount in the cart is -1")
    void shouldReturnErrorMessageForLess0() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                cashbackHackService.remain(-1));
        assertEquals("amount must be greater than zero", exception.getMessage());
    }

}
