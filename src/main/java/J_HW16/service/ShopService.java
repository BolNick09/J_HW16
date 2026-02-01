package J_HW16.service;

import J_HW16.model.Shop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final List<Shop> shops = new ArrayList<>();
    private long nextId = 1;

    public List<Shop> findAll() { return shops; }

    public Shop findById(Long id) {
        return shops.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Shop shop) {
        shop.setId(nextId++);
        shops.add(shop);
    }

    public void update(Shop shop) {
        delete(shop.getId());
        shops.add(shop);
    }

    public void delete(Long id) {
        shops.removeIf(s -> s.getId().equals(id));
    }

    public List<Shop> search(String q) {
        q = q.toLowerCase();
        String finalQ = q;
        return shops.stream()
                .filter(s ->
                        s.getName().toLowerCase().contains(finalQ) ||
                                s.getCategory().toLowerCase().contains(finalQ) ||
                                s.getAddress().toLowerCase().contains(finalQ))
                .toList();
    }
}