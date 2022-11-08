package com.ozkaraca.cqrsdemo.core.cq.command;

import com.ozkaraca.cqrsdemo.core.cq.command.result.CommandResult;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface CommandHandler<TCommand extends Command> {
    CommandResult handle(TCommand command) throws IOException, TimeoutException;
}
