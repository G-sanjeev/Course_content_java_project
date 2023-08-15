package com.courseapp.service;

import java.util.List;

import com.courseapp.dao.IPurchased;
import com.courseapp.dao.PurchasedDao;
import com.courseapp.model.PurchasedData;

public class PurchasedService implements IPurchaseService {
	IPurchased purchasedDao = new PurchasedDao();
	@Override
	public List<PurchasedData> getAll() {
		return purchasedDao.findAll();
	}
	@Override
	public void addPurchased(PurchasedData purchasedData) {
		try {
			purchasedDao.addPurchased(purchasedData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
