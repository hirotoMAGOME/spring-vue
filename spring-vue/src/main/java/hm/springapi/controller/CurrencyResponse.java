package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.Currency;

@Getter
@Builder
public class CurrencyResponse {

    private List<Currency> currencies;
}