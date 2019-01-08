package test.jackson;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/test")
public class TestController {

    @Post
    public TestPojo get(@Body TestPojo test) {
        return test;
    }
}
