package br.com.porygonz.gateway.commons.dto;

import java.util.List;

public record FusionRequestDTO(
    List<Long> pokemonIds,
    String customName 
) {}