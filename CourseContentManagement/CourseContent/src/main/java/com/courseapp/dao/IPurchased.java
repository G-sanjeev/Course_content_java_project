package com.courseapp.dao;

import java.util.List;

import com.courseapp.model.PurchasedData;

public interface IPurchased {
	void addPurchased(PurchasedData purchasedData);
	List<PurchasedData> findAll();
}
