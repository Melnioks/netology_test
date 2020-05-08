package netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CashbackHackServiceTest {

    CashbackHackService cashbackHackService = new CashbackHackService();

    @ParameterizedTest
    @CsvFileSource(resources = "/cashbackTestDataPositive.csv", numLinesToSkip = 1)
    @DisplayName("Amount in the cart is more than 0")
    void shouldReturnAmountToNext1000(int amount, int expected, String failureMessage) {
        int actual = cashbackHackService.remain(amount);
        assertEquals(expected, actual, failureMessage);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/cashbackTestDataException.csv", numLinesToSkip = 1)
    @DisplayName("Amount in the cart is 0 or less")
    void shouldReturnExceptionForIllegalAmount(int amount, String message) {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                    cashbackHackService.remain(amount));
            assertEquals(message, exception.getMessage());
    }
}
