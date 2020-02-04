package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService() {
    }

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Project project){
        this.entityManager.persist(project);
        this.entityManager.flush();
    }

    public void save(Enterprise enterprise){
        this.entityManager.persist(enterprise);
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
}
