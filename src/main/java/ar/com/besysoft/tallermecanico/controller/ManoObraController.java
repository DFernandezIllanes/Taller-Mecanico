package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.dtos.mappers.ManoObraMapper;
import ar.com.besysoft.tallermecanico.model.ManoObra;
import ar.com.besysoft.tallermecanico.service.interfaces.ManoObraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/manos-obras")
public class ManoObraController {

    private final ManoObraService manoObraService;

    public ManoObraController(ManoObraService manoObraService) {
        this.manoObraService = manoObraService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ManoObra> manoObraList = this.manoObraService.getAll();
        return ResponseEntity.ok(ManoObraMapper.mapListToDto(manoObraList));
    }
}
