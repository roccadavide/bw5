package daviderocca.DAO;

import daviderocca.entities.Tessera;
import daviderocca.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.UUID;

public class TessereDAO {

    private final EntityManager entityManager;

    public TessereDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Tessera tessera){

        EntityTransaction et= entityManager.getTransaction();
        et.begin();

        entityManager.persist(tessera);

        et.commit();

        System.out.println("la tessera "+ tessera + "è stata correttamente salvata");
    }

    public Tessera findById(UUID id){
        Tessera trovata= entityManager.find(Tessera.class,id);
        if (trovata==null)
            throw new NotFoundException(id);

        return  trovata;
    }

    public void deleteById(UUID id){
        Tessera daEliminare= this.findById(id);
        EntityTransaction et=entityManager.getTransaction();
        et.begin();
        entityManager.remove(daEliminare);
        et.commit();

        System.out.println("libro "+daEliminare+" è stato eliminato");
    }

    public void renewalById(UUID id){
        Tessera daRinnovare= this.findById(id);
        if (daRinnovare.getDataRinnovo()==null){
            if (LocalDate.now().isAfter(daRinnovare.getDataEmissione().plusYears(1))){
                daRinnovare.setDataRinnovo(LocalDate.now());
            }
            else
            System.out.println("la tessera "+daRinnovare + " è ancora valida");
        }
        else  if (LocalDate.now().isAfter(daRinnovare.getDataRinnovo().plusYears(1))){
            daRinnovare.setDataRinnovo(LocalDate.now());
        }
        else
            System.out.println("il rinnovo della tessera "+daRinnovare + " è ancora valido");
    }


}
