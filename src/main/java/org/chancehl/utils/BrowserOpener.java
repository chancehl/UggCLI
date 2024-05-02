package org.chancehl.utils;

import java.awt.Desktop;
import java.net.URI;

public class BrowserOpener {
    public static void open(String address) {
        try {
            // URL to open
            URI uri = new URI(address);

            // Check if Desktop is supported
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Open the URL in the default browser
                    desktop.browse(uri);
                } else {
                    System.out.println("BROWSE action is not supported!");
                }
            } else {
                System.out.println("Desktop is not supported!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

