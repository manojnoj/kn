# kn

Spring Boot backend secured with AWS Cognito (JWT resource server).

## Prerequisites
- Java 17+
- Maven 3.9+
- AWS Cognito User Pool and App Client (with a configured domain)

## Configure
Set the Cognito issuer URI from your user pool. Format:
```
https://cognito-idp.<region>.amazonaws.com/<userPoolId>
```

Export the issuer URI before running:
```bash
export COGNITO_ISSUER_URI="https://cognito-idp.<region>.amazonaws.com/<userPoolId>"
```

## Run
```bash
mvn spring-boot:run
```

## Endpoints
- `GET /` public status
- `GET /health` public health check
- `GET /api/secure` protected endpoint (requires a valid Cognito JWT access token)

## Example request
```bash
curl -H "Authorization: Bearer <ACCESS_TOKEN>" http://localhost:8080/api/secure
```

## Notes
- The app uses Spring Security's OAuth2 Resource Server with JWT validation.
- Configure Cognito to issue access tokens with the correct issuer and audience for your app client.
