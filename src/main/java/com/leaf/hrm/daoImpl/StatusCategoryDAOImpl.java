package com.leaf.hrm.daoImpl;

import com.leaf.hrm.dao.StatusCategoryDAO;
import com.leaf.hrm.entity.StatusCategory;
import com.leaf.hrm.entity.StatusCategory_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Repository
public class StatusCategoryDAOImpl implements StatusCategoryDAO {

    @Autowired
    private EntityManager entityManager;


    /**
     * {@inheritDoc}
     */
    @Override
    public StatusCategory findStatusCategory(Integer id) {

        return entityManager.find(StatusCategory.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusCategory findStatusCategoryByCode(String code) {
        StatusCategory statusCategory = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StatusCategory> criteriaQuery = criteriaBuilder.createQuery(StatusCategory.class);
        Root<StatusCategory> root = criteriaQuery.from(StatusCategory.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get(StatusCategory_.code), code)
        );

        try {
            statusCategory = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
        }

        return statusCategory;

    }
}
