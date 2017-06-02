
package sqlitecod;

import javax.swing.JOptionPane;

/**
 *
 * @author Brais Núñez
 */
public class SQLiteCOD {
    
    /**
     * Menú con las diferentes opciones de la base de datos.
     * @param args 
     */
    public static void main(String[] args) {
        
        int fila;

        Metodos met1 = new Metodos("C:\\Users\\Brais Núñez\\Desktop\\Desarrollo de aplicaciones multiplataforma\\Contornos de desarrollo\\SQLiteCOD\\baseEjemplo.db");

        if (met1.conectar()) {
            
            System.out.println("Conexión correcta");

        } else {

            System.out.println("Conexión errónea");

            System.exit(0);

        }

        int opcion = 0;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:\n1) Añadir profesor.\n2) Modificar profesor.\n3) Borrar profesor.\n0) Salir."));

            switch (opcion) {

                case 1:

                    fila = met1.insertar(new Profesor(JOptionPane.showInputDialog("Identificador del profesor:"), JOptionPane.showInputDialog("Nombre del profesor:"), JOptionPane.showInputDialog("Curso que imparte:")));

                    System.out.println("Han sido añadidos " + fila + " profesores");

                    break;

                case 2:

                    fila = met1.update(new Profesor(JOptionPane.showInputDialog("Identificador del profesor:"), JOptionPane.showInputDialog("Nombre del profesor:"), JOptionPane.showInputDialog("Curso que imparte:")));

                    System.out.println("Han sido actualizados " + fila + " profesores");

                    break;



                case 3:

                    fila = met1.borrar(JOptionPane.showInputDialog("Identificador del profesor:"));

                    System.out.println("Han sido borrados " + fila + " profesores");

                    break;

                case 0:
                    
                    met1.cerrarConexion();
                    JOptionPane.showMessageDialog(null, "Ha decidido salir.");

                    break;
            }

        } while (opcion != 0);
    }       
    }   

