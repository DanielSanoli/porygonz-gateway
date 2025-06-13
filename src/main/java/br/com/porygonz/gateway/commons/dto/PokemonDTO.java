package br.com.porygonz.gateway.commons.dto;

import java.util.List;
import java.util.Map;

public record PokemonDTO(
    Long id,
    String name,
    List<String> types,
    int height,
    String spriteUrl,
    Map<String, Integer> stats
) {}
