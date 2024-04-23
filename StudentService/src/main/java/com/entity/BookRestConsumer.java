package com.entity;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="BOOK-SERVICE",url="${book}")
public interface BookRestConsumer {
	
	@GetMapping("/getBooks")
	public List<Book> getBooks();
	
}
