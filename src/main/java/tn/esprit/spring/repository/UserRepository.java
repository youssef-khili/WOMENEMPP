package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("select  t.users from Training t where t.trainingName=:name")
    List<User> getNbrApprenantByFormation(@Param("name") String name);

    @Query(value="select count(u.idUser) from Training t join t.users u where t.trainingName=:titre")
    Integer getNbrrApprenantByFormation(@Param("titre") String titre);

    @Query("select t.users from  Training t where t.idTraining=:id")
    List<User> getRevenueByFormation(@Param("id") Integer idTraining);
}
