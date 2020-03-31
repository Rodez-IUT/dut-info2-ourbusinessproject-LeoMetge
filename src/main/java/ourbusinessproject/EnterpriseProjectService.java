package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService() {
    }

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Object object){
        this.entityManager.persist(object);
        this.entityManager.flush();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Project findProjectById(Long anId) {

        return this.entityManager.find(Project.class, anId);
    }

    public Enterprise findEnterpriseById(Long anId) {
        return this.entityManager.find(Enterprise.class, anId);
    }

    public List<Project> findAllProjects(){
        String query = "SELECT p FROM Project p Join Fetch p.enterprise e ORDER BY p.title";
        TypedQuery<Project> queryObj = entityManager.createQuery(query, Project.class);
        return queryObj.getResultList();
    }
}
