package sample.biz.business.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import sample.biz.business.dao.PetDao;
import sample.biz.business.domain.Pet;
import sample.biz.business.service.PetService;

import java.util.List;

public class PetServiceImpl implements PetService {

    private PetDao petDao;

    //@Autowired
    private PlatformTransactionManager txManager;

    public PetServiceImpl(PetDao petDao, PlatformTransactionManager txManager) {
        this.petDao = petDao;
        this.txManager = txManager;
    }

    @Override
    public void updatePetProgrammaticTransaction(Pet pet) {

        TransactionTemplate t = new TransactionTemplate(txManager);
        t.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        // updatePet2でExceptionが発生するとrollbackされる。
        //t.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        t.setTimeout(10);
        t.setReadOnly(false);

        try {
            t.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    petDao.updatePet(pet.getPetName(), pet.getPrice(), pet.getPetId());
                }
            });
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public List<Pet> findPets(Pet pet){
        TransactionTemplate t = new TransactionTemplate(txManager);
        List<Pet> list = null;
        // T -> List<Pet>
        // public interface TransactionCallback<T>
        // T doInTransaction(TransactionStatus status)
        try {
             list = t.execute(new TransactionCallback<List<Pet>>() {
                @Override
                public List<Pet> doInTransaction(TransactionStatus status) {
                    return petDao.findPets(pet.getPetName());
                }
            });
        }catch (Exception e){
            System.out.println(e);
        }
        return  list;
    }

}
