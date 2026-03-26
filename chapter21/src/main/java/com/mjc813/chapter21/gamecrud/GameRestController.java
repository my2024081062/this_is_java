package com.mjc813.chapter21.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/api/delete-data")
    @ResponseBody
    public ResponseEntity<CommonResponse> deleteData(@RequestBody GameDto gameDto){
        try {
            System.out.println("deleteData" + gameDto.toString());
            this.gameService.deleteData(gameDto);
            return ResponseEntity.ok(new CommonResponse(2,"Delete"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(102,"DeleteFail"));
        }
    }
    @ResponseBody
    @GetMapping("/api/getdata")
    public ResponseEntity<CommonResponse> getData(@RequestParam("id") Integer id) {
        try {
            System.out.println("getData, id=" + id);
            GameDto find = this.gameService.findById(id);
            return ResponseEntity.ok().body(new CommonResponse(0, "OK", find));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error", null));
        }
    }

    @PostMapping("/api/get-all-games")
    public List<GameDto> getAllGames(){
        try {
            return this.gameService.getAllGames();
        } catch (Exception e) {
            throw new RuntimeException("실패");
        }
    }
}
