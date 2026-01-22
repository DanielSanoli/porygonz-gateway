# porygonz-gateway

Gateway/API Gateway para rotear chamadas HTTP para os microserviços do ecossistema (Gym Leader, TypeMatch e Fusion IA), centralizando CORS e mantendo um contrato público único.

## Visão geral

Este serviço expõe uma API pública versionada em `/api/v1/**` e encaminha as requisições para os serviços internos:

- **Gym Leader (Pokedex)**: `/api/v1/pokemon/**`
- **TypeMatch (Comparador)**: `/api/v1/compare/**`
- **Fusion IA (Fusões)**: `/api/v1/fusions/**`

O gateway não faz “rewrite” de path (os serviços já expõem os endpoints versionados nativamente).

## Stack
- Java + Spring Boot
- Spring Cloud Gateway (WebFlux)

## Portas
- **8080** (padrão)

## Rotas (contrato público)

### Gym Leader (Pokedex)
- `GET /api/v1/pokemon/{idOrName}`

### TypeMatch (Comparador)
- `GET /api/v1/compare/{pokemonA}/{pokemonB}`

### Fusion IA
- `POST /api/v1/fusions`
- `GET /api/v1/fusions/{id}`
- `GET /api/v1/fusions/{id}/image` *(se implementado no fusion-ia-api)*

## Configuração (Environment Variables)

| Variável | Obrigatória | Padrão | Descrição |
|---|---:|---|---|
| `GYMLEADER_URI` | não | `http://localhost:8081` | Base URL do serviço Gym Leader |
| `TYPEMATCH_URI` | não | `http://localhost:8082` | Base URL do serviço TypeMatch |
| `FUSION_URI` | não | `http://localhost:8000` | Base URL do serviço Fusion IA |
| `CORS_ALLOWED_ORIGINS` | não | `http://localhost:4200` | Origins permitidos no CORS |

## Rodando local (sem Docker)
Requisitos:
- Java 21 (recomendado)
- Maven / Maven Wrapper

```bash
./mvnw spring-boot:run
```

## Rodando com Docker (via microservices-infra)
Recomendado rodar tudo pelo `microservices-infra` (Docker Compose).  
Ex.: `docker compose up -d --build` no repo de infra.

## Roadmap
- Healthcheck próprio do gateway (ex.: `/api/v1/health`)
- Timeouts e retries controlados
- Padronização de erros (error envelope)
- Observabilidade (logs estruturados, tracing)