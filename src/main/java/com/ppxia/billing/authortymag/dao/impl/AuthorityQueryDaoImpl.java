package com.ppxia.billing.authortymag.dao.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.ppxia.billing.authortymag.dao.IAuthorityHandleDao;
import com.ppxia.billing.beans.AuthorityBean;

@Repository
public class AuthorityQueryDaoImpl implements IAuthorityHandleDao {

	
	
	@Override
	public List<AuthorityBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityBean> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityBean> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AuthorityBean> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends AuthorityBean> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<AuthorityBean> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public AuthorityBean getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AuthorityBean> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AuthorityBean> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AuthorityBean> findAll(Pageable arg0) {
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
	public void delete(AuthorityBean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends AuthorityBean> arg0) {
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
	public AuthorityBean findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AuthorityBean> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AuthorityBean> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends AuthorityBean> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends AuthorityBean> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AuthorityBean> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorityBean findOne(Specification<AuthorityBean> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityBean> findAll(Specification<AuthorityBean> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AuthorityBean> findAll(Specification<AuthorityBean> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityBean> findAll(Specification<AuthorityBean> spec, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Specification<AuthorityBean> spec) {
		// TODO Auto-generated method stub
		return 0;
	}

}
