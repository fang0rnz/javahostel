package ninfa.javahostel.application;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ninfa.javahostel.domain.Guest;
import ninfa.javahostel.domain.Guest_;

@Stateless
@LocalBean
public class AuthenticationService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Guest login(String email, String password) throws Exception{
		Guest guest = null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);
		Root<Guest> root = cq.from(Guest.class);
		cq.where(cb.equal(root.get(Guest_.email), email));
		TypedQuery<Guest> query = entityManager.createQuery(cq);
		
		try {
			guest = query.getSingleResult();
		}
		catch (Exception e){
			e.printStackTrace(); //implementar excessao de login incorreto
			throw new Exception();
			
		}
		
		if ((password == null) || (!password.equals(guest.getPassword())))
			throw new Exception();
		
		return guest;
	}
	
	
	
}
