package sample.biz.business.service;

import sample.biz.business.domain.Pet;

import java.util.List;

public interface PetService {

    void updatePetProgrammaticTransaction(Pet pet);

    List<Pet> findPets(Pet pet);


}
