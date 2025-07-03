import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String calculadora = "";
        String operador = "";
        double operando1 = 0;
        double operando2 = 0;
        double resultado = 0;
        String status = "success";
        String mensagem = "";

        try {
            System.out.println("Selecione a calculadora:");
            System.out.println("1 - Básica");
            System.out.println("2 - Científica");
            int escolhaCalc = Integer.parseInt(scanner.nextLine());

            if (escolhaCalc == 1) {
                calculadora = "basica";
                System.out.println("Operações disponíveis: +, -, *, /, %");
                System.out.print("Digite a operação desejada: ");
                operador = scanner.nextLine();

                System.out.print("Digite o operando 1: ");
                operando1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Digite o operando 2: ");
                operando2 = Double.parseDouble(scanner.nextLine());

                CalcBasica calcBasica = new CalcBasica(operando1, operador, operando2);
                resultado = calcBasica.calcular();
                System.out.println("Resultado: " + resultado);

            } else if (escolhaCalc == 2) {
                calculadora = "cientifica";
                System.out.println("Operações disponíveis: +, -, *, /, %, sqrt, inverso, seno, fatorial");
                System.out.print("Digite a operação desejada: ");
                operador = scanner.nextLine();

                if (operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/") || operador.equals("%")) {
                    System.out.print("Digite o operando 1: ");
                    operando1 = Double.parseDouble(scanner.nextLine());

                    System.out.print("Digite o operando 2: ");
                    operando2 = Double.parseDouble(scanner.nextLine());

                    CalcCientifica calcCientifica = new CalcCientifica(operando1, operador, operando2);
                    resultado = calcCientifica.calcular();
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.print("Digite o operando: ");
                    operando1 = Double.parseDouble(scanner.nextLine());
                    operando2 = 0; // 

                    CalcCientifica calcCientifica = new CalcCientifica(operador, operando1);
                    resultado = calcCientifica.calcular();
                    System.out.println("Resultado: " + resultado);
                }
            } else {
                throw new IllegalArgumentException("Opção de calculadora inválida.");
            }
        } catch (Exception e) {
            resultado = 0;
            status = "failure";
            mensagem = e.getMessage();
            System.out.println("Erro: " + mensagem);
        }

        // Persistência
        try {
            Database db = new Database();
            db.gravarDadosDB(calculadora, operando1, operador, operando2, resultado, status, mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
