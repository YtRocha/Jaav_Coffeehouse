package Utils.Validators;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import Utils.Validators.ValidatorCPF;

public class Validator {

    public static boolean isDateValid(String strDate) {
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);
        try{
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;
        } catch(DateTimeParseException erro){
            return false;
        }
    }

    public static boolean isCpfValid(String cpf) {
        return ValidatorCPF.isCpf(cpf);
    }

    public static void main(String[] args) {
        System.out.println(isCpfValid("08739394506"));
        System.out.println(isDateValid("30/04/2021"));
        System.out.println(isDateValid("31/04/2021"));
        System.out.println(isDateValid("300/04/2021"));
    }
}
