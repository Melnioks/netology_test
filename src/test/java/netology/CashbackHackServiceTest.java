package netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Ammount in the cart is 0")
    void shouldReturn1000For0() {
        int actual = cashbackHackService.remain(0);
        assertEquals(actual, 1000);
    }

    @Test
    @DisplayName("Ammount in the cart is 1000")
    void shouldReturn0For1000() {
        int actual = cashbackHackService.remain(1000);
        assertEquals(actual, 0);
    }

}
