package commons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Duration;

/**
 * class that handles parsing of
 * Duration type from json
 */
public class DurationHandler extends StdDeserializer<Duration> {

    public DurationHandler() { this(null); }
    public DurationHandler(Class<?> clazz) { super(clazz); }

    @Override
    public Duration deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {
        String durationStr = jsonParser.getText();
        try{
            return Duration.parse(durationStr);
        } catch (Exception e){
            return null;
        }
    }
}
