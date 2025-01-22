package Spring.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    // Class-level ArrayList to store elements
    private final List<String> elements = new ArrayList<>();

    @GetMapping("/")
    public String toGreet(HttpServletRequest req) {
        return "Session ID: " + req.getSession().getId();
    }

    @GetMapping("/token")
    public CsrfToken toGetToken(HttpServletRequest req) {
        return (CsrfToken) req.getAttribute("_csrf");
    }

    // Endpoint to return the list of stored elements
    @GetMapping("/list")
    public List<String> getElements() {
        return elements; // Return the list as a response
    }

    // Endpoint to add an element to the list
    @PostMapping("/list")
    public String addElement(@RequestBody String element) {
        elements.add(element);
        return "Element added: " + element;
    }

    // Endpoint to clear the list
    @DeleteMapping("/list")
    public String clearElements() {
        elements.clear();
        return "All elements cleared.";
    }
}
