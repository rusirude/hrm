package com.leaf.hrm.daoImpl;

import com.leaf.hrm.dao.SysRoleAuthorityDAO;
import com.leaf.hrm.entity.SysRole;
import com.leaf.hrm.entity.SysRoleAuthority;

import com.leaf.hrm.entity.SysRoleAuthority_;
import com.leaf.hrm.entity.SysRole_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Repository
public class SysRoleAuthorityDAOImpl implements SysRoleAuthorityDAO {

    private EntityManager entityManager;

    @Autowired
    public SysRoleAuthorityDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<SysRoleAuthority> getSysRoleAuthorityBySysRoles(List<SysRole> sysRoles) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SysRoleAuthority> criteriaQuery = criteriaBuilder.createQuery(SysRoleAuthority.class);
        Root<SysRoleAuthority> root = criteriaQuery.from(SysRoleAuthority.class);
        criteriaQuery.select(root).distinct(true);
        CriteriaBuilder.In<Long> sysRoleIn = criteriaBuilder.in(root.get(SysRoleAuthority_.sysRole).get(SysRole_.id));
        sysRoles.forEach(sysRole -> {
            sysRoleIn.value(sysRole.getId());
        });
        criteriaQuery.where(sysRoleIn);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
