import java.sql.*;

public class ActorMgr {

    private static Connection connection=null;
    private static Statement statement =null;
    private static ResultSet resultSet = null;
    private static  PreparedStatement preparedStatement = null;

    public static void getAllRecords() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "navjithumber");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from actor");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" +
                        resultSet.getString(3) + "\t" + resultSet.getString(4));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public static Actor getRecord(int actor_id){
        Actor actor = new Actor();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "navjithumber");
            preparedStatement=connection.prepareStatement("Select * from actor where actor_id = ?");
            //resultSet = statement.executeQuery("Select * from actor where actor_id =" + actor_id);
            preparedStatement.setInt(1,actor_id);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            actor.setActor_id(resultSet.getInt(1));
            actor.setFirst_name(resultSet.getString(2));
            actor.setLast_name(resultSet.getString(3));
            actor.setLast_update(resultSet.getTimestamp(4));
            return actor;
        }catch(SQLException ex){
        }
        return null;
    }

    public static boolean insertRecord(Actor actor){
        int result=0;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "navjithumber");
            preparedStatement = connection.prepareStatement("insert into actor(first_name,last_name) values(?,?)");
            preparedStatement.setString(1,actor.getFirst_name());
            preparedStatement.setString(2,actor.getLast_name());
            result=preparedStatement.executeUpdate();
            if(result>0)
                return true;

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean updateRecord(Actor actor){
        int result=0;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "navjithumber");
            preparedStatement = connection.prepareStatement("update actor set first_name=?, last_name=? where actor_id=?");
            preparedStatement.setString(1,actor.getFirst_name());
            preparedStatement.setString(2,actor.getLast_name());
            preparedStatement.setInt(3,actor.getActor_id());
            result=preparedStatement.executeUpdate();
            if(result>0)
                return true;

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean deleteRecord(int actor_id){
        int result=0;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "navjithumber");
            preparedStatement = connection.prepareStatement("delete from actor where actor_id=?");
            preparedStatement.setInt(1,actor_id);
            result=preparedStatement.executeUpdate();
            if(result>0)
                return true;

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
