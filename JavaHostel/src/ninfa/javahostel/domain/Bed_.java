package ninfa.javahostel.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-05-04T13:14:50.110-0300")
@StaticMetamodel(Bed.class)
public class Bed_ {
	public static volatile SingularAttribute<Bed, Long> id;
	public static volatile SingularAttribute<Bed, Room> room;
	public static volatile SingularAttribute<Bed, Integer> number;
	public static volatile SingularAttribute<Bed, Double> pricePerNight;
}
