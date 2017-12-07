package com.tcf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tcf.entity.SmbmsUser;

public interface SmbmsUserMapper {
	SmbmsUser login(SmbmsUser user);
	List<SmbmsUser> getUsers(SmbmsUser user);
	int updateSmbmsUser(SmbmsUser user);
	int addSmbmsUser(SmbmsUser user);
	List<SmbmsUser> getsmUsers(@Param("userName") String userName,
			@Param("userRole") Integer userRole,
			@Param("begin") int begin,@Param("size") int size);
	int getUserRows(@Param("userName") String userName,@Param("userRole") Integer userRole);
}
