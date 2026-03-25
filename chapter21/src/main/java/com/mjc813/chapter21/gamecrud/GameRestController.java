package com.mjc813.chapter21.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRestController {
    @Autowired
    private GameService gameService;
	@PostMapping("/api/insert-data")
	public ResponseEntity<CommonResponse> insertData(@RequestBody GameDto gameDto) {
        try {
            System.out.println(gameDto);
            System.out.println("insertData" + gameDto.toString());
            this.gameService.insertData(gameDto);
            return ResponseEntity.ok(new CommonResponse(0,"OK"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999,"FAIL"));
        }
	}
}
