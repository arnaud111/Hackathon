package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.TrashCreationDto;
import com.greenring.hackathon.application.mapper.TrashDtoMapper;
import com.greenring.hackathon.domain.model.Trash;
import com.greenring.hackathon.domain.port.client.TrashApi;
import io.swagger.annotations.Api;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Api
@RequestMapping("/trashs")
public class TrashController {

    private final TrashApi trashApi;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid TrashCreationDto dto) {

        return trashApi
                .create(TrashDtoMapper.trashCreationToDomain(dto))
                .map(TrashDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping(value = "/{trash_id}")
    public Option<Trash> getTrash(@PathVariable UUID trash_id) {
        return trashApi
                .getOne(trash_id);
    }

    @GetMapping(value = "/")
    public List<Trash> getTrashs() {
        return trashApi
                .getAll();
    }

    @DeleteMapping(value="/{trash_id}")
    public Option<Trash>deletetrash(@PathVariable UUID trash_id){
        return trashApi.deleteTrash(trash_id);
    }
}
