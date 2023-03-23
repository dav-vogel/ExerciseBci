package com.exercise.bci.misc;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateFormatterSerializer extends StdSerializer<Date> {

	private static final long serialVersionUID = -5969723464933867779L;

	private final SimpleDateFormat dateFormatter =
            new SimpleDateFormat( "MMM d, yyyy hh:mm:ss a" );

    public CustomDateFormatterSerializer() {
        this( null );
    }

    public CustomDateFormatterSerializer( Class<Date> t ) {
        super( t );
    }

    @Override
    public void serialize( Date date, JsonGenerator gen, SerializerProvider arg2 )
            throws IOException {
        gen.writeString( dateFormatter.format( date ) );
    }
}
