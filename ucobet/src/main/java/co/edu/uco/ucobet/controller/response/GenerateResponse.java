package co.edu.uco.ucobet.controller.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.edu.uco.ucobet.controller.response.concrete.GenericResponse;

public class GenerateResponse <T> {
	
    public ResponseEntity<GenericResponse> generateSuccessResponse(final List<String> messages){
		
		var genericResponse = new GenericResponse();
		genericResponse.setMessages(messages);
		
		return new ResponseEntity<>(genericResponse, HttpStatus.Ok);
		}

	
	public  ResponseEntity generateFailedResponse(final List<String> messages){
	
		var genericResponse = new GenericResponse();
		genericResponse.setMessages(messages);
		
		return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
		}
	
	
	public ResponseEntity <ResponseWithData<T>> generateFailedResponse(final List responseWithData<T> messages, final List<Object> data){
		
		return new ResponseEntity<>(responseWithData, HttpStatus.Ok);
	}

}
