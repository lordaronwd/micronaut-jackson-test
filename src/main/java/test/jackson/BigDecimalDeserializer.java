package test.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import javax.inject.Singleton;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Singleton
public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return p.getDecimalValue().setScale(6, RoundingMode.UP);
    }
}
