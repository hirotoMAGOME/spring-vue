package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Currency;

import java.util.List;

@Getter
@Builder
public class CurrencyResponse {

    private List<Currency> currencies;
}