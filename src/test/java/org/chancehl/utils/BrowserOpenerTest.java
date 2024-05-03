package org.chancehl.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ExtendWith(MockitoExtension.class)
public class BrowserOpenerTest {
    @Mock
    private Desktop mockDesktop;

    private static MockedStatic<Desktop> mockedDesktop;

    @BeforeEach
    void setUp() {
        mockedDesktop = mockStatic(Desktop.class);
        mockedDesktop.when(Desktop::getDesktop).thenReturn(mockDesktop);
        when(Desktop.isDesktopSupported()).thenReturn(true);
    }

    @AfterEach
    void tearDown() {
        mockedDesktop.close();
    }

    @Test
    public void testOpen_ValidURI() throws Exception {
        // Setup
        String url = "http://example.com";
        when(mockDesktop.isSupported(Desktop.Action.BROWSE)).thenReturn(true);

        // Execute
        BrowserOpener.open(url);

        // Verify
        verify(mockDesktop).browse(new URI(url));
    }

    @Test
    public void testOpen_DesktopNotSupported() {
        // Setup
        String url = "http://example.com";
        when(Desktop.isDesktopSupported()).thenReturn(false);

        // Execute & Verify
        Exception exception = assertThrows(RuntimeException.class, () -> BrowserOpener.open(url));
        assertEquals("Desktop is not supported", exception.getMessage());
    }

    @Test
    public void testOpen_BrowseNotSupported() {
        // Setup
        String url = "http://example.com";
        when(mockDesktop.isSupported(Desktop.Action.BROWSE)).thenReturn(false);

        // Execute & Verify
        Exception exception = assertThrows(RuntimeException.class, () -> BrowserOpener.open(url));
        assertEquals("Browse action is not supported", exception.getMessage());
    }

    @Test
    public void testOpen_URISyntaxException() {
        // Setup
        String url = "htt p://example.com"; // Intentionally malformed URL

        // Execute & Verify
        assertThrows(URISyntaxException.class, () -> BrowserOpener.open(url));
    }

    @Test
    public void testOpen_IOException() throws Exception {
        // Setup
        String url = "http://example.com";
        when(mockDesktop.isSupported(Desktop.Action.BROWSE)).thenReturn(true);
        doThrow(new IOException("Failed to open")).when(mockDesktop).browse(any(URI.class));

        // Execute & Verify
        assertThrows(IOException.class, () -> BrowserOpener.open(url));
    }
}
