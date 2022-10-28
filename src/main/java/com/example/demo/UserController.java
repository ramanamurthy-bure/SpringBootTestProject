package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
	1. Get All users(GET) -> http://localhost:8080/users                     
	 	-> Here '/users' is end point
	2. Get Specific User(GET) -> http://localhost:8080/users/UserID
		-> Here UserID is path parameter
	3. Get all users in specific page(GET)->http://localhost:8080/users?page=1&limit=50
		-> Here page and limit are query parameters
*/
@RestController
@RequestMapping("/users")
public class UserController {
	/*
	 * @GetMapping public String getUsers() { return "http GET request was sent"; }
	 */
	@GetMapping(path = "/{userID}") // Path Parameter
	public String getSpecific(@PathVariable String userID) {
		return "http GET request was sent for user ID : " + userID;
	}
	@GetMapping
	public String getUsersWithQueryParam(@RequestParam(value = "page") int pageno, @RequestParam(value = "limit") int limitno) // Query Parameter
	{
		return "http GET request was sent for page : " + pageno + " and limit : " + limitno;
	}
	@PostMapping
	public String createUser() {
		return "http POST request was sent";
	}
	@PutMapping
	public String updateUser() {
		return "http PUT request was sent";
	}
	@DeleteMapping
	public String deleteUser() {
		return "http DELETE request was sent";
	}
}
