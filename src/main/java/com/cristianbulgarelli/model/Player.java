package com.cristianbulgarelli.model;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Player implements Serializable {

	private static final long serialVersionUID = 7224635385799931370L;

	@NonNull
    private String name;

	@Override
	public String toString() {
		return this.getName();
	}
}
