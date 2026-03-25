package com.mjc813.chapter21.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRestController {
    @Autowired
    private GameService gameService;

	@PostMapping("/api/insert-data")
    @ResponseBody
	public ResponseEntity<CommonResponse> insertData(@RequestBody GameDto gameDto) {
        try {
            System.out.println("insertData" + gameDto.toString());
            this.gameService.insertData(gameDto);
            return ResponseEntity.ok(new CommonResponse(0,"Insert"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(100,"InsertFail"));
        }
	}
    @PostMapping("/api/update-data")
    @ResponseBody
    public ResponseEntity<CommonResponse> updateData(@RequestBody GameDto gameDto){
        try {
            System.out.println("updateData" + gameDto.toString());
            this.gameService.updateData(gameDto);
            return ResponseEntity.ok(new CommonResponse(1,"Update"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(101,"UpdateFail"));
        }
    }
}
