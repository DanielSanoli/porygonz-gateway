package br.com.porygonz.gateway.commons.dto;

import java.time.LocalDateTime;
import java.util.List;

public record FusionResultDTO(
    String fusionName,
    String imageUrl,
    List<String> parentNames,
    LocalDateTime dateCreated
) {}
