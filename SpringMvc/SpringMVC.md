### **Spring MVC Annotations Explained**

Spring MVC uses a wide range of annotations to facilitate the development of web applications. Here’s a detailed explanation of commonly used Spring MVC annotations and how to use them:

### **1. @Controller**
- **Purpose**: Marks a class as a Spring MVC controller where `@RequestMapping` methods assume `@ResponseBody` semantics by default.
- **Usage**:
  ```java
  @Controller
  public class MyController {
      @RequestMapping("/home")
      public String home() {
          return "home"; // Returns view name
      }
  }
  ```

### **2. @RestController**
- **Purpose**: A specialized version of `@Controller` that combines `@Controller` and `@ResponseBody`. It is used to create RESTful web services.
- **Usage**:
  ```java
  @RestController
  public class MyRestController {
      @GetMapping("/data")
      public String getData() {
          return "Hello, World!"; // Returns data directly
      }
  }
  ```

### **3. @RequestMapping**
- **Purpose**: Used to map web requests to specific handler methods or classes.
- **Attributes**:
  - `value`: The URL pattern.
  - `method`: HTTP request methods (GET, POST, etc.).
- **Usage**:
  ```java
  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
  public String welcome() {
      return "welcome"; // Maps to GET /welcome
  }
  ```

### **4. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping**
- **Purpose**: Shorthand for `@RequestMapping` with `method` attribute set to specific HTTP methods (GET, POST, PUT, DELETE).
- **Usage**:
  ```java
  @GetMapping("/get")
  public String getMethod() {
      return "GET Method";
  }

  @PostMapping("/post")
  public String postMethod() {
      return "POST Method";
  }
  ```

### **5. @PathVariable**
- **Purpose**: Binds a URI template variable to a method parameter.
- **Usage**:
  ```java
  @GetMapping("/user/{id}")
  public String getUser(@PathVariable int id) {
      return "User ID: " + id;
  }
  ```

### **6. @RequestParam**
- **Purpose**: Binds a request parameter to a method parameter.
- **Usage**:
  ```java
  @GetMapping("/search")
  public String search(@RequestParam String query) {
      return "Search Query: " + query;
  }
  ```

### **7. @RequestBody**
- **Purpose**: Binds the body of the HTTP request to a method parameter.
- **Usage**:
  ```java
  @PostMapping("/add")
  public String add(@RequestBody Product product) {
      return "Product added: " + product.getName();
  }
  ```

### **8. @ResponseBody**
- **Purpose**: Indicates that the return value of a method should be bound to the web response body.
- **Usage**:
  ```java
  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {
      return "Hello, World!";
  }
  ```

### **9. @ModelAttribute**
- **Purpose**: Binds a method parameter or a return value to a named model attribute, and then exposes it to a web view.
- **Usage**:
  ```java
  @ModelAttribute("user")
  public User createUserModel() {
      return new User();
  }

  @RequestMapping("/form")
  public String showForm(@ModelAttribute("user") User user) {
      return "form";
  }
  ```

### **10. @CrossOrigin**
- **Purpose**: Enables cross-origin resource sharing (CORS) for RESTful services.
- **Usage**:
  ```java
  @RestController
  @CrossOrigin(origins = "http://example.com")
  public class MyRestController {
      // Methods
  }
  ```

### **11. @ExceptionHandler**
- **Purpose**: Defines a method to handle specific exceptions.
- **Usage**:
  ```java
  @ExceptionHandler(Exception.class)
  public String handleException(Exception e) {
      return "Error: " + e.getMessage();
  }
  ```

### **12. @ControllerAdvice**
- **Purpose**: Used for global exception handling, model binding, etc., across multiple controllers.
- **Usage**:
  ```java
  @ControllerAdvice
  public class GlobalExceptionHandler {
      @ExceptionHandler(Exception.class)
      public String handleException(Exception e) {
          return "Global Error: " + e.getMessage();
      }
  }
  ```

### **13. @Valid**
- **Purpose**: Used to trigger validation on an object.
- **Usage**:
  ```java
  @PostMapping("/submit")
  public String submitForm(@Valid @ModelAttribute("form") Form form, BindingResult result) {
      if (result.hasErrors()) {
          return "errorPage";
      }
      return "successPage";
  }
  ```

### **14. @RequestHeader**
- **Purpose**: Binds a request header to a method parameter.
- **Usage**:
  ```java
  @GetMapping("/headers")
  public String getHeader(@RequestHeader("User-Agent") String userAgent) {
      return "User-Agent: " + userAgent;
  }
  ```

### **15. @CookieValue**
- **Purpose**: Binds a cookie value to a method parameter.
- **Usage**:
  ```java
  @GetMapping("/cookie")
  public String getCookie(@CookieValue("sessionId") String sessionId) {
      return "Session ID: " + sessionId;
  }
  ```

### **16. @SessionAttributes**
- **Purpose**: Indicates which model attributes should be stored in the session between requests.
- **Usage**:
  ```java
  @Controller
  @SessionAttributes("user")
  public class MyController {
      // Methods
  }
  ```

### **17. @InitBinder**
- **Purpose**: Customizes the binding of request parameters to method arguments.
- **Usage**:
  ```java
  @InitBinder
  public void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
  }
  ```

By understanding and using these annotations effectively, you can build robust and scalable Spring MVC applications.
