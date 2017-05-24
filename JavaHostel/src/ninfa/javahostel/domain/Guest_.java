package ninfa.javahostel.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Guest.class)
public class Guest_ {
	public static volatile SingularAttribute<Guest, Long> id;
	public static volatile SingularAttribute<Guest, String> name;
	public static volatile SingularAttribute<Guest, String> email;
	public static volatile SingularAttribute<Guest, String> password;
}
