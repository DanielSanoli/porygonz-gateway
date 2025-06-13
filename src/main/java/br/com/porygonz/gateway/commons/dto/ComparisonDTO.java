package br.com.porygonz.gateway.commons.dto;

import java.util.Map;

public record ComparisonDTO(
    PokemonDTO pokemon1,  
    PokemonDTO pokemon2,
    String advantageDescription,
    PokemonDTO predictedWinner,
    Map<String, Double> effect
) {}
