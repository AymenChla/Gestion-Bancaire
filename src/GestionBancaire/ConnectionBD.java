package GestionBancaire;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBD {
    
    private  Connection connection;
    private  Statement statement;
    private  ResultSet resultat;
    private  String url;
    private  PreparedStatement preparedStatement;
    
    public ConnectionBD()
    {
            try {
                    
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    url="jdbc:mysql://127.0.0.1:3306/gestionbancaire";
                    connection=DriverManager.getConnection(url, "root", "");
                    statement=connection.createStatement();
                    
            }catch(ClassNotFoundException | SQLException e){

                   e.printStackTrace();
            }

    }
    
    public  void disconnect()
    {
        try{
             connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    
    public  ResultSet Select (String sql)
    {
            try{
                   resultat=statement.executeQuery(sql);
                   
            }catch(SQLException e){
                
                   e.printStackTrace();
            }
            return resultat;
    }
    
    
    public  PreparedStatement initRequetePreparee(String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        preparedStatement = connection.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
    
  
    public  int maj(String sql)
    {
        int nb=0;
        try{
            nb=statement.executeUpdate(sql);
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return nb;
    }
    
    public boolean next()
    {
            try{ 
                return resultat.next();
            } catch(SQLException e)
            {
                e.printStackTrace();
                return false;
            }
    }
}



