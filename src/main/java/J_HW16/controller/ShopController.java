package J_HW16.controller;

import J_HW16.model.Shop;
import J_HW16.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping
    public String list(
            @RequestParam(name = "q", required = false) String q,
            Model model) {

        model.addAttribute("shops",
                q == null ? service.findAll() : service.search(q));

        return "list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("shop", new Shop());
        return "form";
    }

    @PostMapping
    public String create(@ModelAttribute Shop shop) {
        service.save(shop);
        return "redirect:/shops";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("shop", service.findById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("shop", service.findById(id));
        return "form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Shop shop) {
        shop.setId(id);
        service.update(shop);
        return "redirect:/shops";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/shops";
    }
}