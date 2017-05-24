package ninfa.javahostel.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-05-02T17:21:27.602-0300")
@StaticMetamodel(Booking.class)
public class Booking_ {
	public static volatile SingularAttribute<Booking, Long> id;
	public static volatile SingularAttribute<Booking, Guest> guest;
	public static volatile SetAttribute<Booking, Bed> beds;
	public static volatile SingularAttribute<Booking, Date> endDate;
}
