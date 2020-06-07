package Vorlage;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import javax.activation.DataSource;
import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JAbanto on 10.05.2017.
 */
public class ConnectionClass {

    /**
     * Spring busca eliminar codigo reutilizable  emcapsulandolo en plantillas JbdcTemplate
     * permite realizar operaciones de bases de datos sin todos los requisitos asociados a JDbc
     * tradicional, Por ejemplo si utilizamos SimpleJdbcTemplate un especificacion de JdbcTemplate que aporvecha caracteristicas de Java 5 el metodo getEMployedById puede REsescribir para que se cenre en la tarea de recuperar informacion del empleado en lugar de tendner que cumplir los requisitos del AI JDBC , el lsitodo muesto ael aspoecto de un metodo detEmployed ById  actualizado
     *
     * asi como podremos ver la version de nuestro metodo sera mucho ma sencilla y precisas al centrase en selecionar un empleado de la base de datos , Al metodo queryForObject() se le proporciona la consulta SQL , un RowMapper pra asignar el conjunto de datos resultantes an un objeto de dominio y ninguno  o mas pra meros de consulta . loq ue no vera en getemployedById() es codigo reutilizable JDBC cmo en el ejemplo anteriro to se lleva a cabo de forma interna en la plantilla
     *
     *
     */

    /**

    public Employee getEmployedById(long id){

        return jdbcTemplate.queryForObject(

                "select id, firtsname, lastname, salary " + // Consulta SQL
                "from employee where id=?",
                new RowMapper<Employee>(){

                    // Asignar resultados al objeto
                    public Employee mapRow(ResultSet resultSet, int rowNumer) throws SQLException {
                        Employee employee = new Employee();
                        employee.setId(resultSet.getInt("id"));
                        employee.setNameStrg(resultSet.getString("firtsname"));
                        employee.setLastNameStrg(resultSet.getString("lastname"));
                        employee.setSalary(resultSet.getLong("salary"));
                        return employee;
                    }
                }
                id); // especificar parametro de la consulta

    }

    */


}
