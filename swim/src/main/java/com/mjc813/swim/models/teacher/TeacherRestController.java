package com.mjc813.swim.models.teacher;

import com.mjc813.swim.common.ApiResponse;
import com.mjc813.swim.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

        return ResponseEntity.status(HttpStatus.CREATED).body(
            ApiResponse.make(ResponseCode.insert_ok,"ok",result)
        );
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<TeacherDto>> update(@RequestBody TeacherDto teacherDto){
        TeacherDto result = this.teacherService.update(teacherDto);

        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.update_ok,"ok",result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> findById(@PathVariable Long id){
        TeacherDto result = this.teacherService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.select_ok,"ok",result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> deleteById(@PathVariable Long id){
        TeacherDto result = this.teacherService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.delete_ok,"ok",result)
        );
    }

    @GetMapping("/name")
    public ResponseEntity<ApiResponse<Slice<TeacherDto>>> findAllByName(@RequestParam(name = "name") String name
        , @PageableDefault(size=10, page=0, sort="name", direction= Sort.Direction.ASC) Pageable pageable){
        Slice<TeacherDto> result = this.teacherService.findAllByName(name,pageable);
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse.make(ResponseCode.select_ok,"ok",result)
        );
    }
}
