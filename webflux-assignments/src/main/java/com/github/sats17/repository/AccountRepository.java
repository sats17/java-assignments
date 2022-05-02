package com.github.sats17.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.sats17.model.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, String>{

}
