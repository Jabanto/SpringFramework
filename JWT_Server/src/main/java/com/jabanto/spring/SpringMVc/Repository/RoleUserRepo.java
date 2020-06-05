package com.jabanto.spring.SpringMVc.Repository;

import com.jabanto.spring.SpringMVc.Model.Role;
import com.jabanto.spring.SpringMVc.Model.UserModel;
import com.jabanto.spring.SpringMVc.SpringJWTApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 * We define hier the basic CRUD methods to load information on the dataBase for the User and Rolle Table
 */
@Repository
public class RoleUserRepo {

    private static final Logger log = LoggerFactory.getLogger(SpringJWTApplication.class);

    @Autowired
    Environment env;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public RoleUserRepo() {
    }

    /**
     * This method insert a record a query using INSERT query with the help of Spring JDBC.
     * We'll insert some records in User and Role Table.
     */
    public void insertDataSet(){

        UserModel admin = new UserModel(2,"admin","pass","jabanto","jabanto","Jabanto@interNetX.de");
        UserModel client = new UserModel(3, "client","passC1", "kundeNameTest", "kundeVorNameTest" , "kundeTest@interNetX.de" );

        //Split up the array of whole names into a array fo first/last names
        /* List<Object[]> splitUpNames =
                Arrays.asList("Jothn Wtoo",
                              "Jetft Dena", "Josth BLoch", "Jtohs Long").stream()
                .map(name->name.split(" "))
                .collect(Collectors.toList());
        */

        List<UserModel> splitUpNames = new ArrayList<>();
        splitUpNames.add(admin);
        splitUpNames.add(client);
        //Using Java 8 Stream to print out each tuple fo the list
        splitUpNames.forEach(name->log.info(String.format("Inserting customer record for %s %s", name.getLogin(), name.getfName())));

        // Use Jdbc Template bach Update Operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO user(id,login,password,fname,lname,email) VALUES (?,?,?,?,?,?)", splitUpNames,2,
                (ParameterizedPreparedStatementSetter<UserModel>) (ps, argument) -> {
                    ps.setLong(1,argument.getId());
                    ps.setString(2, argument.getLogin());
                    ps.setString(3, argument.getPassword());
                    ps.setString(4,argument.getfName());
                    ps.setString(5,argument.getlName());
                    ps.setString(6,argument.geteMail());
                });

        insertRoleDataSet();

    }

    /**
     * This method insert a record a query using INSERT query with the help of Spring JDBC.
     * We'll insert some records in role Table.
     */
    private void insertRoleDataSet(){

        Role adminRole = new Role(1,2,1,1,0,0,0,0,0,0,0,0);
        Role clientRole = new Role(2,3,0,0,1,0,0,0,1,0,0,0);

        List<Role> roleBatches = new ArrayList<>();
        roleBatches.add(adminRole);
        roleBatches.add(clientRole);
        //Using Java 8 Stream to print out each tuple fo the list
        for (Role name : roleBatches) {
            log.info(String.format("Inserting roles record for %s %s", name.getId(), name.getIdUser()));
        }

        // Use Jdbc Template bach Update Operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO role(id,user_id,role_admin,role_develop,role_cctld,role_gtld,role_billing,role_registry,role_purchase_read,role_purchase_write,role_sale_write,role_sql) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", roleBatches,2,
                (ParameterizedPreparedStatementSetter<Role>) (ps, argument) -> {
                    ps.setLong(1,argument.getId());
                    ps.setInt(2, argument.getIdUser());
                    ps.setInt(3, argument.getRoleAdmin());
                    ps.setInt(4,argument.getRoleDevelop());
                    ps.setInt(5,argument.getRoleCtld());
                    ps.setInt(6,argument.getRoleGltd());
                    ps.setInt(7,argument.getRoleBilling());
                    ps.setInt(8,argument.getRoleRegistry());
                    ps.setInt(9,argument.getRolePurchaseRead());
                    ps.setInt(10,argument.getRolePurchaseWrite());
                    ps.setInt(11,argument.getRoleSaleWrite());
                    ps.setInt(12,argument.getRoleSql());
                });

        insertRoleDataSet();

    }

    /**
     * This method insert a record a query using INSERT query with the help of Spring JDBC.
     * We'll insert one new record in user Table.
     *
     * @param loginname login name
     * @param password  no encrypted password TODO encrypt the password
     * @param fname family of the user
     * @param lname last name of the
     * @param email email of the user
     */
    public void createUser(String loginname ,String password, String fname, String lname, String email ) {

        String SQL_INSERT = env.getProperty("sql.insert.user");
        jdbcTemplate.update(SQL_INSERT,loginname,password,fname,lname,email);

    }

    /**
     * The following method read a query using SELECT query with the help of Spring JDBC.
     * We'll read one of the records in role Table a return RoleModel.
     * @param username
     * @return
     */
    public UserModel findUserByName(String username){

        UserModel retVal = new UserModel();

        List<UserModel> resultQuery = new ArrayList<>();
        String SQL_Select = env.getProperty("sql.select.all.users");

        try {

            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_Select);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){

                long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                UserModel obj = new UserModel(id,login,password,"","","");
                resultQuery.add(obj);
            }

        }catch (SQLException e){
            log.error("SQL state %s\n%s", e.getSQLState(), e.getMessage());

        }

        catch (Exception e){
            e.printStackTrace();
        }


        for (UserModel user:resultQuery) {

            log.info("Searching with user:  " + user.toString());
            if (user.getLogin().equals(username)){
                retVal = user;
            }

        }

        return retVal;
    }

    /**
     * The following method read a query using SELECT query with the help of Spring JDBC.
     * We'll read one of the records in role Table a return RoleModel.
     * @param idUser of the user with the role
     * @return a mapped Role
     */
    public Role findRoleByUserId(long idUser){

        Role roleRetVal = new Role();

        String SQL_Select = env.getProperty("sql.select.role.byUser")+idUser;

        try {

            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_Select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                roleRetVal.setId(resultSet.getLong("id"));
                roleRetVal.setIdUser(resultSet.getInt("user_id"));
                roleRetVal.setRoleAdmin(resultSet.getInt("role_admin"));
                roleRetVal.setRoleDevelop(resultSet.getInt("role_develop"));
                roleRetVal.setRoleCtld(resultSet.getInt("role_cctld"));

            }

        }
        catch (SQLException e){
            log.error("SQL state %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }

        return roleRetVal;
    }

    /**
     * The following method will read a query using Spring JDBC and return a UserModel .
     * We'll read one of the records in user Table by id.
     * @param id for the user to find
     * @return a mapped UserModel
     */
    public UserModel findUserById(long id){

        UserModel userRetVal = new UserModel();
        String SQL_Select = env.getProperty("sql.select.user.byId")+id;

        try {

            PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_Select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                userRetVal.setId(resultSet.getLong("id"));
                userRetVal.setLogin(resultSet.getString("login"));
                userRetVal.setPassword(resultSet.getString("password"));
                userRetVal.setfName(resultSet.getString("fname"));
                userRetVal.setlName(resultSet.getString("lname"));
                userRetVal.seteMail(resultSet.getString("email"));

            }


        }catch (SQLException e){

            log.error("SQL State s%\n%s",e.getSQLState(), e.getMessage());

        }catch (Exception e){
            e.printStackTrace();
        }

        return  userRetVal;
    }

    /**
     * The following method will demonstrate how to update a query using Insert query with the help of Spring JDBC.
     * We'll update one of the records in User Table.
     * @param id of the user to update
     * @param loginName new name to update
     */
    public void updateUser(long id ,String loginName ){

        String SQL_Update = env.getProperty("sql.update.user");
        jdbcTemplate.update(SQL_Update,loginName,id);

    }


    /**
     * following method delete a query using DELETE query with the help of Spring JDBC.
     * We'll delete one of the a records User Table.
     * @param id from User id match with the id on user.id field  from user Table
     */
    public  void deleteUserById(long id){

        //TODO print SQLexceptions on log
        String SQL_delete = env.getProperty("sql.delete.user");
        jdbcTemplate.update(SQL_delete,id);

    }


}
