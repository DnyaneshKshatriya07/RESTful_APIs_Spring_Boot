package com.example.trade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trade.models.StockTrade;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Integer> {
}
