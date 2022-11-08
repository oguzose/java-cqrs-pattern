package com.ozkaraca.cqrsdemo.core.cq.command.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozkaraca.cqrsdemo.core.cq.command.CommandHandler;
import com.ozkaraca.cqrsdemo.core.cq.command.result.CommandResult;
import com.ozkaraca.cqrsdemo.core.rabbitmq.publisher.RabbitMqPublisher;
import com.ozkaraca.cqrsdemo.entity.Classified;
import com.ozkaraca.cqrsdemo.repository.ClassifiedRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class CreateClassifiedCommandHandler implements CommandHandler<CreateClassifiedCommand> {

    private final ClassifiedRepository classifiedRepository;
    private final RabbitMqPublisher rabbitMqPublisher;
    private final ObjectMapper objectMapper;

    private final String CLASSIFIED_INSERTED_QUEUE = "CLASSIFIED_INSERTED_QUEUE";

    public CreateClassifiedCommandHandler(ClassifiedRepository classifiedRepository,
                                          RabbitMqPublisher rabbitMqPublisher,
                                          ObjectMapper objectMapper) {
        this.classifiedRepository = classifiedRepository;
        this.rabbitMqPublisher = rabbitMqPublisher;
        this.objectMapper = objectMapper;
    }

    @Override
    public CommandResult handle(CreateClassifiedCommand command) throws IOException, TimeoutException {
        // Prepare a classified.
        Classified classified = Classified
                .builder()
                .title(command.getTitle())
                .price(command.getPrice())
                .detail(command.getDetail())
                .categoryId(command.getCategoryId())
                .build();

        // Save to MySQL.
        Classified insertedClassified = this.classifiedRepository.save(classified);

        // Send an event.
        rabbitMqPublisher.publish(CLASSIFIED_INSERTED_QUEUE, objectMapper.writeValueAsString(insertedClassified));

        return new CommandResult(true, "");
    }
}
