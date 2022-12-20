package service;

import dto.AlatDto;
import model.Alat;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AlatService {

    public List<Alat> listAlat(){
        return Alat.listAll();
    }

    @Transactional
    public Alat saveAlat(AlatDto dto){
        Alat alat = new Alat();
        alat.setNamaAlat(dto. getNamaAlat());
        alat.setStock(dto.getStock());
        alat.setPrice(dto.getPrice());
        alat.persist();

        return alat;
    }

    @Transactional
    public void updateAlat(Long id, AlatDto dto){
        Alat alat = new Alat();
        Optional<Alat> alatOp = Alat.findByIdOptional(id);

        if(alatOp.isEmpty()){
            throw new NullPointerException("alat tidak di temukan");
        }

        alat = alatOp.get();

        alat.setNamaAlat(dto.getNamaAlat());
        alat.setPrice(dto.getPrice());
        alat.setStock(dto.getStock());
        alat.persist();
    }

    @Transactional
    public void removeAlat(Long id){

        Optional<Alat> alatOp = Alat.findByIdOptional(id);
        if(alatOp.isEmpty()){
            throw new NullPointerException("alat tidak di temukan");
        }

        Alat alat = alatOp.get();
        alat.delete();
    }
}
