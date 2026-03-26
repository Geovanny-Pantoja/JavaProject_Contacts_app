/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Controller that maps / and /home to the index view.
*/
package edu.pantoja.rolodex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping({"/", "/home"})
    public String homePage() {
        return "index";
    }

}
