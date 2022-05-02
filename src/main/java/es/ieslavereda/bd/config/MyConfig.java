package es.ieslavereda.bd.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyConfig {

    private static MyConfig instance;
    private final String DEFAULT_PROPERTIES = "default.properties";
    private final String CUSTOM_PROPERTIES = "custom.properties";
    private Properties myProperties;

    private MyConfig(){

        Properties defaultProperties = new Properties();

        try(FileInputStream fis = new FileInputStream(DEFAULT_PROPERTIES)){

            defaultProperties.load(fis);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        myProperties = new Properties(defaultProperties);

        try(FileInputStream fis = new FileInputStream(CUSTOM_PROPERTIES)){

            myProperties.load(fis);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static MyConfig getInstance(){
        if(instance == null){
            instance = new MyConfig();
        }
        return instance;
    }

    public String getDBUrl(){
        return myProperties.getProperty("MYSQL_DB_URL");
    }
    public String getDBUsername(){
        return myProperties.getProperty("MYSQL_DB_USERNAME");
    }
    public String getDBPassword(){
        return myProperties.getProperty("MYSQL_DB_PASSWORD");
    }
}
