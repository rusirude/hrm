package com.leaf.hrm.serviceImpl;

import com.leaf.hrm.dao.StatusDAO;
import com.leaf.hrm.dao.SysRoleDAO;
import com.leaf.hrm.dto.CommonResponseDTO;
import com.leaf.hrm.dto.DataTableRequestDTO;
import com.leaf.hrm.dto.DataTableResponseDTO;
import com.leaf.hrm.dto.SysRoleDTO;
import com.leaf.hrm.entity.SysRole;
import com.leaf.hrm.enums.DeleteStatusEnum;
import com.leaf.hrm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{


    @Autowired
    SysRoleDAO sysRoleDAO;

    @Autowired
    StatusDAO statusDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO saveSysRole(SysRoleDTO sysRoleDTO,String loggedUser) {
        try {
            SysRole sysRole = new SysRole();
            sysRole.setCode(sysRoleDTO.getCode());
            sysRole.setDescription(sysRoleDTO.getDescription());
            sysRole.setStatus(statusDAO.findStatusByCode(sysRoleDTO.getStatus()));
            sysRole.setCreatedBy(loggedUser);
            sysRole.setCreatedOn(new Date());
            sysRoleDAO.saveSysRole(sysRole);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS","Saved "+sysRoleDTO.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO updateSysRole(SysRoleDTO sysRoleDTO,String loggedUser) {
        try {
            SysRole sysRole  = sysRoleDAO.findSysRoleByCode(sysRoleDTO.getCode());
            sysRole.setDescription(sysRoleDTO.getDescription());
            sysRole.setStatus(statusDAO.findStatusByCode(sysRoleDTO.getStatus()));
            sysRole.setUpdatedBy(loggedUser);
            sysRole.setUpdatedOn(new Date());
            sysRoleDAO.updateSysRole(sysRole);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS","Updated "+sysRoleDTO.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO deleteSysRole(SysRoleDTO sysRoleDTO,String loggedUser) {
        try {
            SysRole sysRole  = sysRoleDAO.findSysRoleByCode(sysRoleDTO.getCode());
            sysRole.setStatus(statusDAO.findStatusByCode(DeleteStatusEnum.DELETE.getCode()));
            sysRole.setUpdatedBy(loggedUser);
            sysRole.setUpdatedOn(new Date());
            sysRoleDAO.updateSysRole(sysRole);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS","Deleted "+sysRoleDTO.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO searchSysRole(SysRoleDTO sysRoleDTO) {
        SysRoleDTO roleDTO = null;
        try {
            SysRole sysRole  = sysRoleDAO.findSysRoleByCode(sysRoleDTO.getCode());
            roleDTO = new SysRoleDTO();
            roleDTO.setCode(sysRole.getCode());
            roleDTO.setDescription(sysRole.getDescription());
            roleDTO.setStatus(sysRole.getStatus().getCode());
            roleDTO.setCreatedBy(sysRole.getCreatedBy());
            roleDTO.setUpdatedBy(sysRole.getUpdatedBy());
            roleDTO.setCreatedOn(sysRole.getCreatedOn());
            roleDTO.setUpdatedOn(sysRole.getUpdatedOn());
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS",roleDTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DataTableResponseDTO searchSysRolesForDataTable(DataTableRequestDTO dataTableRequestDTO){
        DataTableResponseDTO responseDTO = new DataTableResponseDTO();
        responseDTO.setDraw(dataTableRequestDTO.getDraw());
        try{
            List<SysRoleDTO> sysRoleDTOs = new ArrayList<>();
            Long count = sysRoleDAO.searchSysRoleCountWithDataTableCriteria(dataTableRequestDTO);
            sysRoleDAO.searchSysRoleWithDataTableCriteria(dataTableRequestDTO)
                    .stream()
                    .forEach(sysRole -> {
                        SysRoleDTO sysRoleDTO = new SysRoleDTO();
                        sysRoleDTO.setCode(sysRole.getCode());
                        sysRoleDTO.setDescription(sysRole.getDescription());
                        sysRoleDTO.setStatus(sysRole.getStatus().getDescription());
                        sysRoleDTO.setCreatedBy(sysRole.getCreatedBy());
                        sysRoleDTO.setCreatedOn(sysRole.getCreatedOn());
                        sysRoleDTO.setUpdatedBy(sysRole.getUpdatedBy());
                        sysRoleDTO.setUpdatedOn(sysRole.getUpdatedOn());
                        sysRoleDTOs.add(sysRoleDTO);
                    });
            responseDTO.setData(sysRoleDTOs);
            responseDTO.setRecordsFiltered(count);
            responseDTO.setRecordsTotal(count);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return responseDTO;
    }
}
