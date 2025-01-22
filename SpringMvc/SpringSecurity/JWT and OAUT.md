

### **1. OAuth2 in Spring Security**

#### **What is OAuth2?**  
OAuth2 (Open Authorization) is an open standard for access delegation. It allows users to grant third-party applications limited access to their resources (like profile information) without sharing credentials.

#### **Key Concepts in OAuth2:**

1. **Resource Owner (User):**  
   The person who owns the data or resources.
   - Example: A user who wants to grant access to their Google Calendar.

2. **Client Application (Third-Party App):**  
   The application requesting access to the user's resources.
   - Example: A meeting scheduler app needing access to your Google Calendar.

3. **Authorization Server:**  
   The server responsible for authenticating the user and issuing access tokens.
   - Example: Google's OAuth server.

4. **Resource Server:**  
   The server hosting the user's resources and verifying access tokens.
   - Example: Google's Calendar API.

5. **Access Token:**  
   A token issued to the client application, allowing access to the user's resources for a limited time.

---

#### **How OAuth2 Works:**

1. **User Authorization:**  
   The user logs in to the authorization server and consents to the third-party app's access request.

2. **Authorization Code:**  
   The authorization server provides the third-party app with an authorization code.

3. **Access Token Request:**  
   The third-party app exchanges the authorization code for an access token.

4. **Access Resource:**  
   The third-party app uses the access token to retrieve resources from the resource server.

---

#### **Spring Security and OAuth2 Example**

1. **Add Dependencies:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
```

2. **Configure OAuth2 in `application.properties`:**

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=email,profile
spring.security.oauth2.client.provider.google.authorization-uri=https://accounts.google.com/o/oauth2/auth
spring.security.oauth2.client.provider.google.token-uri=https://oauth2.googleapis.com/token
spring.security.oauth2.client.provider.google.user-info-uri=https://www.googleapis.com/oauth2/v3/userinfo
```

3. **Create Security Configuration:**

```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .oauth2Login()
            .defaultSuccessUrl("/home", true);
    }
}
```

4. **Flow:**  
   - Users can log in using their Google account.
   - Spring Security manages the token exchange and provides user details.

---

#### **Real-World Example:**

**E-Commerce Site Login:**  
You want to log in to an online store using your Google account. The store redirects you to Google's login page. After login, Google sends an access token back to the store, which uses it to fetch your basic profile information.

---

### **2. JWT (JSON Web Tokens)**

#### **What is JWT?**  
JWT is a compact, URL-safe token format used for securely transmitting information between parties. It is commonly used for stateless authentication.

#### **Key Features:**
1. **Stateless:**  
   No server-side session storage is required.  
2. **Self-Contained:**  
   The token contains all the necessary information, including the user's identity and roles.

---

#### **Structure of JWT:**

1. **Header:**  
   Metadata about the token (e.g., algorithm used).  
   ```json
   { "alg": "HS256", "typ": "JWT" }
   ```

2. **Payload:**  
   The actual data (e.g., user details, roles).  
   ```json
   { "sub": "user@example.com", "role": "USER", "exp": 1618880000 }
   ```

3. **Signature:**  
   Ensures the token's integrity using a secret key.  

   ```plaintext
   HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)
   ```

---

#### **How JWT Works in Authentication:**

1. **Login:**  
   The user logs in and provides their credentials.

2. **Token Issuance:**  
   The server validates the credentials and issues a JWT containing user information and roles.

3. **Token Usage:**  
   The client sends the token with every request in the `Authorization` header.  
   Example:  
   ```plaintext
   Authorization: Bearer <JWT_TOKEN>
   ```

4. **Validation:**  
   The server validates the token before processing the request.

---

#### **Spring Security and JWT Example**

1. **Add Dependencies:**

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
```

2. **Generate a JWT Token:**

```java
public String generateToken(UserDetails userDetails) {
    return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .claim("roles", userDetails.getAuthorities())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
        .signWith(SignatureAlgorithm.HS256, "secret_key")
        .compact();
}
```

3. **Verify the Token:**

```java
public Claims validateToken(String token) {
    return Jwts.parser()
        .setSigningKey("secret_key")
        .parseClaimsJws(token)
        .getBody();
}
```

4. **Configure Security:**

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationManager()));
}
```

---

#### **Real-World Example:**

**Banking App:**  
Once you log in, the bank's mobile app issues a JWT. The app uses this token for subsequent requests, such as checking your balance or transferring funds, without requiring you to log in again.

---

### **3. Comparing OAuth2 and JWT**

| Feature            | OAuth2                                 | JWT                                     |
|--------------------|----------------------------------------|-----------------------------------------|
| Purpose            | Delegating access to resources        | Stateless authentication               |
| Token Type         | Access Token                          | JSON Web Token                         |
| Example Use Case   | Login with Google                     | Secure APIs in microservices           |
| Validation         | Token verification with server calls  | Token validation using cryptographic keys |

---

### **4. Tips and Best Practices**

1. Use **short expiration times** for access tokens.
2. Always validate JWT signatures to ensure integrity.
3. Protect sensitive endpoints with HTTPS.
4. For OAuth2, use refresh tokens to minimize repeated logins.

