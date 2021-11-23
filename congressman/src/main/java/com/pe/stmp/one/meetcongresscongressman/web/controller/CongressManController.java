package com.pe.stmp.one.meetcongresscongressman.web.controller;

import com.pe.stmp.one.meetcongresscongressman.web.model.Congressman;
import com.pe.stmp.one.meetcongresscongressman.web.services.CongressManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

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

    @PostMapping(value = "/insert-image", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertMemberImage(){
        return null;
    }

}
