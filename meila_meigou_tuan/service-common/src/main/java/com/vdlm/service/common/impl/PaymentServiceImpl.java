package com.vdlm.service.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdlm.dal.mapper.PaymentMapper;
import com.vdlm.dal.model.Payment;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.common.PaymentService;

@Service("paymentService")
public class PaymentServiceImpl extends BaseServiceImpl implements PaymentService {
	@Autowired
	private PaymentMapper paymentMapper;
	
	private List<Payment> payments;

	@Override
	public List<Payment> load() {
		if (payments == null){
			payments = paymentMapper.list();
		}
		return payments;
	}
	
	@Override
	public List<Payment> reload() {
		payments = paymentMapper.list();
		return payments;
	}
}
