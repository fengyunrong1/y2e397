package com.tcf.service;

import java.io.Serializable;
import java.util.List;

import com.tcf.entity.SmbmsUser;

public interface SmbmsUserService {
	SmbmsUser login(SmbmsUser user);
	SmbmsUser getUserById(Serializable id);
	int updateSmbmsUser(SmbmsUser user);
	int addSmbmsUser(SmbmsUser user);
	List<SmbmsUser> getsmUsers(String userName,Integer userRole,int pageIndex,int pageSize);
	int getUserRows(String userName,Integer userRole);
}
