package com.leaf.hrm.controller;

import com.leaf.hrm.dto.DataTableRequestDTO;
import com.leaf.hrm.dto.SysRoleDTO;
import com.leaf.hrm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Rusiru on 27-Jul-18.
 */

@RestController
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @PreAuthorize("hasRole('ROLE_ROLE')")
    @RequestMapping(value = "saveSysRole", method = RequestMethod.POST)
    public ResponseEntity<?> saveSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
        return ResponseEntity.ok().body(sysRoleService.saveSysRole(sysRoleDTO, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PreAuthorize("hasRole('ROLE_ROLE')")
    @RequestMapping(value = "updateSysRole", method = RequestMethod.POST)
    public ResponseEntity<?> updateSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
        return ResponseEntity.ok().body(sysRoleService.updateSysRole(sysRoleDTO, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PreAuthorize("hasRole('ROLE_ROLE')")
    @RequestMapping(value = "deleteSysRole", method = RequestMethod.POST)
    public ResponseEntity<?> deleteSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
        return ResponseEntity.ok().body(sysRoleService.deleteSysRole(sysRoleDTO, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PreAuthorize("hasRole('ROLE_ROLE')")
    @RequestMapping(value = "searchSysRole", method = RequestMethod.POST)
    public ResponseEntity<?> searchSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
        return ResponseEntity.ok().body(sysRoleService.searchSysRole(sysRoleDTO));
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ROLE')")
    @RequestMapping(value = "loadAllSysRole", method = RequestMethod.POST)
    public ResponseEntity<?> loadToGridSysRole(@RequestBody DataTableRequestDTO dataTableRequestDTO) {
        return ResponseEntity.ok().body(sysRoleService.searchSysRolesForDataTable(dataTableRequestDTO));
    }
}
