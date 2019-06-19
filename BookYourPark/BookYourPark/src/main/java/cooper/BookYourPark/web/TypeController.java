package cooper.BookYourPark.web;


import cooper.BookYourPark.model.Type;
import cooper.BookYourPark.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/types",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Type> gettypes(){
        return typeService.getallTypes();
    }

    @RequestMapping(value = "/types/{typeId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Type gettypebyId(@PathVariable("typeId")Integer typeId){
        return typeService.getTypesById(typeId);
    }

    @RequestMapping(value = "/types",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> CreateType(@RequestBody Type type){
        Type CreatedType=typeService.createType(type);
        return Optional.ofNullable(CreatedType)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/types",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> createType(@RequestBody Type type){
        Type createdTypes=typeService.createType(type);
        return Optional.ofNullable(createdTypes)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "types/{typeId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteTypebytypeId(@PathVariable("typeId") Integer typeId){
        System.out.println(typeId);
        typeService.deletetypeByTypeId(typeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
