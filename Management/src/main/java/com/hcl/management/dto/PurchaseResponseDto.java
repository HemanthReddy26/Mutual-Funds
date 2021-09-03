package com.hcl.management.dto;

import com.hcl.management.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDto {

	private String portfolio;

	private String quantity;
	
	private double totalPrice;
	
	private Account account;

}
