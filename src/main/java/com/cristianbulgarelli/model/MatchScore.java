package com.cristianbulgarelli.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class MatchScore extends BaseStatusSupplier {

    @NonNull
    private final String name;
    private final SetScore[] setScores;
}
