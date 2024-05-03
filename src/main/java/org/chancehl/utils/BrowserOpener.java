package org.chancehl.utils;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserOpener {
    public static void open(String address) throws URISyntaxException, IOException {
        // URL to open
        URI uri = new URI(address);

        // Check if Desktop is supported
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                // Open the URL in the default browser
                desktop.browse(uri);
            } else {
                throw new RuntimeException("Browse action is not supported");
            }
        } else {
            throw new RuntimeException("Desktop is not supported");
        }
    }
}

