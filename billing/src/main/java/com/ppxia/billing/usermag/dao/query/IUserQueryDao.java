package com.ppxia.billing.usermag.dao.query;

import com.ppxia.billing.beans.UserBean;

public interface IUserQueryDao {
	public UserBean findById(Long id );
}
