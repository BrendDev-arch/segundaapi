package com.jkalango.webapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/fases")
public class FaseJogoController {

    @GetMapping
    public int  mostraQtdeFases(){

        return  7;
    }


}
