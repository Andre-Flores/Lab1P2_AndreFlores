package lab1p2_andreflores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1P2_AndreFlores {

    public static void main(String[] args) {
        ArrayList<Usuario> Registro = new ArrayList();
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
                    Usuario nuevoUsuario = metodoAgregar();
                    if (nuevoUsuario != null) {
                        Registro.add(nuevoUsuario);
                        System.out.println("Usuario registrado con exito.");
                    } else {
                        System.out.println("Registro no exitoso, tiene que tener al menos 13 anios");
                    }

                }
                break;
                case 2: {
                    listarPersonas(Registro);
                }
                break;
                case 3: {

                }
                case 4: {
                    System.out.println("Muchas gracias.");
                }
                break;
            }

        } while (opc != 4);
    }

    private static boolean validarCorreo(String correoElec) {
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElec);
        return matcher.matches();
    }
    private static boolean validarContra(String contra) {
        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contra);
        return matcher.matches();
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
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(Integer.parseInt(a), Integer.parseInt(m) - 1, Integer.parseInt(d));
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.YEAR, -13);

        if (fechaNacimiento.after(hoy)) {
            System.out.println("Debe tener al menos 13 anioos para registrarte.");
            return null;
        }
        Date fn = new Date(Integer.parseInt(a) - 1900, Integer.parseInt(m) - 1, Integer.parseInt(d));
        System.out.println(fn);
        String correoElec;
        do {
            System.out.println("Ingrese su correo utilizando estos dominios: Gmail, Outlook, Yahoo, iCloud, ProtonMail y FastMail.");
            correoElec = entrada.nextLine();
            if (!validarCorreo(correoElec)) {
                System.out.println("Formato del correo incorrecto. intente otra vez .");
            }
        } while (!validarCorreo(correoElec));
        System.out.println("Ingrese su contrasenia:");
        String contra;
        do {
            System.out.println("Ingrese su contrasenia (1 simbolo, 1 mayuscula, 1 minuscula, 1 numero");
            contra = entrada.nextLine();
            if (!validarContra(contra)) {
                System.out.println("Formato de la contra incorrecta. tiene que tener mas de 8 caracteres, una mayuscula, una minuscula, un numero y un simbolo (!, ?, >, <, $ y %.");
            }
        } while (!validarContra(contra));
       contra = entrada.nextLine();
        return new Usuario(nombre, apellido, fn, correoElec, contra);

    }

    private static void listarPersonas(ArrayList<Usuario> Registro) {
        if (Registro.isEmpty()) {
            System.out.println(" no hay nada en registro.");
        } else {
            String listaPersonas = "Listado de mascotas:\n";
            for (Usuario persona : Registro) {
                listaPersonas += "Nombre: " + persona.getNombre()
                        + ", Apellido: " + persona.getApellido()
                        + ", Fecha de nacimiento: " + persona.getFechaNacimiento()
                        + ", Correo electronico: " + persona.getCorreoElec()
                        + ", Contrasenia: " + persona.getContra();
            }
            System.out.println(listaPersonas);
        }
    }

}
