package com.ppxia.billing.authortymag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.ppxia.billing.beans.AuthorityBean;

public interface AuthorityMapper {
	
	@ResultType(AuthorityBean.class)
	@Select("select id as id,authority_name as authorityName,authority_num as authorityNum from t_authority where authority_num like concat(#{authorityNum},'%') and LENGTH(authority_num)=LENGTH(#{authorityNum})+2")
	public List<AuthorityBean> findAuthorityBySuperAuthority(int authorityNum);
	
	@ResultType(AuthorityBean.class)
	@Select("select id as id,authority_name as authorityName,authority_num as authorityNum from t_authority where authority_num like concat(#{authorityNum},'%')")
	public List<AuthorityBean> findAuthorityBySuperAuthorityContainSuperAuthority(String authorityNum);
	
	@ResultType(AuthorityBean.class)
	@Select("select id as id,authority_name as authorityName,authority_num as authorityNum from t_authority where authority_num =(select max(authority_num) from t_authority where authority_num like concat(#{authorityNum},'%'))")
	public AuthorityBean findLastAuthorityBySuperAuthority(String authorityNum);
	
	@ResultType(AuthorityBean.class)
	@Select("select a.id as id,authority_name as authorityName from t_authority a left join t_role_authority ra on a.id = ra.fk_authority_id where ra.fk_role_id = #{id}")
	public AuthorityBean findAuthorityById(Long id);
	
	@ResultType(AuthorityBean.class)
	@Select("select id as id,authority_name as authorityName,authority_num as authorityNum from t_authority")
	public List<AuthorityBean> findAllAuthority();
	
	@ResultType(AuthorityBean.class)
	@Select("select id as id,authority_name as authorityName,authority_num as authorityNum from t_authority where id = #{id}")
	public AuthorityBean findAuthorityByAuthorityId(Long id);
}
