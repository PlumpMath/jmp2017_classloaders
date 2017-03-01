package app.classloaders;

import app.IPlugin;
import app.constants.ConfigConstants;
import app.utils.ProppertiesInit;

import java.io.IOException;
import java.util.ResourceBundle;

import static app.constants.ConfigConstants.*;
import static app.utils.ProppertiesInit.getPropsMap;

/**
 * Created by Ihar_Rubanovich on 2/24/2017.
 */
public class PluginsExecutor {
    private PluginLoader pl;
    private ProppertiesInit pi;

    private void pluginInit() {
        propsInit();

    }

    private void propsInit() {
        ResourceBundle rb = ResourceBundle.getBundle(ConfigConstants.PROPS_CONFIG);
        pi = new ProppertiesInit();
        pi.intialize(rb);
    }

    public void execute() {
        pluginInit();
        showPlugin(PLUGIN__CURRENTIME_DIR_PATH, PLUGIN_CURRENTIME_PACKAGE, PLUGIN_CURRENT_TIME);
        showPlugin(PLUGIN__GREETINGS_DIR_PATH, PLUGIN_GREETINGS_PACKAGE, PLUGIN_GREETING);
    }

    private void showPlugin(String pluginPath, String pluginCurrentPack, String pluginClass) {
        try {
            pl = new PluginLoader();
            pl.loadPlugin(getPropValue(pluginPath), getPropValue(pluginCurrentPack), getPropValue(pluginClass));
            String pack= getPropValue(pluginCurrentPack);
            String plugClass = getPropValue(pluginClass);
            String classtoLoad = pack + "." + plugClass.substring(0, plugClass.indexOf("."));
            IPlugin plug = (IPlugin) pl.loadClass(classtoLoad).newInstance();
            plug.doAction();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String getPropValue(String key) {
        return getPropsMap().get(key);
    }
}
