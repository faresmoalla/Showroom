package tn.showroom.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.showroom.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	User findByUserName(String userName);
}
