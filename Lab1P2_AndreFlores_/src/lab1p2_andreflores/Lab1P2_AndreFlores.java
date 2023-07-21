package lab1p2_andreflores;

import java.util.Scanner;

public class Lab1P2_AndreFlores {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Bienvenido al menu, ingrese una opcion. 1) Problema de Newton Raphson, 2) Problema de serie de Taylor, 3) Terminar el programa");
            opc = entrada.nextInt();
            switch (opc) {
                case 1: {
                    System.out.println("Bienvenido al problema de Newton Raphson");

                }
                break;
                case 2: {
                    System.out.println("Bienvenido al problema de la serie de Taylor ");

                    System.out.println("Ingrese el valor de x: ");
                    double valorx = entrada.nextDouble();

                    System.out.println("Ingrese el valor de n (es el limite)");
                    int valorn = entrada.nextInt();

                    double radians = Math.toRadians(valorx);
                    double ressin = calcseno(radians, valorn);
                    System.out.println("el seno de " + valorx + "es: " + ressin);

                    double radianes = Math.toRadians(valorx);
                    double rescos = calccos(radianes, valorn);
                    System.out.println("el coseno de " + valorx + " es: " + rescos);

                    if (valorx < 1.57) {
                        double resultado = tan(valorx, valorn);
                        System.out.println("La tangente de " + valorx + " es: " + resultado);
                    } else {
                        System.out.println("El valor de x debe ser menor a 1.57 para la tangente.");
                    }
                }
                break;
                case 3: {
                    System.out.println("Muchas gracias.");
                }
                break;
            }
        } while (opc != 3);
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static double calcseno(double valorx, int valorn) {
        if (valorn == 0) {
            return valorx;
        }
        int denom = 2 * valorn + 1;
        double act = Math.pow(valorx, denom) / factorial(denom);
        double signo;
        if (valorn % 2 == 0) {
            signo = 1;
        } else {
            signo = -1;
        }
        return act * signo + calcseno(valorx, valorn - 1);
    }

    public static double calccos(double valorx, int valorn) {
        if (valorn == 0) {
            return 1;
        }
        int denominador = 2 * valorn;
        double act = Math.pow(-1, valorn) * Math.pow(valorx, denominador) / factorial(denominador);
        return act + calccos(valorx, valorn - 1);
    }

    public static double tan(double x, int n) {
        if (n == 0) {
            return x;
        }

        int denominador = 2 * n - 1;
        double numerador = Math.pow(2, n) * Math.pow(-4, n) * (1 - Math.pow(4, n));
        double act = numerador / factorial(denominador) * Math.pow(x, denominador);

        return act + tan(x, n - 1);
    }
}
