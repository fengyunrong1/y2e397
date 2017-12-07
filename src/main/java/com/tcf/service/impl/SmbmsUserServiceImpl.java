package com.tcf.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcf.dao.SmbmsUserMapper;
import com.tcf.entity.SmbmsUser;
import com.tcf.service.SmbmsUserService;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {
	@Autowired
	private SmbmsUserMapper mapper;

	@Override
	public SmbmsUser login(SmbmsUser user) {
		// TODO Auto-generated method stub
		return mapper.login(user);
	}
	@Override
	public int addSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return mapper.addSmbmsUser(user);
	}
	@Override
	public List<SmbmsUser> getsmUsers(String userName, Integer userRole,
			int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return mapper.getsmUsers(userName, userRole, (pageIndex-1)*pageSize, pageSize);
	}
	@Override
	public int getUserRows(String userName, Integer userRole) {
		// TODO Auto-generated method stub
		return mapper.getUserRows(userName, userRole);
	}
	@Override
	public SmbmsUser getUserById(Serializable id) {
		// TODO Auto-generated method stub
		SmbmsUser user = new SmbmsUser();
		user.setId((Long)id);
		List<SmbmsUser> users = mapper.getUsers(user);
		return users.size()>0?users.get(0):null;
	}
	@Override
	public int updateSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return mapper.updateSmbmsUser(user);
	}
}
