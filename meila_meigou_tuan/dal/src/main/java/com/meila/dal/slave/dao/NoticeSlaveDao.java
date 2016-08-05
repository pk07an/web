package com.meila.dal.slave.dao;

import com.vdlm.dal.model.PublicNotice;

public interface NoticeSlaveDao {
	PublicNotice selectCurrentNotice();
}
