package com.example.mockitofirst.MyManager.Animals;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.util.DisplayMetrics;

import com.example.mockitofirst.MyManager.URLManager;
import com.example.mockitofirst.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.utils.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Uri.class, Rect.class})
public class URLManagerTest {

    URLManager urlManager = new URLManager();

    @Test
    public void testGetHost() throws Exception {
        PowerMockito.mockStatic(Uri.class);
        Uri uri = mock(Uri.class);
        when(uri.getHost()).thenReturn("google.com");
        // dung tuong tu cho web data ne
        when(Uri.class, "parse", anyString()).thenReturn(uri);
        String url = "https://google.com/";
        String output = urlManager.getHost(url);
        assertEquals(output, "google.com");
    }

    @Test
    public void testRect() throws Exception {
        PowerMockito.mockStatic(Rect.class);
        Context context = mock(Context.class);
        int pxWidth = 1080;
        int pxHeight = 3600;
        Rect rect = mock(Rect.class);
        when(rect.width()).thenReturn(pxWidth);
        when(rect.height()).thenReturn(pxHeight);
        whenNew(Rect.class).withArguments(anyInt(), anyInt(), anyInt(), anyInt()).thenReturn(rect);
        Rect newRect = new Rect(0, 0, 1, 1);
        Rect out = urlManager.getRect(context);
        float h = urlManager.getH(context);
        assertEquals(h, newRect.height(), 1);
        assertEquals(h, rect.height(), 1);
        assertEquals(out, rect);
    }




//    final Uri mockUri = mock(Uri.class);
//
//
//
//
//    abstract public class AbstractPublicStreamHandler extends URLStreamHandler {
//        @Override
//        public URLConnection openConnection(URL url) throws IOException {
//            return null;
//        }
//    }
//
//    public class UrlTest {
//        private URLStreamHandlerFactory urlStreamHandlerFactory;
//
//        @Before
//        public void setUp() throws Exception {
//            urlStreamHandlerFactory = Mockito.mock(URLStreamHandlerFactory.class);
//            URL.setURLStreamHandlerFactory(urlStreamHandlerFactory);
//        }
//
//        @Test
//        public void should_return_mocked_url() throws Exception {
//            // GIVEN
//            AbstractPublicStreamHandler publicStreamHandler = Mockito.mock(AbstractPublicStreamHandler.class);
//            Mockito.doReturn(publicStreamHandler).when(urlStreamHandlerFactory).createURLStreamHandler(Matchers.eq("http"));
//
//            URLConnection mockedConnection = Mockito.mock(URLConnection.class);
//            Mockito.doReturn(mockedConnection).when(publicStreamHandler).openConnection(Matchers.any(URL.class));
//
//            Mockito.doReturn(new ByteArrayInputStream("hello".getBytes("UTF-8"))).when(mockedConnection).getInputStream();
//
//            // WHEN
//            URLConnection connection = new URL("http://localhost/").openConnection();
//
//            // THEN
//            assertTrue(new MockUtil().isMock(connection));
//            assertEquals("hello", IOUtils.toString(connection.getInputStream(), "UTF-8"));
//        }
//    }
//
//
//    final URLConnection mockUrlCon = mock(URLConnection.class);
//
//    ByteArrayInputStream is = new ByteArrayInputStream(
//            "<myList></myList>".getBytes("UTF-8"));
//    doReturn(is).when(mockUrlCon).getInputStream();
//
//    //make getLastModified() return first 10, then 11
//    when(mockUrlCon.getLastModified()).thenReturn((Long)10L, (Long)11L);
//
//    URLStreamHandler stubUrlHandler = new URLStreamHandler() {
//        @Override
//        protected URLConnection openConnection(URL u) throws IOException {
//            return mockUrlCon;
//        }
//    };
//    URL url = new URL("foo", "bar", 99, "/foobar", stubUrlHandler);
//    doReturn(url).when(mockClassloader).getResource("pseudo-xml-path");
}
