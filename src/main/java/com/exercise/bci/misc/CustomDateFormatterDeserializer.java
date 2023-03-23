package com.exercise.bci.misc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateFormatterDeserializer extends StdDeserializer<Date> {

	private static final long serialVersionUID = 774368791497276173L;

	private final SimpleDateFormat dateFormatter =
            new SimpleDateFormat( "MMM d, yyyy hh:mm:ss a" );

    public CustomDateFormatterDeserializer() {
        this( null );
    }

    public CustomDateFormatterDeserializer( Class<Date> t ) {
        super( t );
    }

    @Override
    public Date deserialize( JsonParser jsonparser, DeserializationContext context )
            throws IOException {
        try {
            return dateFormatter.parse( jsonparser.getText() );
        } catch (ParseException e) {
            throw new RuntimeException( e );
        }
    }
}
