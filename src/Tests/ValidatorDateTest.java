package Tests;

import org.junit.Test;

import Utils.Validators.Validator;

public class ValidatorDateTest {
    @Test
    public void isDateValid_should_returns_false_if_invalid_date_is_provided() {
        assert (Validator.isDateValid("01-01-2020") == false);
        assert (Validator.isDateValid("01.01.2020") == false);
        assert (Validator.isDateValid("07-22-2020") == false);
    }

    @Test
    public void isDateValid_should_returns_true_if_valid_date_is_provided() {
        assert (Validator.isDateValid("01/01/2020") == true);
    }
}
