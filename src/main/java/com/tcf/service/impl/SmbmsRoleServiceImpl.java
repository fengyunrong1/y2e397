package com.tcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcf.dao.SmbmsRoleMapper;
import com.tcf.entity.SmbmsRole;
import com.tcf.service.SmbmsRoleService;

@Service
public class SmbmsRoleServiceImpl implements SmbmsRoleService {
	
	@Autowired
	private SmbmsRoleMapper mapper;

	@Override
	public List<SmbmsRole> getAllSmbmsRoles() {
		// TODO Auto-generated method stub
		return mapper.getAllSmbmsRoles();
	}
}
