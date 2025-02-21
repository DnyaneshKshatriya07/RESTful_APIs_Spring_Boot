package com.example.trade.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trade.models.StockTradeDTO;
import com.example.trade.services.TradeService;

@RestController
@RequestMapping(path = "/trades")
public class StockTradeRestController {

	@Autowired
	TradeService tradeService;

	@GetMapping("/")
	public ResponseEntity<?> getFilters(@RequestParam(required = false) String type,
			@RequestParam(required = false) Integer userId) {

		List<StockTradeDTO> weathers = new ArrayList<>();

		if (type != null || userId != null) {

			weathers = tradeService.filterBy(type, userId);
			return ResponseEntity.ok(weathers);
		}

		return ResponseEntity.ok(tradeService.getStock());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getWeatherById(@PathVariable int id) {

		StockTradeDTO trade = tradeService.getStockById(id);

		if (trade != null) {
			return new ResponseEntity<>(trade, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> createStock(@RequestBody StockTradeDTO weather) throws ParseException {
		StockTradeDTO w = tradeService.createNewStock(weather);
		return new ResponseEntity<>(w, HttpStatus.CREATED);
	}

}