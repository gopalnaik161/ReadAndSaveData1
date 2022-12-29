package ReadAndSave.app.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import ReadAndSave.app.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
