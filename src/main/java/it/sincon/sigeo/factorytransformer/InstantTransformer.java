package it.sincon.sigeo.factorytransformer;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import flexjson.TypeContext;
import flexjson.transformer.AbstractTransformer;

public class InstantTransformer extends AbstractTransformer {

	@Override
	public void transform(Object value) {
		TypeContext typeContext=getContext().peekTypeContext();
		if (value!=null)
		{
			if (!typeContext.isFirst()) getContext().writeComma();

			getContext().writeName(typeContext.getPropertyName());
		}
		typeContext.increment();
		if (value!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss'Z'" )
                    .withLocale( Locale.ITALY )
                    .withZone( ZoneId.systemDefault() );


			String stringValue = formatter.format( (Instant)value );
			getContext().writeQuoted(stringValue);
			
		}
	}
	
	@Override
	public Boolean isInline() {
		return true;
	}
}
