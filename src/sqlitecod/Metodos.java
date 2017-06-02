
package sqlitecod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brais Núñez
 */
public class Metodos {
    
    private String url;
    private Connection conexion;
  
    /**
     * Constructor para una base de datos dada por parámetro.
     *
     * @param url Ruta de la base de datos.
     */

    public Metodos(String url) {

        this.url = url;

    }

    /**
     * Establece la conexión con la base de datos.
     *
     * @return devuelve true si se conecta, false si falla la conexión.
     */

    public boolean conectar() {
            
            try {
                Class.forName("org.sqlite.JDBC");
                conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println("Conexión errónea, error ----->"+ ex.getMessage());
            
            return false;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Conectado");
            return true;
    }

    /**
     * Inserta un profesor en la base de datos.
     * @param prof recibe el profesor que se desea añadir.
     * @return Devuelve 1 si se ha introducido, 0 sino.
     */

    public int insertar(Profesor prof) {

        try {

            PreparedStatement st = conexion.prepareStatement("insert into Profesores (Id_profe,Nom_profe,Curso_profe) values(?,?,?)");

            st.setString(1, prof.getId());

            st.setString(2, prof.getNombre());

            st.setString(3, prof.getCurso());

            st.execute();

        } catch (SQLException ex) {

            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            
            return 0;

        }

            return 1;
    }

    /**
     * Borra a un profesor de la base da datos.
     * @param identificador recibe el id del profesor.
     * @return Devuelve 1 si se ha borrado, 0 sino.
     */

    public int borrar(String identificador) {

        try {

            PreparedStatement st = conexion.prepareStatement("delete from Profesores where Id_prof=?");

            st.setString(1, identificador);

            st.execute();
          
        } catch (SQLException ex) {

            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

            return 0;

        }

            return 1;
    }
 

    /**
     * Actualiza los datos de un profesor.
     * @param prof 
     * @return Devuelve 1 si se ha actualizado, 0 sino.
     */

    public int update(Profesor prof) {

        try {

            PreparedStatement st = conexion.prepareStatement("update  Profesores set Nom_profe=?,Curso_profe=? where Id_profe=?");

            st.setString(1, prof.getId());

            st.setString(2, prof.getNombre());

            st.setString(3, prof.getCurso());

            st.execute();

        } catch (SQLException ex) {

            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

            return 0;

        }

            return 1;
    }

    
    /**
     * Cierra la conexión con la base de datos
     * @return Devuelve true si se cerró, false si hubo algún error.
     */

    public boolean cerrarConexion() {

        try {

            conexion.close();

        } catch (SQLException ex) {

            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        }

            return true;
    }  
}
