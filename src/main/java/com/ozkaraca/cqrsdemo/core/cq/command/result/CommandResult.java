package com.ozkaraca.cqrsdemo.core.cq.command.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandResult {

    private Boolean isSuccess;

    private String message;

}
