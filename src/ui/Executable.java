package ui;
import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
     */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /**
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un
     * Project
     * en un Pillar en el sistema
     */
    public void registerProject() {

        reader.nextLine();

        System.out.println(control.showPillar());

        int pillarType = 0 ;
        boolean pillarValid = false;

        while (!pillarValid) {
            System.out.println("Dime a cual pilar vas a registrar este proyecto");
            pillarType = reader.nextInt() - 1;

            if (pillarType >= 0 && pillarType < 4) {
                pillarValid = true;
            } else {
                System.out.println("Ese pilar no existe en Icesi ¡Lo sentimos!");
            }
        }

        System.out.println("Dime el estado del proyecto (true o false)");
        boolean status = reader.nextBoolean();

        reader.nextLine();

        System.out.println("Dime el nombre del proyecto");
        String name = reader.nextLine();

        System.out.println("Dime el Id del proyecto");
        String id = reader.nextLine();

        System.out.println("Dime la descripcion del proyecto");
        String description = reader.nextLine();

        boolean result = control.registerProjectInPillar(pillarType, id, name, description, status);

        if (result == true) {

            System.out.println("El Projecto ha sido registrado exitosamente");
        } else {
            System.out.println("El proyecto no se ha podido registrar");
        }
    }

    /**
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar
     */
    public void showProjectsByPillar() {

        System.out.println(control.showPillar());
        
        System.out.println("Dime cual pilar deseas ver");
        int pillarType = reader.nextInt();

        String result = control.queryProjectsByPillar(pillarType);

        if(result != null){

            System.out.println("Estos son los proyectos que tiene el pilar: "+"\n"+ result);
        }


    }

}