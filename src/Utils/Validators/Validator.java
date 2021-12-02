package Utils.Validators;

import Utils.Validators.ValidatorCPF;

public class Validator {

    public static boolean isDateValid(String date) {
        // TODO: Implementar validação de datas.
        return false;
    }

    public static boolean isCpfValid(String cpf) {
        return ValidatorCPF.isCpf(cpf);
    }

    public static void main(String[] args) {
        System.out.println(isCpfValid("08739394506"));
    }
}
