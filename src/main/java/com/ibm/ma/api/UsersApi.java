package com.ibm.ma.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "users")
public interface UsersApi {

	@ApiOperation(value = "Get user by Id", notes = "", response = Object.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Object.class) })
    
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Object> getUserById(@ApiParam(value = "",required=true ) @PathVariable("id") String id,@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=false) String authorization) {
        // do some magic!
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
