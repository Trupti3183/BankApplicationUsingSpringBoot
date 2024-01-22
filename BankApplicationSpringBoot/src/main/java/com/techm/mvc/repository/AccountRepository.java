package com.techm.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.mvc.model.Account;
import com.techm.mvc.model.User;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findByUser_Id(Long userId);

}
