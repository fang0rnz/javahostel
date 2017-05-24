package ninfa.javahostel.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-05-02T17:21:27.603-0300")
@StaticMetamodel(Room.class)
public class Room_ {
	public static volatile SingularAttribute<Room, Long> id;
	public static volatile SingularAttribute<Room, String> number;
	public static volatile SetAttribute<Room, Bed> beds;
}
