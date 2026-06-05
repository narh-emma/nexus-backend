# Nexus API Documentation

## Base URL
`http://localhost:8081/api/v1`

## Swagger URL
`http://localhost:8081/swagger-ui.html`

## H2 Console URL
`http://localhost:8081/h2-console`

## Authentication
Most endpoints require a JWT token in the Authorization header:
`Authorization: Bearer your-token-here`

## Endpoints

### Auth Service

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/auth/register` | Register new user | No |
| POST | `/auth/login` | Login & get token | No |
| GET | `/auth/verify` | Verify JWT token | Yes |
| GET | `/auth/health` | Health check | No |

### News Service 

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/health/news` | Get latest health news | Yes |
| GET | `/health/news/{id}` | Get single news article | Yes |
| POST | `/health/news` | Add news article (Admin) | Yes |

### Media Service (Coming Soon)

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/media/first-aid` | List first-aid videos | Yes |
| POST | `/media/first-aid` | Upload video (Admin) | Yes |

### Translate Service (Coming Soon)

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/translate/text-to-sign` | Convert text to sign language | Yes |
| POST | `/translate/speech-to-text` | Convert speech to text | Yes |