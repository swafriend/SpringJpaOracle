package sample.biz.dataaccess;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import sample.biz.business.dao.PetDao;
import sample.biz.business.domain.Pet;

import java.util.List;

//public class PetDaoSpringJpa implements PetDao {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public PetDaoSpringJpa(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public void updatePet(Pet pet) {
//        jdbcTemplate.update("UPDATE PET SET PET_NAME=?, PRICE=? WHERE PET_ID=?",
//                pet.getPetName(), pet.getPrice(), pet.getPetId());
//    }
//
//    public void updatePet2(Pet pet) {
//        jdbcTemplate.update("UPDATE PET2 SET PET_NAME=?, PRICE=? WHERE PET_ID=?",
//                pet.getPetName(), pet.getPrice(), pet.getPetId());
//    }
//
//    @Override
//    public List<Pet> findPets(String petName) {
//        return null;
//    }
//
//
//}
