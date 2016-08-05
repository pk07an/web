package com.vdlm.service.common;

import java.util.List;

import com.vdlm.dal.model.Payment;

public interface PaymentService {
	List<Payment> load();
	
	List<Payment> reload();

}
