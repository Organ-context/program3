package com.ppxia.billing.accountingmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.ppxia.billing.accountingmag.dao.IAccountingHandleDao;
import com.ppxia.billing.beans.UserBean;

@Repository
public class AccountingHandleDaoImpl implements IAccountingHandleDao{
	

	
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<UserBean> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserBean> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserBean> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBean getOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserBean> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserBean> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserBean> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserBean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends UserBean> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserBean findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserBean> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserBean> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends UserBean> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends UserBean> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserBean> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Specification<UserBean> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserBean> findAll(Specification<UserBean> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserBean> findAll(Specification<UserBean> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> findAll(Specification<UserBean> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean findOne(Specification<UserBean> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
