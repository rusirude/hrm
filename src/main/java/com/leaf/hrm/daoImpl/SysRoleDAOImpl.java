package com.leaf.hrm.daoImpl;

import com.leaf.hrm.dao.SysRoleDAO;
import com.leaf.hrm.dto.DataTableRequestDTO;
import com.leaf.hrm.entity.Status_;
import com.leaf.hrm.entity.SysRole;
import com.leaf.hrm.entity.SysRole_;
import com.leaf.hrm.enums.DeleteStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Repository
public class SysRoleDAOImpl implements SysRoleDAO {

    @Autowired
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRole loadSysRole(long id) {
        return entityManager.getReference(SysRole.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRole findSysRole(long id) {
        return entityManager.find(SysRole.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRole findSysRoleByCode(String code) {
        SysRole sysRole = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SysRole> criteriaQuery = criteriaBuilder.createQuery(SysRole.class);
        Root<SysRole> root = criteriaQuery.from(SysRole.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get(SysRole_.code), code),
                        criteriaBuilder.notEqual(root.get(SysRole_.status).get(Status_.code), DeleteStatusEnum.DELETE.getCode())
                )
        );

        try {
            sysRole = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
        }

        return sysRole;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveSysRole(SysRole sysRole) {
        entityManager.persist(sysRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateSysRole(SysRole sysRole) {
        entityManager.merge(sysRole);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SysRole> searchSysRoleWithDataTableCriteria(DataTableRequestDTO dataTableRequestDTO){
        List<SysRole> result = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SysRole> criteriaQuery = criteriaBuilder.createQuery(SysRole.class);
        Root<SysRole> root = criteriaQuery.from(SysRole.class);
        criteriaQuery.where(
                criteriaBuilder.notEqual(root.get(SysRole_.status).get(Status_.code),DeleteStatusEnum.DELETE.getCode())
        );
        try {
            result  = entityManager.createQuery(criteriaQuery).getResultList();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long searchSysRoleCountWithDataTableCriteria(DataTableRequestDTO dataTableRequestDTO){
        Long result = (long) 0;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<SysRole> root = criteriaQuery.from(SysRole.class);
        criteriaQuery.select(criteriaBuilder.count(root.get(SysRole_.id)));
        criteriaQuery.where(
                criteriaBuilder.notEqual(root.get(SysRole_.status).get(Status_.code), DeleteStatusEnum.DELETE.getCode())
        );
        try {
            result  = entityManager.createQuery(criteriaQuery).getSingleResult();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
