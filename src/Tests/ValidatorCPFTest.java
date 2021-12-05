package Tests;

import org.junit.Test;
import Utils.Validators.*;

public class ValidatorCPFTest {
    @Test
    public void isValidCpf_should_return_false_if_invalid_cpf_is_provided() {
        assert !Validator.isCpfValid("12345678901");
        assert !Validator.isCpfValid("12345678123");
    }

    public void isValidCpf_should_return_true_if_a_valid_cpf_is_provided() {
        // CPF gerado.
        assert Validator.isCpfValid("63613186055");
    }
}
