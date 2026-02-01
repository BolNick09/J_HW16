package J_HW16.service;

import J_HW16.model.Shop;
import J_HW16.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public List<Shop> findAll() {
        return repository.findAll();
    }

    public Shop findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Shop shop) {
        repository.save(shop);
    }

    public void update(Shop shop) {
        repository.save(shop);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Shop> search(String q) {
        return repository
                .findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrAddressContainingIgnoreCase(
                        q, q, q
                );
    }
}