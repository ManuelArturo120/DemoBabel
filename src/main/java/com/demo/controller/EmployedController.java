package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demo.exception.InternalServerError;
import com.demo.service.EmployedService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@Validated
public class EmployedController {
	
	@Autowired
	private EmployedService service;


    @Operation(
            summary = "Obtain the employed info",
            tags = { "getemployed"},
            description = "Obtain the employed inf")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = EmployeeResponse.class), mediaType = "application/json") })
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "BAD_REQUEST", summary = "BAD_REQUEST.", description = "BAD_REQUEST.",
                    value = "{\n  \"reason\": \"400 ERR.BAD_REQUEST\",\n  \"httpCode\": \"400\"\n}")

    }))

    @ApiResponse(responseCode = "500", description = "SERVER_ERROR.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "SERVER_ERROR", summary = "SERVER_ERROR.", description = "SERVER_ERROR.",
                    value = "{\n  \"reason\": \"ERR.SERVER_ERROR\",\n  \"httpCode\": \"500\"\n}")

    }))

        @Parameter(name = "content-type", in = ParameterIn.HEADER, description = "Contet-Type to data api", schema = @Schema(implementation = String.class), required = true, examples = {
            @ExampleObject(name = "application/json, application/json;charset=UTF-8")})
   
	@GetMapping("/getEmployed")

 	public ResponseEntity<List<EmployeeResponse>> findALL() throws JsonProcessingException, InternalServerError{
		List<EmployeeResponse> result = service.findALL();
		return ResponseEntity.ok(result);
	}
    @Operation(
            summary = "Obtain the employed info",
            tags = { "getemployed"},
            description = "Microservice for get the offer from sabre")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = EmployeeResponse.class), mediaType = "application/json") })
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "BAD_REQUEST", summary = "BAD_REQUEST.", description = "BAD_REQUEST.",
                    value = "{\n  \"reason\": \"400 ERR.BAD_REQUEST\",\n  \"httpCode\": \"400\"\n}")

    }))

    @ApiResponse(responseCode = "500", description = "SERVER_ERROR.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "SERVER_ERROR", summary = "SERVER_ERROR.", description = "SERVER_ERROR.",
                    value = "{\n  \"reason\": \"ERRSERVER_ERROR\",\n  \"httpCode\": \"500\"\n}")

    }))

        @Parameter(name = "content-type", in = ParameterIn.HEADER, description = "Contet-Type to data api", schema = @Schema(implementation = String.class), required = true, examples = {
            @ExampleObject(name = "application/json, application/json;charset=UTF-8")})
   
	@PostMapping("/addEmployed")
		public  ResponseEntity<?> post( @Valid @RequestBody List<EmployerRequest> body)throws InternalServerError, JsonProcessingException {
		
		List<EmployeeResponse> save = service.addEmplotyed(body);
		return ResponseEntity.ok(save);
		
	}
    @Operation(
            summary = "delete employed info",
            tags = { "deleteEmployed"},
            description = "delete employed info")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = EmployeeResponse.class), mediaType = "application/json") })
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "BAD_REQUEST", summary = "BAD_REQUEST.", description = "BAD_REQUEST.",
                    value = "{\n  \"reason\": \"400 ERR.BAD_REQUEST\",\n  \"httpCode\": \"400\"\n}")

    }))

    @ApiResponse(responseCode = "500", description = "SERVER_ERROR.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "SERVER_ERROR", summary = "SERVER_ERROR.", description = "SERVER_ERROR.",
                    value = "{\n  \"reason\": \"ERRSERVER_ERROR\",\n  \"httpCode\": \"500\"\n}")

    }))

        @Parameter(name = "content-type", in = ParameterIn.HEADER, description = "Contet-Type to data api", schema = @Schema(implementation = String.class), required = true, examples = {
            @ExampleObject(name = "application/json, application/json;charset=UTF-8")})
   
		@DeleteMapping("/deleteEmployed")
	public  ResponseEntity<?> delete( @Parameter(description = "ID del empleado", required = true) @RequestParam(name = "id") int id){
		
		service.deleteEmployed(id);
		return ResponseEntity.ok(null);
		
	}
    @Operation(
            summary = "Update employed info",
            tags = { "updateEmployed"},
            description = "Update employed info")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = EmployeeResponse.class), mediaType = "application/json") })
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "BAD_REQUEST", summary = "BAD_REQUEST.", description = "BAD_REQUEST.",
                    value = "{\n  \"reason\": \"400 ERR.BAD_REQUEST\",\n  \"httpCode\": \"400\"\n}")

    }))

    @ApiResponse(responseCode = "500", description = "SERVER_ERROR.", content = @Content(mediaType = "application/json",examples = {
            @ExampleObject(name = "SERVER_ERROR", summary = "SERVER_ERROR.", description = "SERVER_ERROR.",
                    value = "{\n  \"reason\": \"ERRSERVER_ERROR\",\n  \"httpCode\": \"500\"\n}")

    }))

        @Parameter(name = "content-type", in = ParameterIn.HEADER, description = "Contet-Type to data api", schema = @Schema(implementation = String.class), required = true, examples = {
            @ExampleObject(name = "application/json, application/json;charset=UTF-8")})
   
	@PatchMapping("/updateEmployed")
	public  ResponseEntity<?> patch(  @Parameter(description = "ID del empleado", required = true)@RequestParam(name = "id") int id,
			@Valid @RequestBody EmployerRequest body )throws InternalServerError, JsonProcessingException {
		
	
		return ResponseEntity.ok(service.updateEmployed(body,id));
		
	}
}
