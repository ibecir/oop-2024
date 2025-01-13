package ba.edu.ibu.week15.labs.invoice_management;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldFormat {
    TextFormat text_format() default TextFormat.PLAIN;
    CurrencyFormat currency_format() default CurrencyFormat.USD;
}
