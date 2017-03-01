package app;

import app.classloaders.PluginsExecutor;

/**
 * Created by Ihar_Rubanovich on 2/22/2017.
 */
public class AppMain {
    public static void main(String[] args) {
        PluginsExecutor pe= new PluginsExecutor();
        pe.execute();
    }}
