package ba.edu.ibu.week15.labs.library.annotations;


import ba.edu.ibu.week15.labs.library.enums.AvailabilityStatus;
import ba.edu.ibu.week15.labs.library.enums.BookCategory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldValidation {
    BookCategory category() default BookCategory.FICTION;
    AvailabilityStatus status() default AvailabilityStatus.AVAILABLE;
}
