package com.mjc813.swim.models.teacher;

import com.mjc813.swim.models.common.ApiResponse;
import com.mjc813.swim.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherRestController {
    @Autowired
    public TeacherService teacherService;

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherDto>> insert(@RequestBody TeacherDto teacherDto){
        TeacherDto result = this.teacherService.insert(teacherDto);

        return ResponseEntity.status(200).body(
            ApiResponse.make(ResponseCode.insert_ok,"ok",result)
        );
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<TeacherDto>> update(@RequestBody TeacherDto teacherDto){
        TeacherDto result = this.teacherService.update(teacherDto);

        return ResponseEntity.status(201).body(
            ApiResponse.make(ResponseCode.update_ok,"ok",result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> findById(@PathVariable Long id){
        TeacherDto result = this.teacherService.findById(id);
        return ResponseEntity.status(202).body(
            ApiResponse.make(ResponseCode.select_ok,"ok",result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> deleteById(@PathVariable Long id){
        TeacherDto result = this.teacherService.deleteById(id);
        return ResponseEntity.status(203).body(
            ApiResponse.make(ResponseCode.delete_ok,"ok",result)
        );
    }
}
