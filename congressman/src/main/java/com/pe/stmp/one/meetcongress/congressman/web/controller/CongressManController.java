package com.pe.stmp.one.meetcongress.congressman.web.controller;

import com.pe.stmp.one.meetcongress.congressman.web.model.dao.Congressman;
import com.pe.stmp.one.meetcongress.congressman.web.services.CongressManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RefreshScope
@RestController
public class CongressManController {

    @Autowired
    CongressManService congressManService;

    @GetMapping(value = "/list-congress",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Congressman>> getListCongressMan(){
        return new ResponseEntity<>(congressManService.getListCongressman(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-member/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Congressman> getCongresmman(@PathVariable(value = "id") String idMember){
        return null;
    }

    @PostMapping(value = "/insert-image", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertMemberImage(){
        return null;
    }

}