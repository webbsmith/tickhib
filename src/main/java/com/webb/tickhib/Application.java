package com.webb.tickhib;

import com.webb.tickhib.menu.Menu;
import com.webb.tickhib.menu.MenuCommandLine;

/**
 * Created by webbs_000 on 12/13/2014.
 */
public class Application {
    public static void main(String[] args) {
        Menu menu = new MenuCommandLine();
        menu.run();
    }
}
