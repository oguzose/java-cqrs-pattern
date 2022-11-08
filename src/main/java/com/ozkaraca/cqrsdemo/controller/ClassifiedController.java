package com.ozkaraca.cqrsdemo.controller;

import com.ozkaraca.cqrsdemo.core.cq.command.impl.CreateClassifiedCommand;
import com.ozkaraca.cqrsdemo.core.cq.command.impl.CreateClassifiedCommandHandler;
import com.ozkaraca.cqrsdemo.core.cq.command.result.CommandResult;
import com.ozkaraca.cqrsdemo.core.cq.query.impl.GetClassifiedsQuery;
import com.ozkaraca.cqrsdemo.core.cq.query.impl.GetClassifiedsQueryHandler;
import com.ozkaraca.cqrsdemo.entity.Classified;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/classifieds")
public class ClassifiedController {

    private final GetClassifiedsQueryHandler getClassifiedsQueryHandler;
    private final CreateClassifiedCommandHandler createClassifiedCommandHandler;

    public ClassifiedController(GetClassifiedsQueryHandler getClassifiedsQueryHandler, CreateClassifiedCommandHandler createClassifiedCommandHandler) {
        this.getClassifiedsQueryHandler = getClassifiedsQueryHandler;
        this.createClassifiedCommandHandler = createClassifiedCommandHandler;
    }

    @GetMapping
    public ResponseEntity<?> index() throws Exception {
        List<Classified> classifieds = this.getClassifiedsQueryHandler.handle(new GetClassifiedsQuery());
        return ResponseEntity.ok(classifieds);
    }

    @PostMapping
    public CommandResult add(@RequestBody CreateClassifiedCommand command) throws IOException, TimeoutException {
        return this.createClassifiedCommandHandler.handle(command);
    }
}
