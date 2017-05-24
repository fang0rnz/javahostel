package ninfa.javahostel.application;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ninfa.javahostel.domain.Bed;
import ninfa.javahostel.domain.Room;

@Stateless
@LocalBean
public class RoomRegistrationService {

	@PersistenceContext
    private EntityManager em;
	
    public void register(Room room) {
        em.persist(room);
    }
}
