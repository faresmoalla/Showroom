package tn.showroom.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.showroom.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
	Role findByRole(String role);
}
