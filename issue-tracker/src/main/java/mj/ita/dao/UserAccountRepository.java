package mj.ita.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import mj.ita.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>  {

}
