package commons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * class that handles parsing of
 * LocalTime type from json
 */
public class LocalTimeHandler extends StdDeserializer<LocalTime>{

    public LocalTimeHandler() { this(null); }
    public LocalTimeHandler(Class<?> clazz) { super(clazz); }


    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException{
        String localTime = jsonParser.getText();
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(localTime, formatter);
        } catch (Exception e){
            return null;
        }
    }
}
