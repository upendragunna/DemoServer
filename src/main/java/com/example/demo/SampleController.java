package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class SampleController {

	@RequestMapping(path = "/healthcheck")
	public String healthCheck() {
		return "OK";
	}

	@RequestMapping("/get")
	public Person getPerson(@RequestParam(name = "name", required = false, defaultValue = "Unknown") String name) {
		Person person = new Person();
		person.setName(name);
		return person;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Person updatePerson(@RequestBody(required = true) Person person) {
		//Person person = new Person();
		//person.setName(name);
		person.setName(person.getName()+" Response");
		return person;
	}

}
