# Nexus Backend Deployment Guide


### Prerequisites
- Java 21 or higher
- Maven (or use included Maven wrapper)

### Option 1: Development Mode (H2 Database)

No database setup required! Perfect for testing.

```bash
# Clone the repository
git clone https://github.com/narh-emma/nexus-backend.git
cd nexus-backend

# Run with dev profile (uses H2 in-memory database)
mvn spring-boot:run