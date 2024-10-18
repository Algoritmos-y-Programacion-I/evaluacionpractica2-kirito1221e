package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];
        pillars[0] = new Pillar("1. Biodiversidad");
        pillars[1] = new Pillar("2. Agua");
        pillars[2] = new Pillar("3. Tratamiento de Basura");
        pillars[3] = new Pillar("4. Energia");
        

    }

    public String showPillar() {

        String list = "";


        for (int j = 0; j < pillars.length; j++) {

            if (pillars[j] != null) {
                list += "\n" + pillars[j].getName();
            }
        }


        return list;
        
    }



    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {

        if (pillarType >= 0 && pillarType < pillars.length) {
            Project project = new Project(id, name, description, status); // Crear el objeto Project con el status
            return pillars[pillarType].addProject(project); // Añadir el proyecto al Pilar
        }

        return false;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    
    public String queryProjectsByPillar(int pillarType) {

        if (pillarType >= 0 && pillarType < pillars.length) {
            Pillar pillar = pillars[pillarType-1];
            return pillar.getProjectList();
        } else {
            return "El pilar que has consultado no existe.";
        }

    }
    
}