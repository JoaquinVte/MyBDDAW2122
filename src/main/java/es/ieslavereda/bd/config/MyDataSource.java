package es.ieslavereda.bd.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class MyDataSource {
    public static DataSource getMariaDBDataSource(){

        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(MyConfig.getInstance().getDBUrl());
        ds.setUser(MyConfig.getInstance().getDBUsername());
        ds.setPassword(MyConfig.getInstance().getDBPassword());

        return ds;
    }
}
