package com.example.trade.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trade.models.StockTrade;
import com.example.trade.models.StockTradeDTO;
import com.example.trade.repositories.StockTradeRepository;

@Service
public class TradeService {

	@Autowired
	StockTradeRepository stockRepository;

	private static ModelMapper modelMapper = new ModelMapper();

	public StockTradeDTO createNewStock(StockTradeDTO stockTradeDto) throws java.text.ParseException {
		stockTradeDto.setId(null);

		StockTrade stockEntity = modelMapper.map(stockTradeDto, StockTrade.class);

		stockEntity = stockRepository.save(stockEntity);
		return getStockDto(stockEntity);
	}

	public List<StockTradeDTO> getStock() {

		return convertEntityToDTO(stockRepository.findAll());

	}

	public List<StockTradeDTO> filterBy(String type, Integer userId) {

		List<StockTrade> trades = stockRepository.findAll();

		if (type != null && userId != null) {
			// Filter trades by both type and userId
			trades = trades.stream().filter(t -> t.getType().equals(type) && t.getUserId() == userId)
					.collect(Collectors.toList());
		} else if (type != null) {
			// Filter trades by type
			trades = trades.stream().filter(t -> t.getType().equals(type)).collect(Collectors.toList());
		} else if (userId != null) {
			// Filter trades by userId
			trades = trades.stream().filter(t -> t.getUserId() == userId).collect(Collectors.toList());
		}

		return convertEntityToDTO(trades);
	}

	public StockTradeDTO getStockById(int id) {

		if (stockRepository.existsById(id)) {
			StockTrade stockTradeEntity = stockRepository.findById(id).get();

			return modelMapper.map(stockTradeEntity, StockTradeDTO.class);
		} else {
			return null;
		}

	}

	private List<StockTradeDTO> convertEntityToDTO(List<StockTrade> list) {
		List<StockTradeDTO> dtoList = new ArrayList<StockTradeDTO>();
		for (StockTrade stock : list) {
			dtoList.add(modelMapper.map(stock, StockTradeDTO.class));
		}

		return dtoList;
	}

	private StockTradeDTO getStockDto(StockTrade stockEntity) {
		StockTradeDTO w = modelMapper.map(stockEntity, StockTradeDTO.class);

		return w;
	}

}
