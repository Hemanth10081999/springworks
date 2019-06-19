package cooper.BookYourPark.service;


import cooper.BookYourPark.model.Type;
import cooper.BookYourPark.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getallTypes() {
        return (List<Type>) typeRepository.findAll();
    }


    public Type getTypesById(Integer typeId) {
        return typeRepository.findById(typeId).get();
    }

    public Type createType(Type type){
        return typeRepository.save(type);
    }

    public void deletetypeByTypeId(Integer typeId){
        typeRepository.deleteById(typeId);
    }
}
