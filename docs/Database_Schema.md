# Database Schema

## Auth Database (`nexus_auth_db`)

### Table: `users`

| Column | Type | Description |
|--------|------|-------------|
| id | UUID | Primary key |
| email | VARCHAR(255) | User's email (unique) |
| full_name | VARCHAR(255) | User's full name |
| index_number | VARCHAR(50) | Student/staff ID |
| password_hash | VARCHAR(255) | BCrypt encrypted password |
| preferred_language | VARCHAR(10) | Default 'en' |
| sign_dialect | VARCHAR(20) | Default 'ASL' |
| created_at | TIMESTAMP | Account creation time |
| updated_at | TIMESTAMP | Last update time |

## News Database (`nexus_news_db`) - Coming Soon

### Table: `health_ticker`

| Column | Type | Description |
|--------|------|-------------|
| entry_id | UUID | Primary key |
| headline | VARCHAR(300) | News title |
| summary | TEXT | News content |
| source | VARCHAR(120) | Source (WHO, CDC, etc.) |
| priority | INTEGER | 0=normal, 1=alert, 2=critical |