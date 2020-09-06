package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample.biz.business.domain.Pet;
import sample.biz.business.service.PetService;

import java.util.List;

public class TranByFileMain {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-jpa.xml");
        PetService petService = applicationContext.getBean(PetService.class);

        Pet pet = new Pet();
        pet.setPetId(2);
        pet.setPrice(1000);
        pet.setPetName("sada");



        petService.updatePetProgrammaticTransaction(pet);

        List<Pet> list = petService.findPets(pet);
        list.forEach(aa -> System.out.println(aa.getPetName()));

    }





}
