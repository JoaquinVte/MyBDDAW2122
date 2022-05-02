package es.ieslavereda.bd.config;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Model {


    public List<Person> getAllPerson(){

        List<Person> people = new ArrayList<>();
        DataSource ds = MyDataSource.getMariaDBDataSource();
        String sql = "SELECT * FROM person";

        try(Connection con = ds.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs =statement.executeQuery(sql)){

            String dni,nombre,apellidos;
            int edad;

            while(rs.next()){

                dni = rs.getString("dni");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                edad = rs.getInt("edad");

                people.add(new Person(dni,nombre,apellidos,edad));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }
}
