package lab1p2_andreflores;

import java.util.Date;
import java.util.Scanner;

public class Lab1P2_AndreFlores {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opc;
        do {
            System.out.println("1. Registrar usuario\n"
                    + "2. Listar todo \n"
                    + "3. Listar dominio\n"
                    + "4. Salir.");
            opc = entrada.nextInt();
            switch (opc) {
                case 1: {
                    metodoAgregar();

                }
                break;
                case 2: {

                }
                break;
                case 3: {
                    System.out.println("Muchas gracias.");
                }
                case 4: {

                }
                break;
            }

        } while (opc != 4);
    }

    private static Usuario metodoAgregar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese su nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("ingrese su apellido");
        String apellido = entrada.nextLine();
        String a, m, d;
        System.out.println("ingrese su anio de nacimiento:");
        a = entrada.nextLine();
        System.out.println("ingrese su mes de nacimiento:");
        m = entrada.nextLine();
        System.out.println("ingrese su dia de nacimiento:");
        d = entrada.nextLine();
        Date fn = new Date(Integer.parseInt(a) - 1900, Integer.parseInt(m) - 1, Integer.parseInt(d));
        System.out.println(fn);
        System.out.println("ingrese su correo utilizando estos dominios: Gmail, Outlook, Yahoo, iCloud, ProtonMail y FastMail.");
        String correoElec = entrada.nextLine();
        System.out.println(" ingrese su contrasenia:");
        String contra = entrada.nextLine();
        return new Usuario(nombre, apellido, fn, correoElec, contra);
    }
}
