package Utils.Validators;

import java.util.InputMismatchException;

public class ValidatorCPF {

    // O algoritmo de validação de CPF utilizado como base deste projeto está
    // disponível no site:
    // http://www.macoratti.net/alg_cpf.htm#:~:text=O%20algoritmo%20de%20valida%C3%A7%C3%A3o%20do,%3A%20111.444.777%2D05.
    // Código disponível em:
    // https://github.com/nicolasgandrade/cpf-validator-java/blob/master/src/entities/Validator.java
    // Sob a licença MIT:
    // https://github.com/nicolasgandrade/cpf-validator-java/blob/master/LICENSE

    public static boolean isCpf(String preCpf) {
        int soma = 0;

        // Retira os dígitos verificadores para trabalhar em cima dos 9 números mais
        // facilmente
        String cpf = preCpf.substring(0, 9);

        // Multiplicador padrão do algoritmo de verificação de CPF
        int j = 2;

        for (int i = cpf.length() - 1; i >= 0; i--) {

            // Extrai os dígitos do CPF separadamente
            char digito = cpf.charAt(i);

            try {
                // Multiplica cada dígito pelo multiplicador padrão 'j' e soma-os
                soma += Integer.parseInt(String.valueOf(digito)) * j;
            } catch (InputMismatchException e) {
                throw new InputMismatchException(e.getMessage());
            } finally {
                // Incrementa 1 ao multiplicador 'j' seguindo a regra do algoritmo padrão
                j++;
            }

        }

        // Lógica de definição do PRIMEIRO dígito verificador

        int verificadorUm = 0;

        // Define o primeiro dígito verificador seguindo as regras do algoritmo padrão
        if (soma % 11 < 2) {
            verificadorUm = 0;
        } else {
            verificadorUm = 11 - soma % 11;
        }

        // Segundo dígito verificador:

        // Cria o cpf já com o primeiro dígito verificador
        cpf = cpf + verificadorUm;

        // Reinicia o multiplicador j e a variável soma para serem reutilizados
        j = 2;
        soma = 0;

        // Repetição dos processos anteriores para varificar o segundo dígito
        // verificador
        for (int i = cpf.length() - 1; i >= 0; i--) {

            char digito = cpf.charAt(i);

            try {
                soma += Integer.parseInt(String.valueOf(digito)) * j;
            } catch (InputMismatchException e) {
                throw new InputMismatchException(e.getMessage());
            } finally {
                j++;
            }

        }

        int verificadorDois = 0;
        if (soma % 11 < 2) {
            verificadorDois = 0;
        } else {
            verificadorDois = 11 - soma % 11;
        }

        // Atualiza o CPF conforme os dígitos calculados
        cpf = cpf + verificadorDois;

        // Verifica se o CPF atualizado é igual ao CPF inserido pelo usuário
        if (cpf.equals(preCpf)) {
            return true;
        } else {
            return false;
        }

    }

    public static String cpfFinal(String cpf) {
        return cpf.substring(0, 3)
                + "."
                + cpf.substring(3, 6)
                + "."
                + cpf.substring(6, 9)
                + "-"
                + cpf.substring(9, 11);
    }

}