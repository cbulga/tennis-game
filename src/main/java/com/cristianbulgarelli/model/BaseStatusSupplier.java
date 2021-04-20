package com.cristianbulgarelli.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
public abstract class BaseStatusSupplier implements StatusSupplier, Serializable {

    private boolean finished;
    private Player winner;
}
