package verificacpf;

import java.util.Scanner;

public class VerificaCPF {

    public static void main(String args[]) {
        Menu();
    }

    public static void Menu() {

        int opcao = 9;

        while (opcao != 0) {
            System.out.println("\n\tVerificação CPF");
            System.out.println("\n\t> 1 CPF válido ou inválido\n\t> 0 Para finalizar o programa");
            Scanner sc = new Scanner(System.in);
            opcao = sc.nextInt();

            if (opcao != 0) {
                Verifica();
            } else if (opcao == 0) {
                System.out.println("Programa encerrado!");
                System.exit(0);
            } else {
                System.out.println("\nOpção inválida, tente novamente.\n");
            }
        }

    }

    public static void Verifica() {
        int[] verificaCPF = new int[11];
        long cpf, num = 10000000000L, resto;
        int j, i;
        int digitoVerificador1 = 0, digitoVerificador2 = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu CPF: ");
        cpf = sc.nextLong();

        for (j = 0; j < 11; j++) {
            resto = (cpf % num);
            i = (int) (cpf / num);
            num = num / 10;
            cpf = resto;
            verificaCPF[j] = i;
            
            if (verificaCPF[0] == verificaCPF[1] && verificaCPF[0] == verificaCPF[2]) {
                System.out.println("\nCPF inválido. VERIFICAR!");
                Menu();
            }
        }
        
        i = 10;
        for (j = 0; j < 9; j++) {
            digitoVerificador1 = digitoVerificador1 + (verificaCPF[j] * i);
            i = i - 1;
        }

        i = 11;
        for (j = 0; j < 10; j++) {
            digitoVerificador2 = digitoVerificador2 + (verificaCPF[j] * i);
            i = i - 1;
        }

        digitoVerificador1 = digitoVerificador1 * 10 % 11;
        digitoVerificador2 = digitoVerificador2 * 10 % 11;

        if (digitoVerificador1 == 10) {
            digitoVerificador1 = 0;
        }
        if (digitoVerificador2 == 10) {
            digitoVerificador2 = 0;
        }

        if ((digitoVerificador1 == verificaCPF[9]) && (digitoVerificador2 == verificaCPF[10])) {
            System.out.println("\nCPF Válido"); 
        } else {
            System.out.println("\nCPF inválido. VERIFICAR!");
        }

        System.out.println("\n0 Voltar");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();

        if (opcao == 0) {
            Menu();
        } else {
            System.out.println("Opção inválida!");
        }
    }

}