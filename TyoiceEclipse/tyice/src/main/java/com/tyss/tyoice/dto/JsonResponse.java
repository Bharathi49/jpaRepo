package com.tyss.tyoice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse {

	private String message;

	private boolean error;

	private Object data;
}
