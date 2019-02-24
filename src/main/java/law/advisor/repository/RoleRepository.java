package law.advisor.repository;

import law.advisor.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByName(String name);
}
