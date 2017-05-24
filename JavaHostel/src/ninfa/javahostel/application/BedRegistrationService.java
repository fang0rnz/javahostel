package ninfa.javahostel.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ninfa.javahostel.domain.Bed;
import ninfa.javahostel.domain.Bed_;



@Stateless
@LocalBean
public class BedRegistrationService implements Serializable {

	@PersistenceContext
    private EntityManager em;
	
    public void register(Bed bed) {
        em.persist(bed);
    }
    
    public Bed findByNumber(Integer number) throws Exception{
    	Bed bed = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Bed> cq = cb.createQuery(Bed.class);
		Root<Bed> root = cq.from(Bed.class);
		cq.where(cb.equal(root.get(Bed_.number), number));
		TypedQuery<Bed> query = em.createQuery(cq);
    	
		try {
			bed = query.getSingleResult();
		}
		catch (Exception e){
			e.printStackTrace(); //implementar excessao de bed
			throw new Exception();
		}
    	
   	return bed;
   	
    }
    
    public List<Bed> findAll(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Bed> cq = cb.createQuery(Bed.class);
		Root <Bed> root = cq.from(Bed.class);
		cq.select(root);
		TypedQuery<Bed> allQuery = em.createQuery(cq);
		return allQuery.getResultList();
    }

}
