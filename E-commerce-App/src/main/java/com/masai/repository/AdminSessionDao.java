package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Admin;
import com.masai.model.CurrentAdminSession;

@Repository
public interface AdminSessionDao extends JpaRepository<Admin, Integer>{
    public CurrentAdminSession findByUuid(String uuid);

	public void save(CurrentAdminSession currentAdminSession);

}
