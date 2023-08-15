package com.courseapp.service;

import java.util.List;

import com.courseapp.model.PurchasedData;


public interface IPurchaseService {
	void addPurchased(PurchasedData purchasedData);

	List<PurchasedData> getAll();

}
