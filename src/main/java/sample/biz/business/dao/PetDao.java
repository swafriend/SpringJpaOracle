package sample.biz.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sample.biz.business.domain.Pet;

import java.util.List;

@Repository
public interface PetDao extends JpaRepository<Pet, Integer> {

    @Modifying
    @Query("UPDATE Pet u SET u.petName = :petName, u.price = :price WHERE u.petId = :petId")
    int updatePet(@Param("petName") String petName, @Param("price") int price, @Param("petId") int petId);

    @Modifying
    @Query("UPDATE Pet u SET u.petName = :petName, u.price = :price WHERE u.petId = :petId")
    int updatePet2(@Param("petName") String petName, @Param("price") int price, @Param("petId") int petId);

    @Query("select u from Pet u where u.petName = :petName order by u.petId asc")
    List<Pet> findPets(@Param("petName") String petName);

}
