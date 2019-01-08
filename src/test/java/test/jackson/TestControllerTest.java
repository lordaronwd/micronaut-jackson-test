package test.jackson;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TestControllerTest {
    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server
                .getApplicationContext()
                .createBean(HttpClient.class, server.getURL());
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void test() {
        BigDecimal bigDecimal = BigDecimal.valueOf(48.669969);

        HttpRequest<TestPojo> request = HttpRequest.POST("/test", new TestPojo(bigDecimal))
                .contentType(MediaType.APPLICATION_JSON_TYPE);

        TestPojo response = client.toBlocking().retrieve(request, TestPojo.class);

        assertNotNull(response);
        BigDecimal actual = response.getDecimal();

        System.out.println(bigDecimal);
        System.out.println(actual);
        assertEquals(0, bigDecimal.compareTo(actual));
    }
}
